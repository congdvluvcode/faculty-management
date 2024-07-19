package fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response;

import java.time.LocalDate;

public interface ListLopMonResponse {

    Long getLopMonId();

    String getTenMonHoc();

    String getMaLop();

    String getPhongHoc();

    String getCaHoc();

    LocalDate getNgayBatDau();

    String getTenGiaoVien();

    String getTenBlock();

    String getTenCoSo();

    String getTrangThai();

}
