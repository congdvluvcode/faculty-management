package fplhn.udpm.quanlygiangvien.core.quanlychucvu.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.PageChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request.CVCreateChucVuRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request.CVFindChucVuRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.response.CVChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.repository.CVChucVuRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.service.CVChucVuService;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.repository.CSCoSoRepository;
import fplhn.udpm.quanlygiangvien.entity.ChucVu;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CVChucVuServiceImpl implements CVChucVuService {

    private final CVChucVuRepository cvChucVuRepository;

    private final CSCoSoRepository csCoSoRepository;

    @Override
    public PageChucVuResponse getAllChucVuByIdCoSo(CVFindChucVuRequest cvFindChucVuRequest) {
        Pageable pageable = PageRequest.of(cvFindChucVuRequest.getPageNo()-1,cvFindChucVuRequest.getPageSize());

        Page<CVChucVuResponse> pageChucVu = cvChucVuRepository.paginateAndSearch(pageable, cvFindChucVuRequest.getIdCoSo(), cvFindChucVuRequest.getTenChucVu());

        List<CVChucVuResponse> listOfProduct = pageChucVu.getContent();
//        PageChucVuResponse pageChucVuResponse = new PageChucVuResponse();
//        pageChucVuResponse.setContent(listOfProduct);
//        pageChucVuResponse.setPageSize(pageChucVu.getSize());
//        pageChucVuResponse.setPageNo(pageChucVu.getNumber());
//        pageChucVuResponse.setTotalPages(pageChucVu.getTotalPages());
//        pageChucVuResponse.setLast(pageChucVu.isLast());
//        pageChucVuResponse.setTotalElement(pageChucVu.getTotalElements());
        PageChucVuResponse pageChucVuResponse = new PageChucVuResponse(listOfProduct,pageChucVu.getNumber(),pageChucVu.getSize(),
                pageChucVu.getTotalPages(),pageChucVu.getTotalElements(),pageChucVu.isLast());
        return pageChucVuResponse;
    }

    @Override
    public ResponseModel addChucVu(CVCreateChucVuRequest cvCreateChucVuRequest) {
        Optional<CoSo> coSoOptional = csCoSoRepository.findById(cvCreateChucVuRequest.getIdCoSo());
        if(coSoOptional.isEmpty()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Cơ sở không tồn tại");
        }
        if(cvChucVuRepository.existsByTenAndCoSo(cvCreateChucVuRequest.getTenChucVu(),coSoOptional.get())){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Tên chức vụ đã tồn tại");
        }
        ChucVu chucVu = new ChucVu();
        chucVu.setTen(cvCreateChucVuRequest.getTenChucVu());
        chucVu.setCoSo(coSoOptional.get());
        chucVu.setXoaMem(XoaMem.CHUA_XOA);
        cvChucVuRepository.save(chucVu);
        return new ResponseModel(HttpStatus.CREATED,"Thêm thành công");
    }

    @Override
    public ResponseModel updateChucVu(CVCreateChucVuRequest cvCreateChucVuRequest,Long idChucVu) {
        Optional<CoSo> coSoOptional = csCoSoRepository.findById(cvCreateChucVuRequest.getIdCoSo());
        if(!coSoOptional.isPresent()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Cơ sở không tồn tại");
        }
        if(cvChucVuRepository.existsByTenAndCoSo(cvCreateChucVuRequest.getTenChucVu(),coSoOptional.get())){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Tên chức vụ đã tồn tại");
        }
        ChucVu chucVu = new ChucVu();
        chucVu.setTen(cvCreateChucVuRequest.getTenChucVu());
        chucVu.setCoSo(coSoOptional.get());
        chucVu.setId(idChucVu);
        cvChucVuRepository.save(chucVu);
        return new ResponseModel(HttpStatus.OK,"Sửa thành công");

    }

    @Override
    public ResponseModel deleteChucVu(Long idChucVu) {
        Optional<ChucVu> chucVuOptional = cvChucVuRepository.findById(idChucVu);
        if(chucVuOptional.isEmpty()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Chức vụ không tồn tại");
        }
        if(chucVuOptional.get().getXoaMem().equals(XoaMem.CHUA_XOA)){
            chucVuOptional.get().setXoaMem(XoaMem.DA_XOA);
        }else{
            chucVuOptional.get().setXoaMem(XoaMem.CHUA_XOA);
        }
        cvChucVuRepository.save(chucVuOptional.get());
        return new ResponseModel(HttpStatus.OK,"Xóa thành công");
    }

}
