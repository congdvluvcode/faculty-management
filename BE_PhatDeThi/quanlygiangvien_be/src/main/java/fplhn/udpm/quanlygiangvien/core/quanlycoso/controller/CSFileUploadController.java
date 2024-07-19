package fplhn.udpm.quanlygiangvien.core.quanlycoso.controller;

import fplhn.udpm.quanlygiangvien.core.quanlycoso.service.impl.CSImportExcel;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CSFileUploadController {

    private final CSImportExcel csImportExcel;

    @PostMapping("/upload")
    public List<CoSo> uploadFile(@RequestParam("file") MultipartFile file) {
        // Process the uploaded file (e.g., Excel processing) here
        // Return response accordingly
        List<CoSo> list =csImportExcel.importExcelCoSo(file);
        System.out.println(list);
        return list;
    }

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFile(@RequestBody List<CoSo> coSos) {
        // Process the uploaded file (e.g., Excel processing) here
        // Return response accordingly
        return new ResponseEntity<>(csImportExcel.saveImportExcel(coSos),HttpStatus.CREATED);
    }
}