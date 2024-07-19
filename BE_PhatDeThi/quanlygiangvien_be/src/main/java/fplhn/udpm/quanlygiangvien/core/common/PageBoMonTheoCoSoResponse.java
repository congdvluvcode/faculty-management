package fplhn.udpm.quanlygiangvien.core.common;

import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSBoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.response.CVChucVuResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageBoMonTheoCoSoResponse {

    private List<BMCSBoMonTheoCoSoResponse> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Long totalElement;
    private boolean last;
}
