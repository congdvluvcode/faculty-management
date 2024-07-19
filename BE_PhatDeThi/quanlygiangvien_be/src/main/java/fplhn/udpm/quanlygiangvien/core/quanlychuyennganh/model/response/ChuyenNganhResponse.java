package fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.model.response;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;

public interface ChuyenNganhResponse {

    Long getId();

    Long getStt();

    String getTen();

    Long getIdBoMon();

    XoaMem getTrangThai();

}
