package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.service;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.request.PostNhanVienRequest;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.request.PutNhanVienRequest;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.*;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.LoaiHopDong;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TrangThaiNhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NhanVienService {

    Page<GetAllNhanVienChucVuResponse> getAllNhanVienChucVu(Pageable pageable,String input);

    GetNhanVienChucVuByIdResponse getAllNhanVienChucVuById(Long nhanVienId);

    GetDetailNhanVienChucVuResponse getDetailNhanVienChucVu(Long nhanVienId);

    List<GetAllHocKyResponse> getAllHocKy();

    List<GetAllChucVuByCoSoIdResponse> getAllChucVu_ByCoSoId(Long coSoId);

    List<GetAllBoMonTheoCoSoByCoSoIdResponse> getAllBoMonTheoCoSo_ByCoSoId(Long coSoId);

    List<LoaiHopDong> getAllLoaiHopDong();

    List<TrangThaiNhanVien> getAllTrangThaiNhanVien();

    ResponseModel postNhanVien(PostNhanVienRequest postNhanVienRequest);

    ResponseModel putNhanVien(PutNhanVienRequest putNhanVienRequest);

    ResponseModel deleteNhanVien(Long nhanVienId);

    ResponseModel importExcelNhanVien(MultipartFile file) throws IOException;

}
