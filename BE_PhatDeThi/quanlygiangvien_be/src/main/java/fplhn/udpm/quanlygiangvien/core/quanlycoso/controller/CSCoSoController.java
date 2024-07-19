package fplhn.udpm.quanlygiangvien.core.quanlycoso.controller;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.service.CSCoSoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/coso")
public class CSCoSoController {

    private final CSCoSoService csCoSoService;

    @GetMapping
    public PageCoSoResponse getAllCoSo(CSFindCoSoRequest csFindCoSoRequest){
        return csCoSoService.getAllCoSo(csFindCoSoRequest);
    }

    @GetMapping("/getall")
    public List<CSCoSoResponse> getAll(){
        return csCoSoService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> addCoSo(@Valid @RequestBody CSCreateCoSoRequest csCreateCoSoRequest){
        System.out.println(csCreateCoSoRequest.getTenCoSo());
        return new ResponseEntity<>(csCoSoService.addCoSo(csCreateCoSoRequest),HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateCoSo(@Valid @RequestBody CSCreateCoSoRequest csCreateCoSoRequest,@PathVariable Long id){
        return new ResponseEntity<>(csCoSoService.updateCoSo(csCreateCoSoRequest,id),HttpStatus.OK);
    }

    @PutMapping("/{id}/update-xoa-mem")
    public ResponseEntity<?> updateXoaMemCoSo(@PathVariable Long id){
        return new ResponseEntity<>(csCoSoService.updateXoaMemCoSo(id),HttpStatus.OK);
    }

}
