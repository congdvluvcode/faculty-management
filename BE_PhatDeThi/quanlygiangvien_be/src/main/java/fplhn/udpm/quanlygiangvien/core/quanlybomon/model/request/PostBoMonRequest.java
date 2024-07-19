package fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request;

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
public class PostBoMonRequest {

    @Size(max = 255, message = "Tên bộ môn không được vượt quá 255 ký tự")
    @NotNull(message = "Tên bộ môn không được bỏ trống")
    private String ten;

}
