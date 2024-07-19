package fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CVFindChucVuRequest {

    private long idCoSo;

    private int pageNo;

    private int pageSize;

    private String tenChucVu;

    public CVFindChucVuRequest() {
        this.idCoSo = 0;
        this.pageNo = 1;
        this.pageSize = 5;
        this.tenChucVu = "";
    }
}
