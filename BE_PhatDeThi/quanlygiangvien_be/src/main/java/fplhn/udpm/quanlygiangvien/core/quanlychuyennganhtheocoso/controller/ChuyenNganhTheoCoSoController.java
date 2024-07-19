package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.controller;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.GetChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.PostChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.PutChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.ChuyenNganhTheoCoSoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chuyen-nganh-theo-co-so")
@CrossOrigin(origins = "*")
public class ChuyenNganhTheoCoSoController {

    @Autowired
    private ChuyenNganhTheoCoSoService chuyenNganhTheoCoSoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id", required = true) Long id) {
        ChuyenNganhTheoCoSoResponse chuyenNganhTheoCoSoResponse = chuyenNganhTheoCoSoService.getChuyenNganhTheoCoSo(id);
        if (chuyenNganhTheoCoSoResponse == null) {
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành không tồn tại hoặc đã bị xoá"));
        }
        return ResponseEntity.ok(chuyenNganhTheoCoSoResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(@ModelAttribute GetChuyenNganhTheoCoSoRequest dataRequest){
        return ResponseEntity.ok(chuyenNganhTheoCoSoService.getAllList(dataRequest));
    }

    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody @Valid PostChuyenNganhTheoCoSoRequest dataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_REQUEST, message));
        }
        return ResponseEntity.ok(chuyenNganhTheoCoSoService.addChuyenNganhTheoCoSo(dataRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Long id, @RequestBody @Valid PutChuyenNganhTheoCoSoRequest dataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_REQUEST, message));
        }
        return ResponseEntity.ok(chuyenNganhTheoCoSoService.updateChuyenNganhTheoCoSo(id, dataRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(chuyenNganhTheoCoSoService.deleteChuyenNganhTheoCoSo(id));
    }

}
