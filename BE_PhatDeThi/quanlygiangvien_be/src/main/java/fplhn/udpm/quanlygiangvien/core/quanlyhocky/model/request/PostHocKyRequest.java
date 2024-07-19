package fplhn.udpm.quanlygiangvien.core.quanlyhocky.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostHocKyRequest {

    @NotNull(message = "Name cannot be blank")
    @NotBlank(message = "Name cannot be blank")
    private String ten;

    @NotNull(message = "Year cannot be blank")
    @NotBlank(message = "Year cannot be blank")
    @Pattern(regexp = "\\d{4}", message = "Year must be a number")
    private String nam;

    @NotNull(message = "Time start cannot be blank")
    private LocalDate thoiGianBatDau;

}
