package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.PageBoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request.BMCSCreateBoMonTheoCoSoRequets;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request.BMCSFindBoMonTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSBoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository.BMCSBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository.BMCSBoMonTheoCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository.BMCSNhanVienRepository;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.service.BMCSBoMonTheoCoSoService;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.repository.CSCoSoRepository;
import fplhn.udpm.quanlygiangvien.entity.BoMon;
import fplhn.udpm.quanlygiangvien.entity.BoMonTheoCoSo;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.entity.NhanVien;
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
public class BMCSBoMonTheoCoSoServiceImpl implements BMCSBoMonTheoCoSoService {

    private final BMCSBoMonTheoCoSoRepository bmcsBoMonTheoCoSoRepository;

    private final CSCoSoRepository csCoSoRepository;

    private final BMCSBoMonRepository boMonRepository;

    private final BMCSNhanVienRepository nhanVienRepository;


    @Override
    public PageBoMonTheoCoSoResponse paginateAndSearch(BMCSFindBoMonTheoCoSoRequest bmcsFindBoMonTheoCoSoRequest) {
        Pageable pageable = PageRequest.of(bmcsFindBoMonTheoCoSoRequest.getPageNo()-1,bmcsFindBoMonTheoCoSoRequest.getPageSize());

        Long start = bmcsFindBoMonTheoCoSoRequest.getPageSize()*(bmcsFindBoMonTheoCoSoRequest.getPageNo())*1L;

        Page<BMCSBoMonTheoCoSoResponse> coSoPage = bmcsBoMonTheoCoSoRepository.paginateAndSearch(pageable,bmcsFindBoMonTheoCoSoRequest.getIdCoSo(), bmcsFindBoMonTheoCoSoRequest.getTenBoMon(),start);

        // Lấy danh sách sản phẩm từ trang kết quả
        List<BMCSBoMonTheoCoSoResponse> listOfProduct = coSoPage.getContent();

        PageBoMonTheoCoSoResponse pageBoMonTheoCoSoResponse = new PageBoMonTheoCoSoResponse(listOfProduct,coSoPage.getNumber(),coSoPage.getSize(),
                coSoPage.getTotalPages(),coSoPage.getTotalElements(),coSoPage.isLast());
        return pageBoMonTheoCoSoResponse;
    }

    @Override
    public ResponseModel addBoMonTheoCoSo(BMCSCreateBoMonTheoCoSoRequets bmcsCreateBoMonTheoCoSoRequets) {
        Optional<CoSo> coSoOptional = csCoSoRepository.findById(bmcsCreateBoMonTheoCoSoRequets.getIdCoSo());
        BoMonTheoCoSo boMonTheoCoSo = new BoMonTheoCoSo();
        if(!coSoOptional.isPresent()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Cơ sở không tồn tại");
        }
        Optional<BoMon> boMonOptional = boMonRepository.findById(bmcsCreateBoMonTheoCoSoRequets.getIdBoMon());
        if(!boMonOptional.isPresent()){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Bộ môn không tồn tại");
        }
        if((bmcsCreateBoMonTheoCoSoRequets.getIdTruongBoMon()!=null) && (bmcsCreateBoMonTheoCoSoRequets.getIdTruongBoMon()!=0)){
            Optional<NhanVien> nhanVienOptional = nhanVienRepository.findById(bmcsCreateBoMonTheoCoSoRequets.getIdTruongBoMon());
            boMonTheoCoSo.setNhanVien(nhanVienOptional.get());
        }
        if(bmcsBoMonTheoCoSoRepository.existsByBoMonAndCoSo(boMonOptional.get(),coSoOptional.get())){
            return new ResponseModel(HttpStatus.NOT_ACCEPTABLE,"Bộ môn đã tồn tại ở cơ sở này");
        }
        boMonTheoCoSo.setBoMon(boMonOptional.get());
        boMonTheoCoSo.setCoSo(coSoOptional.get());
        boMonTheoCoSo.setXoaMem(XoaMem.CHUA_XOA);
        bmcsBoMonTheoCoSoRepository.save(boMonTheoCoSo);
        return new ResponseModel(HttpStatus.CREATED,"Thêm thành công");
    }

    @Override
    public ResponseModel updateXoaMemBoMonTheoCoSo(Long idBoMonTheoSoCo) {
        Optional<BoMonTheoCoSo> boMonTheoCoSo = bmcsBoMonTheoCoSoRepository.findById(idBoMonTheoSoCo);
        boMonTheoCoSo.get().setXoaMem( boMonTheoCoSo.get().getXoaMem().equals(XoaMem.CHUA_XOA)?XoaMem.DA_XOA:XoaMem.CHUA_XOA);
        bmcsBoMonTheoCoSoRepository.save(boMonTheoCoSo.get());
        return new ResponseModel(HttpStatus.OK,"Sửa thành công");
    }
}
