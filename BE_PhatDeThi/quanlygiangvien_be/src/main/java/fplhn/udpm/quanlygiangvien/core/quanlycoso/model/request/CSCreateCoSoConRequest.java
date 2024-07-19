package fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CSCreateCoSoConRequest {

    @NotNull(message = "Id cơ sở không được để trống")
    private Long idCoSo;

    @NotBlank(message = "Tên cơ sở con không được để trống")
    private String tenCoSoCon;
}
