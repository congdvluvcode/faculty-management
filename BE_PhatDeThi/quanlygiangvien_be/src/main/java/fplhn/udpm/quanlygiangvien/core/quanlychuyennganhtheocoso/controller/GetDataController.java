package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.controller;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.GetChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.GetDataResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/chuyen-nganh-theo-co-so/get-data")
@CrossOrigin(origins = "*")
public class GetDataController {

    @Autowired
    private BoMonService boMonService;

    @Autowired
    private CoSoService coSoService;

    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @Autowired
    private BoMonTheoCoSoService boMonTheoCoSoService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/bo-mon-and-co-so")
    public ResponseEntity<?> getDataBoMonAndCoSo(){
        GetDataResponse response = new GetDataResponse();
        try {
            response.setBoMon(boMonService.getAllList());
            response.setCoSo(coSoService.getAllList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_GATEWAY, "Không thể lấy danh sách bộ môn và cơ sở"));
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/chuyen-nganh-and-bo-mon-theo-co-so")
    public ResponseEntity<?> getDataChuyenNganhAndBoMonTheoCoSo(){
        GetDataResponse response = new GetDataResponse();
        try {
            response.setChuyenNganh(chuyenNganhService.getAllList());
            response.setBoMonTheoCoSo(boMonTheoCoSoService.getAllList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_GATEWAY, "Không thể lấy danh sách chuyên ngành và bộ môn theo cơ sở"));
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/nhan-vien")
    public ResponseEntity<?> getDataNhanVien(){
        return ResponseEntity.ok(nhanVienService.getAllList());
    }

}
