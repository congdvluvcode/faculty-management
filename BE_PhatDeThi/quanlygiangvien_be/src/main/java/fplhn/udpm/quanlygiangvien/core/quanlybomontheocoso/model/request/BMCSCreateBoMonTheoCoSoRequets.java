package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BMCSCreateBoMonTheoCoSoRequets {

    @NotNull(message = "Cơ sở không được để trống")
    private Long idCoSo;

    @NotNull(message = "Bộ Môn không được để trống")
    private Long idBoMon;

//    @NotNull(message = "Trưởng bộ môn không được để trống")
    private Long idTruongBoMon;
}
