package fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response;

import java.time.LocalDate;

public interface LopMonResponse {

    Long getLopMonId();

    Long getMonHocId();

    String getMaLop();

    String getPhongHoc();

    String getCaHoc();

    LocalDate getNgayBatDau();

    Long getNhanVienId();

    Long getBlockId();

    Long getCampusId();

    Long getHocKyId();

}
