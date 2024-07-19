package fplhn.udpm.quanlygiangvien.core.quanlybomon.controller;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request.GetBoMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request.PostBoMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.service.BoMonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/bo-mon")
@CrossOrigin(origins = "*")
public class BoMonController {

    @Autowired
    private BoMonService boMonService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id", required = true) Long id) {
        BoMonResponse boMonResponse = boMonService.getBoMon(id);
        if (boMonResponse == null) {
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_GATEWAY, "Bộ môn không tồn tại hoặc đã bị xoá"));
        }
        return ResponseEntity.ok(boMonResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(@ModelAttribute GetBoMonRequest dataRequest){
        return ResponseEntity.ok(boMonService.getAllList(dataRequest));
    }

    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody @Valid PostBoMonRequest dataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_REQUEST, message));
        }
        return ResponseEntity.ok(boMonService.addBoMon(dataRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Long id, @RequestBody @Valid PostBoMonRequest dataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_REQUEST, message));
        }
        return ResponseEntity.ok(boMonService.updateBoMon(id, dataRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(boMonService.deleteBoMon(id));
    }

}
