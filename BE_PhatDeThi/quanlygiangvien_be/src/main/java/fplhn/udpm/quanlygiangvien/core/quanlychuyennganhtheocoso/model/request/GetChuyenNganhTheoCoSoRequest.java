package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetChuyenNganhTheoCoSoRequest {

    private String tenChuyenNganh;

    private Long idBoMon;

    private Long idCoSo;

    private String tinhTrang;

    private int page = 1;

    private int limit = 5;

}
