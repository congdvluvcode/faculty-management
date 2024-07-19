package fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CSFindCoSoRequest {

    private int pageNo;

    private int pageSize;

    private List<String> listTenCoSo;

    public CSFindCoSoRequest() {
        this.pageNo = 1;
        this.pageSize = 5;
        this.listTenCoSo = new ArrayList<>();
    }

}
