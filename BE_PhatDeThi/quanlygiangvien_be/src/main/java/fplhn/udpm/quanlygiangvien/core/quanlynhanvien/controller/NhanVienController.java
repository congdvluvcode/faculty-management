package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.controller;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.request.PostNhanVienRequest;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.request.PutNhanVienRequest;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/nhan_vien")
public class NhanVienController {

    private final NhanVienService nhanVienService;

    private final static int PAGE_SIZE = 5;

    @Autowired
    private NhanVienController(NhanVienService nhanVienService){
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("/getAll-nhan_vien-chuc_vu")
    public ResponseEntity<?> getAllNhanVienChucVu(@RequestParam(name = "page") Integer page,
                                                  @RequestParam(name = "input",required = false) String input){
        PageRequest pageRequest = PageRequest.of(page-1,PAGE_SIZE);
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getAllNhanVienChucVu(pageRequest,input));
    }

    @GetMapping("/getAll-nhan_vien-chuc_vu/{nhanVienId}")
    public ResponseEntity<?> getAllNhanVienChucVuById(@PathVariable Long nhanVienId){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getAllNhanVienChucVuById(nhanVienId));
    }

    @GetMapping("/getAll-hoc_ky")
    public ResponseEntity<?> getAllHocKy(){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getAllHocKy());
    }

    @GetMapping("/getAll-chuc_vu-By-co_so_id/{coSoId}")
    public ResponseEntity<?> getAllChucVu_ByCoSoId(@PathVariable Long coSoId){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getAllChucVu_ByCoSoId(coSoId));
    }

    @GetMapping("/getAll-bo_mon-By-co_so_id/{coSoId}")
    public ResponseEntity<?> getAllBoMonTheoCoSo_ByCoSoId(@PathVariable Long coSoId){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getAllBoMonTheoCoSo_ByCoSoId(coSoId));
    }

    @GetMapping("/getAll-loai_hop_dong")
    public ResponseEntity<?> getAllLoaiHopDong(){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getAllLoaiHopDong());
    }

    @GetMapping("/getAll-trang_thai_nhan_vien")
    public ResponseEntity<?> getAllTrangThaiNhanVien(){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getAllTrangThaiNhanVien());
    }

    @PostMapping("/post-nhan_vien")
    public ResponseEntity<?> postNhanVien(@RequestBody @Valid PostNhanVienRequest postNhanVienRequest){
        ResponseModel responseModel = nhanVienService.postNhanVien(postNhanVienRequest);
        return new ResponseEntity<>(responseModel.getMessage(),responseModel.getHttpStatus());
    }

    @PutMapping("/put-nhan_vien")
    public ResponseEntity<?> putNhanVien(@RequestBody @Valid PutNhanVienRequest putNhanVienRequest){
        ResponseModel responseModel = nhanVienService.putNhanVien(putNhanVienRequest);
        return new ResponseEntity<>(responseModel.getMessage(),responseModel.getHttpStatus());
    }

    @GetMapping("/detail-nhan_vien/{nhanVienId}")
    public ResponseEntity<?> detailNhanVien(@PathVariable Long nhanVienId){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.getDetailNhanVienChucVu(nhanVienId));
    }

    @DeleteMapping("/delete-nhan_vien/{nhanVienId}")
    public ResponseEntity<?> deleteNhanVien(@PathVariable Long nhanVienId){
        return ResponseEntity.status(HttpStatus.OK).body(nhanVienService.deleteNhanVien(nhanVienId));
    }

    @PostMapping("/import-excel")
    public ResponseEntity<?> importExcelNhanVien(@RequestParam("file") MultipartFile file) throws IOException {
        ResponseModel responseModel = nhanVienService.importExcelNhanVien(file);
        return new ResponseEntity<>(responseModel.getMessage(),responseModel.getHttpStatus());
    }

}
