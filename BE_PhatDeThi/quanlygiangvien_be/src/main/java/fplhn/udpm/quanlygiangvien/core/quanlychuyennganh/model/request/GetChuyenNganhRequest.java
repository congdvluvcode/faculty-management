package fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetChuyenNganhRequest {

    private List<String> searchName;

    private int page = 1;

    private int limit = 5;

}
