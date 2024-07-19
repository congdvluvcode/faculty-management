package fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBlockRequest {

    @NotBlank(message = "Tên không được trống!")
    private String ten;

    @NotNull(message = "Thời gian bắt đầu không được trống!")
    private LocalDate thoiGianBatDau;

    @NotNull(message = "Thời gian kết thúc không được trống!")
    private LocalDate thoiGianKetThuc;

    @NotNull(message = "Học kỳ không được trống!")
    private Long idHocKy;

}
