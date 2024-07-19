package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.controller;

import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request.GetMonHocRequest;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request.PostMonHocRequest;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.response.MonHocResponse;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.repository.DataMonHocBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.service.MonHocService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monHoc")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MonHocController {

    private final MonHocService monHocService;

    private final DataMonHocBoMonRepository dataBoMonRepository;

    @GetMapping
    public Page<MonHocResponse> getAll(GetMonHocRequest getMonHocRequest){
        return monHocService.getAll(getMonHocRequest);
    }

    @GetMapping("/boMon")
    public List<BoMonResponse> getAll(){
        return dataBoMonRepository.getBoMon();
    }

    @GetMapping("/{id}")
    public MonHocResponse getMonHoc(@PathVariable("id") Long idMonHoc){
        return monHocService.getMonHoc(idMonHoc);
    }

    @PostMapping
    public ResponseEntity<?> addMonHoc(@Valid @RequestBody PostMonHocRequest postMonHocRequest){
        return new ResponseEntity<>(monHocService.addMonHoc(postMonHocRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateMonHoc(@Valid @RequestBody PostMonHocRequest postMonHocRequest,@PathVariable Long id){
        return new ResponseEntity<>(monHocService.updateMonHoc(postMonHocRequest,id),HttpStatus.OK);
    }

    @PutMapping("/{id}/update-xoaMem")
    public ResponseEntity<?> updateMonHocXoaMem(@PathVariable Long id){
        return new ResponseEntity<>(monHocService.updateXoaMemMonHoc(id),HttpStatus.OK);
    }

}
