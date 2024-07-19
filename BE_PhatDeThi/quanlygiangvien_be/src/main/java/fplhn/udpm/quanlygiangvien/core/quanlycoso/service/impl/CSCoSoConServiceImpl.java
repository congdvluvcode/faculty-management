package fplhn.udpm.quanlygiangvien.core.quanlycoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoConResponse;
import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoConRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoConRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoConResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.repository.CSCoSoConRepository;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.repository.CSCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.service.CSCoSoConService;
import fplhn.udpm.quanlygiangvien.entity.Campus;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CSCoSoConServiceImpl implements CSCoSoConService {

    private final CSCoSoConRepository csCoSoConRepository;

    private final CSCoSoRepository csCoSoRepository;

    @Override
    public PageCoSoConResponse getAllCoSoConByIdCoSo(CSFindCoSoConRequest csFindCoSoConRequest,Long idCoSo) {
        Pageable pageable = PageRequest.of(csFindCoSoConRequest.getPageNo()-1,csFindCoSoConRequest.getPageSize());
        Set<String> list = new HashSet<>();
        for (String x : csFindCoSoConRequest.getListTenCoSoCon()){
            list.addAll(csCoSoConRepository.searchName(x));
        }
        System.out.println(csFindCoSoConRequest.getListTenCoSoCon());
        if(list.isEmpty()) list.addAll(csCoSoConRepository.searchName(""));
        Page<CSCoSoConResponse> coSoConPage = csCoSoConRepository.paginateAndSearch(pageable,list,idCoSo);

        // Lấy danh sách sản phẩm từ trang kết quả
        List<CSCoSoConResponse> listOfCoSoCon = coSoConPage.getContent();

        PageCoSoConResponse pageCoSoConResponse = new PageCoSoConResponse(listOfCoSoCon,coSoConPage.getNumber(),coSoConPage.getSize(),
                coSoConPage.getTotalPages(),coSoConPage.getTotalElements(),coSoConPage.isLast());
        return pageCoSoConResponse;
    }

    @Override
    public ResponseModel addCoSoCon(CSCreateCoSoConRequest csCreateCoSoConRequest) {
        if(csCoSoConRepository.existsByTen(csCreateCoSoConRequest.getTenCoSoCon())){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Tên Cơ sở con đã tồn tại");
        }
        Optional<CoSo> coSoOptional = csCoSoRepository.findById(csCreateCoSoConRequest.getIdCoSo());
        if(!coSoOptional.isPresent()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Cơ sở không tồn tại");
        }
        Campus campus = new Campus();
        campus.setTen(csCreateCoSoConRequest.getTenCoSoCon());
        campus.setXoaMem(XoaMem.CHUA_XOA);
        campus.setCoSo(coSoOptional.get());
        csCoSoConRepository.save(campus);
        return new ResponseModel(HttpStatus.CREATED,"Thêm thành công");
    }

    @Override
    public ResponseModel updateCoSoCon(CSCreateCoSoConRequest csCreateCoSoConRequest, Long idCoSoCon) {
        if(csCoSoConRepository.existsByTen(csCreateCoSoConRequest.getTenCoSoCon())){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Tên Cơ sở con đã tồn tại");
        }
        Optional<CoSo> coSoOptional = csCoSoRepository.findById(csCreateCoSoConRequest.getIdCoSo());
        if(!coSoOptional.isPresent()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Cơ sở không tồn tại");
        }
        Optional<Campus> campusOptional = csCoSoConRepository.findById(csCreateCoSoConRequest.getIdCoSo());
        if(!campusOptional.isPresent()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Cơ sở con không tồn tại");
        }
        Campus campus = new Campus();
        campus.setTen(csCreateCoSoConRequest.getTenCoSoCon());
        campus.setXoaMem(campusOptional.get().getXoaMem());
        campus.setCoSo(coSoOptional.get());
        campus.setId(idCoSoCon);
        csCoSoConRepository.save(campus);
        return new ResponseModel(HttpStatus.OK,"Sửa thành công");
    }

    @Override
    public ResponseModel updateXoaMemCoSoCon(Long idCoSoCon) {
        boolean tonTai = csCoSoConRepository.existsById(idCoSoCon);

        if (tonTai) {
            Optional<Campus> campusOptional = csCoSoConRepository.findById(idCoSoCon);
            campusOptional.get().setXoaMem(campusOptional.get().getXoaMem().equals(XoaMem.CHUA_XOA)?XoaMem.DA_XOA:XoaMem.CHUA_XOA);
            csCoSoConRepository.save(campusOptional.get());
            return new ResponseModel(HttpStatus.OK, "Cập nhật thành công");
        } else {
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE, "Cơ sở con không tồn tại");
        }
    }

}
