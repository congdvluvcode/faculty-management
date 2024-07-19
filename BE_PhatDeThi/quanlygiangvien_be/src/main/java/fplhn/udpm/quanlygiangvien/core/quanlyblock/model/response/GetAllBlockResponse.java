package fplhn.udpm.quanlygiangvien.core.quanlyblock.model.response;

import fplhn.udpm.quanlygiangvien.entity.HocKy;

public interface GetAllBlockResponse {

    Long getId();

    String getXoaMem();

    String getTen();

    String getThoiGianBatDau();

    String getThoiGianKetThuc();

    HocKy getHocKy();

}
