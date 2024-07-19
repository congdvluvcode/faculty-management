package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.GetChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.PutChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.BoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.NhanVienResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataBoMonTheoCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataChuyenNganhRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataChuyenNganhTheoCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.PostChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataNhanVienRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.ChuyenNganhTheoCoSoService;
import fplhn.udpm.quanlygiangvien.entity.*;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;;


@Service
public class ChuyenNganhTheoCoSoServiceImpl implements ChuyenNganhTheoCoSoService {

    @Autowired
    private DataChuyenNganhTheoCoSoRepository dataChuyenNganhTheoCoSoRepository;

    @Autowired
    private DataBoMonTheoCoSoRepository dataBoMonTheoCoSoRepository;

    @Autowired
    private DataChuyenNganhRepository dataChuyenNganhRepository;

    @Autowired
    private DataNhanVienRepository dataNhanVienRepository;

    @Override
    public ChuyenNganhTheoCoSoResponse getChuyenNganhTheoCoSo(Long id) {
        Optional<ChuyenNganhTheoCoSoResponse> currentChuyenNganh = dataChuyenNganhTheoCoSoRepository.getChuyenNganhTheoCoSoById(id);
        return currentChuyenNganh.orElse(null);
    }

    @Override
    public Page<ChuyenNganhTheoCoSoResponse> getAllList(GetChuyenNganhTheoCoSoRequest dataRequest) {
        int page = Math.max(dataRequest.getPage(), 1);
        int limit = dataRequest.getLimit();

        Pageable pageable = PageRequest.of(page - 1, limit);

        long startItem = (long) pageable.getPageNumber() * pageable.getPageSize();

        Page<ChuyenNganhTheoCoSoResponse> pages = dataChuyenNganhTheoCoSoRepository.getAllChuyenNganh(dataRequest, startItem, pageable);

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
    public ResponseModel addChuyenNganhTheoCoSo(PostChuyenNganhTheoCoSoRequest dataRequest) {

        Optional<BoMonTheoCoSoResponse> boMonTheoCoSoResponse = dataBoMonTheoCoSoRepository.getBoMonTheoCoSoById(dataRequest.getIdBoMonTheoCoSo());

        if (boMonTheoCoSoResponse.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Bộ môn theo cơ sở không tồn tại hoặc đã bị xoá");
        }

        Optional<ChuyenNganhResponse> chuyenNganhResponse = dataChuyenNganhRepository.getChuyenNganhByIdAndIdBoMon(dataRequest.getIdChuyenNganh(), boMonTheoCoSoResponse.get().getIdBoMon());

        if (chuyenNganhResponse.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành không tồn tại trong bộ môn hoặc đã bị xoá");
        }

        if (dataChuyenNganhTheoCoSoRepository.existsChuyenNganhTheoCoSo(dataRequest.getIdBoMonTheoCoSo(), dataRequest.getIdChuyenNganh())) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành đã tồn tại trong bộ môn của cơ sở này");
        }

        NhanVien truongMon = null;

        if (dataRequest.getIdTruongMon() != null && dataRequest.getIdTruongMon() > 0) {
            Optional<NhanVienResponse> nhanVienResponse = dataNhanVienRepository.getNhanVienByIdAndIdBoMonCoSo(dataRequest.getIdTruongMon(), dataRequest.getIdBoMonTheoCoSo());

            if (nhanVienResponse.isEmpty()) {
                return new ResponseModel(HttpStatus.BAD_GATEWAY, "Nhân viên không tồn tại hoặc không thuộc bộ môn của cơ sở này");
            }

            truongMon = new NhanVien();
            truongMon.setId(nhanVienResponse.get().getId());
        }

        BoMonTheoCoSo boMonTheoCoSo = new BoMonTheoCoSo();
        boMonTheoCoSo.setId(dataRequest.getIdBoMonTheoCoSo());

        ChuyenNganh chuyenNganh = new ChuyenNganh();
        chuyenNganh.setId(dataRequest.getIdChuyenNganh());

        ChuyenNganhTheoCoSo chuyenNganhTheoCoSo = new ChuyenNganhTheoCoSo();
        chuyenNganhTheoCoSo.setBoMonTheoCoSo(boMonTheoCoSo);
        chuyenNganhTheoCoSo.setChuyenNganh(chuyenNganh);
        chuyenNganhTheoCoSo.setNhanVien(truongMon);
        chuyenNganhTheoCoSo.setXoaMem(XoaMem.CHUA_XOA);

        try {
            dataChuyenNganhTheoCoSoRepository.save(chuyenNganhTheoCoSo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Có lỗi xảy ra. Vui lòng thử lại");
        }

        return new ResponseModel(HttpStatus.OK, "Thêm mới thành công chuyên ngành theo cơ sở.");
    }

    @Override
    public ResponseModel updateChuyenNganhTheoCoSo(Long id, PutChuyenNganhTheoCoSoRequest dataRequest) {
        Optional<ChuyenNganhTheoCoSoResponse> currentChuyenNganhTheoCoSo = dataChuyenNganhTheoCoSoRepository.getChuyenNganhTheoCoSoById(id);

        if (currentChuyenNganhTheoCoSo.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành theo cơ sở không tồn tại hoặc đã bị xoá");
        }

        Optional<BoMonTheoCoSoResponse> boMonTheoCoSoResponse = dataBoMonTheoCoSoRepository.getBoMonTheoCoSoById(dataRequest.getIdBoMonTheoCoSo());

        if (boMonTheoCoSoResponse.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Bộ môn theo cơ sở không tồn tại hoặc đã bị xoá");
        }

        Optional<ChuyenNganhResponse> chuyenNganhResponse = dataChuyenNganhRepository.getChuyenNganhByIdAndIdBoMon(dataRequest.getIdChuyenNganh(), boMonTheoCoSoResponse.get().getIdBoMon());

        if (chuyenNganhResponse.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành không tồn tại trong bộ môn hoặc đã bị xoá");
        }

        NhanVien truongMon = null;

        if (dataRequest.getIdTruongMon() != null && dataRequest.getIdTruongMon() > 0) {
            Optional<NhanVienResponse> nhanVienResponse = dataNhanVienRepository.getNhanVienByIdAndIdBoMonCoSo(dataRequest.getIdTruongMon(), dataRequest.getIdBoMonTheoCoSo());

            if (nhanVienResponse.isEmpty()) {
                return new ResponseModel(HttpStatus.BAD_GATEWAY, "Nhân viên không tồn tại hoặc không thuộc bộ môn của cơ sở này");
            }

            truongMon = new NhanVien();
            truongMon.setId(nhanVienResponse.get().getId());
        }


        if (dataChuyenNganhTheoCoSoRepository.existsChuyenNganhTheoCoSoWidthOutId(id, dataRequest.getIdBoMonTheoCoSo(), dataRequest.getIdChuyenNganh())) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành đã tồn tại trong bộ môn của cơ sở này");
        }

        BoMonTheoCoSo boMonTheoCoSo = new BoMonTheoCoSo();
        boMonTheoCoSo.setId(boMonTheoCoSoResponse.get().getId());

        ChuyenNganh chuyenNganh = new ChuyenNganh();
        chuyenNganh.setId(chuyenNganhResponse.get().getId());


        ChuyenNganhTheoCoSo chuyenNganhTheoCoSo = new ChuyenNganhTheoCoSo();
        chuyenNganhTheoCoSo.setId(id);
        chuyenNganhTheoCoSo.setChuyenNganh(chuyenNganh);
        chuyenNganhTheoCoSo.setBoMonTheoCoSo(boMonTheoCoSo);
        chuyenNganhTheoCoSo.setNhanVien(truongMon);
        chuyenNganhTheoCoSo.setXoaMem(currentChuyenNganhTheoCoSo.get().getTrangThai());

        try {
            dataChuyenNganhTheoCoSoRepository.save(chuyenNganhTheoCoSo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Có lỗi xảy ra. Vui lòng thử lại");
        }
        return new ResponseModel(HttpStatus.OK, "Cập nhật chuyên ngành theo cơ sở thành công");
    }

    @Override
    public ResponseModel deleteChuyenNganhTheoCoSo(Long id) {

        Optional<ChuyenNganhTheoCoSoResponse> currentChuyenNganhTheoCoSo = dataChuyenNganhTheoCoSoRepository.getChuyenNganhTheoCoSoById(id);

        if (currentChuyenNganhTheoCoSo.isEmpty()) {
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành theo cơ sở không tồn tại hoặc đã bị xoá");
        }

        BoMonTheoCoSo boMonTheoCoSo = new BoMonTheoCoSo();
        boMonTheoCoSo.setId(currentChuyenNganhTheoCoSo.get().getIdBoMonTheoCoSo());

        ChuyenNganh chuyenNganh = new ChuyenNganh();
        chuyenNganh.setId(currentChuyenNganhTheoCoSo.get().getIdChuyenNganh());

        ChuyenNganhTheoCoSo chuyenNganhTheoCoSo = new ChuyenNganhTheoCoSo();
        chuyenNganhTheoCoSo.setId(currentChuyenNganhTheoCoSo.get().getId());
        chuyenNganhTheoCoSo.setBoMonTheoCoSo(boMonTheoCoSo);
        chuyenNganhTheoCoSo.setChuyenNganh(chuyenNganh);
        chuyenNganhTheoCoSo.setXoaMem(XoaMem.DA_XOA);

        if (currentChuyenNganhTheoCoSo.get().getTrangThai().equals(XoaMem.CHUA_XOA)) {
            try {
                dataChuyenNganhTheoCoSoRepository.save(chuyenNganhTheoCoSo);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseModel(HttpStatus.BAD_GATEWAY, "Có lỗi xảy ra. Vui lòng thử lại");
            }
            return new ResponseModel(HttpStatus.OK, "Cập nhật thành công chuyên ngành theo cơ sở: " + currentChuyenNganhTheoCoSo.get().getTenChuyenNganh());
        }

        try {
            dataChuyenNganhTheoCoSoRepository.delete(chuyenNganhTheoCoSo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel(HttpStatus.BAD_GATEWAY, "Có lỗi xảy ra. Vui lòng thử lại");
        }

        return new ResponseModel(HttpStatus.OK, "Xoá thành công chuyên ngành theo cơ sở: " + currentChuyenNganhTheoCoSo.get().getTenChuyenNganh());
    }

}
