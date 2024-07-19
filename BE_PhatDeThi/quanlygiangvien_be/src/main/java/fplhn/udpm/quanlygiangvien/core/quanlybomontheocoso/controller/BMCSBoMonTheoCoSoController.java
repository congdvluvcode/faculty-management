package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.controller;

import fplhn.udpm.quanlygiangvien.core.common.PageBoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request.BMCSCreateBoMonTheoCoSoRequets;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request.BMCSFindBoMonTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.service.BMCSBoMonTheoCoSoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bomontheocoso")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BMCSBoMonTheoCoSoController {

    private final BMCSBoMonTheoCoSoService bmcsBoMonTheoCoSoService;

    @GetMapping
    public PageBoMonTheoCoSoResponse pageandSearch(BMCSFindBoMonTheoCoSoRequest bmcsFindBoMonTheoCoSoRequest){
        return bmcsBoMonTheoCoSoService.paginateAndSearch(bmcsFindBoMonTheoCoSoRequest);
    }

    @PostMapping
    public ResponseEntity<?> addBoMonTheoCoSo(@RequestBody @Valid BMCSCreateBoMonTheoCoSoRequets createBoMonTheoCoSoRequets){
        return new ResponseEntity<>(bmcsBoMonTheoCoSoService.addBoMonTheoCoSo(createBoMonTheoCoSoRequets), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateXoaMemBoMonTheoCoSo(@PathVariable(name = "id")Long idBMCS){
        return new ResponseEntity<>(bmcsBoMonTheoCoSoService.updateXoaMemBoMonTheoCoSo(idBMCS), HttpStatus.OK);
    }
}
