package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BMCSFindBoMonTheoCoSoRequest {

    private int pageNo;

    private int pageSize;

    private Long idCoSo;

    private String tenBoMon;

    public BMCSFindBoMonTheoCoSoRequest() {
        this.pageNo = 1;
        this.pageSize = 10;
        this.idCoSo = 0L;
        this.tenBoMon = "";
    }
}
