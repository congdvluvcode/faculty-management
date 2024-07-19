package fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostLopMonRequest {

    @NotBlank(message = "Mã lớp không được để trống!")
    private String maLop;

    @NotBlank(message = "Phòng học không được để trống!")
    private String phongHoc;

    @NotNull(message = "Ngày hoạt động chưa được chọn!")
    private LocalDate ngayHoatDong;

    @NotBlank(message = "Ca học chưa được chọn!")
    private String caHoc;

    @NotNull(message = "Môn học chưa được chọn!")
    private Long monHocId;

    @NotNull(message = "Block chưa được chọn!")
    private Long blockId;

    @NotNull(message = "Campus chưa được chọn!")
    private Long campusId;

    @NotNull(message = "Nhân viên chưa được chọn!")
    private Long nhanVienId;

}
