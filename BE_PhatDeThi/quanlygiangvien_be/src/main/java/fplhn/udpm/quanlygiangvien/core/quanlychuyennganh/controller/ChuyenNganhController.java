package fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.controller;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.model.request.GetChuyenNganhRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.model.request.PostChuyenNganhRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.service.ChuyenNganhService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/chuyen-nganh")
@CrossOrigin(origins = "*")
public class ChuyenNganhController {

    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id", required = true) Long id) {
        ChuyenNganhResponse chuyenNganhResponse = chuyenNganhService.getChuyenNganh(id);
        if (chuyenNganhResponse == null) {
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_GATEWAY, "Chuyên ngành không tồn tại hoặc đã bị xoá"));
        }
        return ResponseEntity.ok(chuyenNganhResponse);
    }

    @GetMapping("/list/{id_bo_mon}")
    public ResponseEntity<?> list(@PathVariable(name = "id_bo_mon", required = true) Long idBoMon, @ModelAttribute GetChuyenNganhRequest dataRequest){
        return ResponseEntity.ok(chuyenNganhService.getAllList(idBoMon, dataRequest));
    }

    @PostMapping("/add")
    public ResponseEntity<?> insert(@RequestBody @Valid PostChuyenNganhRequest dataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_REQUEST, message));
        }
        return ResponseEntity.ok(chuyenNganhService.addChuyenNganh(dataRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Long id, @RequestBody @Valid PostChuyenNganhRequest dataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.ok(new ResponseModel(HttpStatus.BAD_REQUEST, message));
        }
        return ResponseEntity.ok(chuyenNganhService.updateChuyenNganh(id, dataRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(chuyenNganhService.deleteChuyenNganh(id));
    }

}
