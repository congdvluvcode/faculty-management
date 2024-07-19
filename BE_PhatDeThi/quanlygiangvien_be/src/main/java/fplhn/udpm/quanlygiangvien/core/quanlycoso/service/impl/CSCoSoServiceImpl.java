package fplhn.udpm.quanlygiangvien.core.quanlycoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.repository.CSCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.service.CSCoSoService;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import jakarta.validation.constraints.Null;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CSCoSoServiceImpl implements CSCoSoService {

    private final CSCoSoRepository csCoSoRepository;

    @Override
    public PageCoSoResponse getAllCoSo(CSFindCoSoRequest csFindCoSoRequest) {
        Pageable pageable = PageRequest.of(csFindCoSoRequest.getPageNo()-1,csFindCoSoRequest.getPageSize());
        Set<String> list = new HashSet<>();
        for (String x : csFindCoSoRequest.getListTenCoSo()){
            list.addAll(csCoSoRepository.searchName(x));
        }
        if(list.isEmpty()) list.addAll(csCoSoRepository.searchName(""));

        Long start = csFindCoSoRequest.getPageSize()*(csFindCoSoRequest.getPageNo()-1)*1L;
        Page<CSCoSoResponse> coSoPage = csCoSoRepository.paginateAndSearch(pageable,list,start);

        // Lấy danh sách sản phẩm từ trang kết quả
        List<CSCoSoResponse> listOfProduct = coSoPage.getContent();

        PageCoSoResponse pageCoSoResponse = new PageCoSoResponse(listOfProduct,coSoPage.getNumber(),coSoPage.getSize(),
                coSoPage.getTotalPages(),coSoPage.getTotalElements(),coSoPage.isLast());
        return pageCoSoResponse;
    }

    @Override
    public List<CSCoSoResponse> getAll() {
        return csCoSoRepository.getAll();
    }

    @Override
    public ResponseModel addCoSo(CSCreateCoSoRequest csCreateCoSoRequest) {

        if(csCoSoRepository.existsByTen(csCreateCoSoRequest.getTenCoSo())){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Tên Cơ sở đã tồn tại");
        }
        CoSo coSo = new CoSo();
        coSo.setTen(csCreateCoSoRequest.getTenCoSo());
        coSo.setXoaMem(XoaMem.CHUA_XOA);
        csCoSoRepository.save(coSo);
        return new ResponseModel(HttpStatus.CREATED,"Thêm thành công");
    }

    @Override
    public ResponseModel updateCoSo(CSCreateCoSoRequest csCreateCoSoRequest, Long id) {
        if(csCoSoRepository.existsByTen(csCreateCoSoRequest.getTenCoSo())){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Tên Cơ sở đã tồn tại");
        }
        boolean tonTai = csCoSoRepository.existsById(id);

        if (tonTai) {
            Optional<CoSo> coSoOptional = csCoSoRepository.findById(id);
            coSoOptional.get().setXoaMem(coSoOptional.get().getXoaMem());
            coSoOptional.get().setTen(csCreateCoSoRequest.getTenCoSo());
            csCoSoRepository.save(coSoOptional.get());
            return new ResponseModel(HttpStatus.OK, "Cập nhật thành công");
        } else {
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE, "Cơ sở không tồn tại");
        }
    }

    @Override
    public ResponseModel updateXoaMemCoSo(Long id) {
        boolean tonTai = csCoSoRepository.existsById(id);

        if (tonTai) {
            Optional<CoSo> coSoOptional = csCoSoRepository.findById(id);
            coSoOptional.get().setXoaMem(coSoOptional.get().getXoaMem().equals(XoaMem.CHUA_XOA)?XoaMem.DA_XOA:XoaMem.CHUA_XOA);
            csCoSoRepository.save(coSoOptional.get());
            return new ResponseModel(HttpStatus.OK, "Cập nhật thành công");
        } else {
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE, "Cơ sở không tồn tại");
        }
    }

}
