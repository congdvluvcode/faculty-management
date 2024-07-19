package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.controller;

import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSBoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository.BMCSBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository.BMCSNhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bomontheocoso/bomon")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BMCSBoMonController {

    private final BMCSBoMonRepository bmcsBoMonRepository;

    @GetMapping
    public List<BMCSBoMonResponse> getAll(){
        return bmcsBoMonRepository.getAll();
    }

}
