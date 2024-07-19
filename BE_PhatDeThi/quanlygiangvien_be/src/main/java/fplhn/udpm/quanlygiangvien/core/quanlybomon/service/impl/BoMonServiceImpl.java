package fplhn.udpm.quanlygiangvien.core.quanlybomon.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request.GetBoMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request.PostBoMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.repository.DataBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.service.BoMonService;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.repository.DataChuyenNganhRepository;
import fplhn.udpm.quanlygiangvien.entity.BoMon;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BoMonServiceImpl implements BoMonService {

    @Autowired
    private DataBoMonRepository dataBoMonRepository;

    @Autowired
    private DataChuyenNganhRepository dataChuyenNganhRepository;

    @Override
    public BoMonResponse getBoMon(Long id) {
        Optional<BoMonResponse> currentBoMon = dataBoMonRepository.getBoMonById(id);
        return currentBoMon.orElse(null);
    }

    @Override
    public Page<BoMonResponse> getAllList(GetBoMonRequest dataRequest) {
        int page = Math.max(dataRequest.getPage(), 1);
        int limit = dataRequest.getLimit();

        Pageable pageable = PageRequest.of(page - 1, limit);

        long startItem = (long) pageable.getPageNumber() * pageable.getPageSize();

        String searchName = null;
        if (dataRequest.getSearchName() != null) {
            searchName = dataRequest.getSearchName().stream()
                    .map(name -> name.replaceAll("[\\\\.*+?\\[\\](){|^$]", "\\\\$0"))
                    .collect(Collectors.joining("|"));
        }

        Page<BoMonResponse> pages = dataBoMonRepository.getAllBoMon(startItem, pageable, searchName);

        if (pages.getContent().isEmpty() && pages.getTotalPages() > 0 && pages.getTotalPages() < page) {
            dataRequest.setPage(Math.max(pages.getTotalPages(), 1));
            return this.getAllList(dataRequest);
        }

        return new PageImpl<>(
                new ArrayList<>(pages.getContent()),
                pages.getPageable(),
                pages.getTotalElements()
        );
    }

    @Override
    public ResponseModel addBoMon(PostBoMonRequest dataRequest) {

        String ten = dataRequest.getTen().trim().replaceAll("\\s+", " ");

        if (ten.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Tên bộ môn không được bỏ trống");
        }

        if (dataBoMonRepository.existsByTen(ten)) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Tên bộ môn đã tồn tại trên hệ thống");
        }
        BoMon boMon = new BoMon();
        boMon.setTen(ten);
        boMon.setXoaMem(XoaMem.CHUA_XOA);

        try {
            dataBoMonRepository.save(boMon);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Có lỗi xảy ra. Vui lòng thử lại");
        }

        return new ResponseModel(HttpStatus.OK, "Thêm mới thành công bộ môn: " + ten);
    }

    @Override
    public ResponseModel updateBoMon(Long id, PostBoMonRequest dataRequest) {
        Optional<BoMonResponse> currentBoMon = dataBoMonRepository.getBoMonById(id);
        String ten = dataRequest.getTen().trim().replaceAll("\\s+", " ");

        if (currentBoMon.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Bộ môn không tồn tại hoặc đã bị xoá");
        }

        if (ten.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Tên bộ môn không được bỏ trống");
        }

        if (dataBoMonRepository.existsByTenWidthOutId(id, ten)) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Tên bộ môn đã tồn tại trên hệ thống");
        }

        BoMon boMon = new BoMon();
        boMon.setId(id);
        boMon.setTen(ten);
        boMon.setXoaMem(currentBoMon.get().getTrangThai());

        try {
            dataBoMonRepository.save(boMon);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Có lỗi xảy ra. Vui lòng thử lại");
        }
        return new ResponseModel(HttpStatus.OK, "Cập nhật bộ môn thành công");
    }

    @Override
    public ResponseModel deleteBoMon(Long id) {

        Optional<BoMon> currentBoMon = dataBoMonRepository.findById(id);

        if (currentBoMon.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Bộ môn không tồn tại hoặc đã bị xoá");
        }

        if(currentBoMon.get().getXoaMem().equals(XoaMem.CHUA_XOA)){
            currentBoMon.get().setXoaMem(XoaMem.DA_XOA);
        }else{
            currentBoMon.get().setXoaMem(XoaMem.CHUA_XOA);
        }

        dataBoMonRepository.save(currentBoMon.get());

        return new ResponseModel(HttpStatus.OK, "Thay đổi thành công trạng thái Bộ Môn: " + currentBoMon.get().getTen());
    }

}
