package fplhn.udpm.quanlygiangvien.core.quanlycoso.controller;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoConResponse;
import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoConRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoConRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.service.CSCoSoConService;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.service.CSCoSoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/coso")
public class CSCoSoConController {

    private final CSCoSoConService csCoSoConService;

    @GetMapping("/campus/{id}")
    public PageCoSoConResponse getAllCoSoCon(CSFindCoSoConRequest csFindCoSoConRequest,@PathVariable Long id){
        return csCoSoConService.getAllCoSoConByIdCoSo(csFindCoSoConRequest,id);
    }

    @PostMapping("/campus")
    public ResponseEntity<?> addCoSoCon(@Valid @RequestBody CSCreateCoSoConRequest csCreateCoSoConRequest){
        return new ResponseEntity<>(csCoSoConService.addCoSoCon(csCreateCoSoConRequest), HttpStatus.OK);
    }

    @PutMapping("/campus/{idCoSoCon}/update")
    public ResponseEntity<?> updateCoSoCon(@Valid @RequestBody CSCreateCoSoConRequest csCreateCoSoConRequest,@PathVariable Long idCoSoCon){
        return new ResponseEntity<>(csCoSoConService.updateCoSoCon(csCreateCoSoConRequest,idCoSoCon),HttpStatus.OK);
    }

    @PutMapping("/campus/{idCoSoCon}/update-xoa-mem")
    public ResponseEntity<?> updateXoaMemCoSoCon(@PathVariable Long idCoSoCon){
        return new ResponseEntity<>(csCoSoConService.updateXoaMemCoSoCon(idCoSoCon),HttpStatus.OK);
    }

}
