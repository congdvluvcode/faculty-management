package fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.response;

import org.springframework.beans.factory.annotation.Value;

public interface CVChucVuResponse {

    @Value("#{target.idChucVu}")
    Long getIdChucVu();

    @Value("#{target.idCoSo}")
    Long getIdCoSo();

    @Value("#{target.tenCoSo}")
    String getTenCoSo();

    @Value("#{target.tenChucVu}")
    String getTenChucVu();

    @Value("#{target.trangThai}")
    String getTrangThai();

}
