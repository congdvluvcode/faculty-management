package fplhn.udpm.quanlygiangvien.core.common;

import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.response.CVChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoConResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageChucVuResponse {

    private List<CVChucVuResponse> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Long totalElement;
    private boolean last;

}
