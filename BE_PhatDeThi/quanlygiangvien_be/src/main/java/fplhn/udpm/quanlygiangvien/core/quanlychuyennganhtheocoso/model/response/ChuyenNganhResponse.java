package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;

public interface ChuyenNganhResponse {

    Long getId();

    String getTen();

    Long getIdBoMon();

    XoaMem getTrangThai();

}
