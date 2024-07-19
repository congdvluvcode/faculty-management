package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.controller;

import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request.PostGiaoVienDayMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request.PutGiaoVienDayMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.service.GiaoVienDayMonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/giao-vien-day-mon")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GiaoVienDayMonController {

    private final GiaoVienDayMonService giaoVienDayMonService;

    private int pageSize = 5;

    @GetMapping("/get-list/page={pageIndex}")
    public ResponseEntity<?> getPageGiaoVienDayMon(@PathVariable("pageIndex") Optional<Integer> pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex.orElse(0), pageSize, Sort.by("id").descending());
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.getPageGiaoVienDayMon(pageable));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDetail(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.getGVDMById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@Valid @RequestBody PostGiaoVienDayMonRequest postGiaoVienDayMonRequest) {
        giaoVienDayMonService.postGiaoVienDayMon(postGiaoVienDayMonRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody PutGiaoVienDayMonRequest putGiaoVienDayMonRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.putGiaoVienDayMon(id, putGiaoVienDayMonRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.xoaMemGiaoVienDayMon(id));
    }

    @GetMapping("/get-id-ten-nhan-vien")
    public ResponseEntity<?> getAllNVChuaXoa() {
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.getNVChuaXoa());
    }

    @GetMapping("/get-id-ten-mon-hoc")
    public ResponseEntity<?> getMonHocChuaXoa() {
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.getIdTenMonHocChuaXoa());
    }

    @GetMapping("/get-id-ten-hoc-ky")
    public ResponseEntity<?> getHocKyChuaXoa() {
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.getIdTenHocKyChuaXoa());
    }

    @GetMapping("/get-data-update/id={id}")
    public ResponseEntity<?> getDataUpdate(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(giaoVienDayMonService.getDataUpdateById(id));
    }

}