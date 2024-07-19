package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostGiaoVienDayMonRequest {

    @NotNull(message = "Id nhan vien does not null!")
    private Long idNhanVien;

    @NotNull(message = "Id mon hoc does not null!")
    private Long idMonHoc;

    @NotNull(message = "Id hoc ky does not null!")
    private Long idHocKy;

}
