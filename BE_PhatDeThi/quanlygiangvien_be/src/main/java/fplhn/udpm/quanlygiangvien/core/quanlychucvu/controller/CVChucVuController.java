package fplhn.udpm.quanlygiangvien.core.quanlychucvu.controller;

import fplhn.udpm.quanlygiangvien.core.common.PageChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request.CVCreateChucVuRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request.CVFindChucVuRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.service.CVChucVuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chucvu")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CVChucVuController {

    private final CVChucVuService cvChucVuService;

    @GetMapping
    public PageChucVuResponse getAllChucVu(CVFindChucVuRequest cvFindChucVuRequest){
        System.out.println(cvFindChucVuRequest.getIdCoSo());
        System.out.println("hello");
//        System.out.println(cvFindChucVuRequest.getTenChucVu());
        return cvChucVuService.getAllChucVuByIdCoSo(cvFindChucVuRequest);
    }

    @PostMapping
    public ResponseEntity<?> addChucVu(@RequestBody @Valid CVCreateChucVuRequest cvCreateChucVuRequest){
        return new ResponseEntity<>(cvChucVuService.addChucVu(cvCreateChucVuRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateChucVu(@RequestBody @Valid CVCreateChucVuRequest cvCreateChucVuRequest,@PathVariable(name = "id") Long idChucVu){
        return new ResponseEntity<>(cvChucVuService.updateChucVu(cvCreateChucVuRequest,idChucVu), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChucVu(@PathVariable(name = "id") Long idChucVu){
        return new ResponseEntity<>(cvChucVuService.deleteChucVu(idChucVu), HttpStatus.OK);
    }
}
