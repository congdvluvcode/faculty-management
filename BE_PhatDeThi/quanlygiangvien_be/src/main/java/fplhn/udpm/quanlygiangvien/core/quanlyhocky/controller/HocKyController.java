package fplhn.udpm.quanlygiangvien.core.quanlyhocky.controller;

import fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.HocKyService;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
@RequestMapping("/hoc-ky")
@CrossOrigin("*")
@RequiredArgsConstructor
public class HocKyController {

    private final HocKyService hocKyService;

    private int pageSize = 5;

    @GetMapping("/get-list/page={pageIndex}")
    public ResponseEntity<?> getAll(@PathVariable("pageIndex")Optional<Integer> pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex.orElse(0), pageSize, Sort.by("thoiGianBatDau").descending());
        Page<HocKy> hocKyPage = hocKyService.getPageHocKy(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(hocKyPage);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(hocKyService.getById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> insert(@RequestBody HocKy hocKy) {
        return ResponseEntity.status(HttpStatus.OK).body(hocKyService.insert(hocKy));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HocKy hocKyUpdated) {
        HocKy hocKy = hocKyService.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(hocKyService.update(hocKy, hocKyUpdated));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(hocKyService.delete(id));
    }

}
