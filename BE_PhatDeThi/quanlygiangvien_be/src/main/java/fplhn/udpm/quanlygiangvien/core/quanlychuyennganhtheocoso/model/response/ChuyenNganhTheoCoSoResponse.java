package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;

public interface ChuyenNganhTheoCoSoResponse {

    Long getId();

    Long getStt();

    Long getIdBoMonTheoCoSo();

    Long getIdBoMon();

    String getTenBoMon();

    Long getIdChuyenNganh();

    String getTenChuyenNganh();

    Long getIdCoSo();

    String getTenCoSo();

    Long getIdTruongMon();

    String getTenTruongMon();

    XoaMem getTrangThai();

}
