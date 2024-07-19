package fplhn.udpm.quanlygiangvien.core.common;

import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoConResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageCoSoConResponse {

    private List<CSCoSoConResponse> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Long totalElement;
    private boolean last;
}
