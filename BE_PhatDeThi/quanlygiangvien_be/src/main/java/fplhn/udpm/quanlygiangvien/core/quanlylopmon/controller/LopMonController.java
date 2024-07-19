package fplhn.udpm.quanlygiangvien.core.quanlylopmon.controller;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request.PostLopMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request.PutLopMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.service.LopMonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/lop-mon")
@RequiredArgsConstructor
public class LopMonController {

    private final LopMonService lopMonService;

    private static final Integer PAGE_SIZE = 5;

    @GetMapping("/lop-mon-by-id/{lopMonId}")
    public ResponseEntity<?> getLopMonByLopMonId(@PathVariable Long lopMonId){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getLopMonByLopMonId(lopMonId));
    }

    @GetMapping("/lop-mon-detail/{lopMonId}")
    public ResponseEntity<?> getLopMonDetail(@PathVariable Long lopMonId){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getLopMonDetail(lopMonId));
    }

    @GetMapping("/search-lop-mon")
    public ResponseEntity<?> getListLopMon(@RequestParam(name = "input" , required = false) String input,
                                           @RequestParam(name = "page") Integer page){
        PageRequest pageRequest = PageRequest.of(page - 1 , PAGE_SIZE);
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.searchLopMon(input , pageRequest));
    }

    @GetMapping("/list-lop-mon")
    public ResponseEntity<?> getListLopMon(){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getListLopMon());
    }

    @PostMapping("/post-lop-mon")
    public ResponseEntity<?> postLopMon(@RequestBody @Valid PostLopMonRequest postLopMonRequest){
        ResponseModel responseModel = lopMonService.postLopMon(postLopMonRequest);
        return ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel.getMessage());
    }

    @PutMapping("/put-lop-mon")
    public ResponseEntity<?> putLopMon(@RequestBody @Valid PutLopMonRequest putLopMonRequest){
        ResponseModel responseModel = lopMonService.putLopMon(putLopMonRequest);
        return ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel.getMessage());
    }

    @PutMapping("/delete-lop-mon/{lopMonId}")
    public ResponseEntity<?> deleteLopMon(@PathVariable Long lopMonId){
        ResponseModel responseModel = lopMonService.deleteLopMon(lopMonId);
        return ResponseEntity.status(responseModel.getHttpStatus()).body(responseModel.getMessage());
    }

    @GetMapping("/list-block-by-hoc-ky-id/{hocKyId}")
    public ResponseEntity<?> getListBlockByHocKyId(@PathVariable Long hocKyId){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getListBlockByHocKyId(hocKyId));
    }

    @GetMapping("/list-campus-by-co-so-id/{coSoId}")
    public ResponseEntity<?> getListCampusByCoSoId(@PathVariable Long coSoId){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getListCampusByCoSoId(coSoId));
    }

    @GetMapping("/list-hoc-ky")
    public ResponseEntity<?> getListHocKyResponse(){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getListHocKyResponse());
    }

    @GetMapping("/list-mon-hoc")
    public ResponseEntity<?> getListMonHoc(){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getListMonHoc());
    }

    @GetMapping("/list-nhan-vien-by-co-so-id/{coSoId}")
    public ResponseEntity<?> getListNhanVienByCoSoId(@PathVariable Long coSoId){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getListNhanVienByCoSoId(coSoId));
    }

    @GetMapping("/list-ca-hoc")
    public ResponseEntity<?> getListCaHoc(){
        return ResponseEntity.status(HttpStatus.OK).body(lopMonService.getListCaHoc());
    }

}
