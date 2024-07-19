package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request;

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
public class PutMonHocRequest {

    @NotBlank(message = "Tên môn học không được để trống!")
    private String ten;

    @NotBlank(message = "Mã môn không được để trống!")
    private String ma;

    @NotBlank(message = "Hình thức học không được để trống!")
    private String hinhThuc;

    private String pathNoiQuyThi;

    private String trangThai;

    @NotNull
    private Long thoiGianTao;

    @NotNull
    private Long BoMon;
}
