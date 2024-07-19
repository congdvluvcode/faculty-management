package fplhn.udpm.quanlygiangvien.core.common;

import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageCoSoResponse {

    private List<CSCoSoResponse> content;

    private Integer pageNo;

    private Integer pageSize;

    private Integer totalPages;

    private Long totalElement;

    private Boolean last;
}
