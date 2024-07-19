package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostChuyenNganhTheoCoSoRequest {

    @NotNull(message = "Bộ môn theo cơ sở không được bỏ trống")
    private Long idBoMonTheoCoSo;

    @NotNull(message = "Chuyên ngành không được bỏ trống")
    private Long idChuyenNganh;

    private Long idTruongMon;

}
