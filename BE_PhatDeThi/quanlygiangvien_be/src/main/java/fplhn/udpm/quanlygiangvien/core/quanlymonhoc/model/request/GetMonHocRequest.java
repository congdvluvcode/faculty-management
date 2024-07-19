package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetMonHocRequest {

    private String ma;
    private String ten;
    private String trangThai;
    private Long boMon;
    private String hinhThuc;
    private Long thoiGianTao;
    private int pageNo;
    private int pageSize;

    public GetMonHocRequest() {
        this.ma = "";
        this.ten = "";
        this.trangThai = "";
        this.boMon = 0L;
        this.hinhThuc = "";
        this.thoiGianTao = 0L;
        this.pageNo = 1;
        this.pageSize = 5;
    }
}
