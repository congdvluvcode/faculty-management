package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.controller;

import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSNhanVienResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository.BMCSBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository.BMCSNhanVienRepository;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.service.impl.BMCSBoMonTheoCoSoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bomontheocoso/nhanvien")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BMCSNhanVienController {

    private final BMCSNhanVienRepository bmcsNhanVienRepository;

    @GetMapping
    public List<BMCSNhanVienResponse> getAll(){
        return bmcsNhanVienRepository.getAll();
    }
}
