package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface MonHocResponse {

    Long getStt();

    Long getId();

    String getTen();

    String getMa();

    String getHinhThuc();

    String getPathNoiQuyThi();

    String getTrangThai();

    Long getThoiGianTao();

    String getBoMon();

    String getIdBoMon();

    default String getFormattedThoiGianTao() {
        // Tạo một đối tượng Date từ giá trị Long
        Date date = new Date(getThoiGianTao());

        // Định dạng chuỗi ngày/tháng/năm
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Chuyển đổi đối tượng Date thành chuỗi ngày/tháng/năm
        return dateFormat.format(date);
    }

}
