package fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.model.request;

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
public class PostChuyenNganhRequest {

    @Size(max = 255, message = "Tên chuyên ngành không được vượt quá 255 ký tự")
    @NotNull(message = "Tên chuyên ngành không được bỏ trống")
    private String ten;

    private Long idBoMon;

}
