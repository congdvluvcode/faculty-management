package fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CSFindCoSoConRequest {

    private int pageNo;

    private int pageSize;

    private List<String> listTenCoSoCon;

    public CSFindCoSoConRequest() {
        this.pageNo = 1;
        this.pageSize = 5;
        this.listTenCoSoCon = new ArrayList<>();
    }

}
