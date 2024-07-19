package fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CSCreateCoSoRequest {

    @NotBlank(message = "Tên cơ sở không được để trống")
    private String tenCoSo;

}
