package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutGiaoVienDayMonRequest extends PostGiaoVienDayMonRequest{

    private Long id;

    private XoaMem xoaMem;

}
