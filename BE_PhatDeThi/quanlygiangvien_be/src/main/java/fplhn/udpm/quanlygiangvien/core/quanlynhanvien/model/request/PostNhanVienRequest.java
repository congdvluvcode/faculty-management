package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostNhanVienRequest {

    @NotBlank(message = "Tên nhân viên không được để trống!")
    private String ten;

    @NotBlank(message = "Mã nhân viên không được để trống!")
    private String maNhanVien;

    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._%+-]*@fe\\.edu\\.vn$", message = "Email Fe Không Đúng Định Dạng!")
    @NotBlank(message = "Tài khoản fe không được để trống!")
    private String taiKhoanFE;

    @NotEmpty(message = "Loại hợp đồng chưa được chọn!")
    private String loaiHopDong;

    @NotNull(message = "Bộ môn chưa được chọn!")
    private Long boMonTheoCoSo_id;

    @NotNull(message = "Học kỳ chưa được chọn!")
    private Long hocKy_id;

    @NotEmpty(message = "Chức vụ chưa được chọn!")
    private List<Long> chucVu;

}
