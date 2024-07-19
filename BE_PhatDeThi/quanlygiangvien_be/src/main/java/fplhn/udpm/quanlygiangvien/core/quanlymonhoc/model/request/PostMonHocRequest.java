package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request;

import fplhn.udpm.quanlygiangvien.entity.BoMon;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.HinhThuc;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TrangThaiMonHoc;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostMonHocRequest {

    @NotBlank(message = "Tên môn học không được để trống!")
    private String ten;

    @NotBlank(message = "Mã môn không được để trống!")
    private String ma;

    @NotBlank(message = "Hình thức học không được để trống!")
    private String hinhThuc;

//    @NotBlank(message = "Nội quy không được để trống!")
    private String pathNoiQuyThi;

//    @NotBlank(message = "Trang thái không được để trống!")
    private String trangThai;

    @NotNull(message = "Nội quy không được để trống!")
    private Long thoiGianTao;

    @NotNull (message = "Nội quy không được để trống!")
    private Long boMon;

}
