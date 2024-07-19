package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetDataResponse {

    private List<BoMonResponse> boMon;

    private List<CoSoResponse> coSo;

    private List<ChuyenNganhResponse> chuyenNganh;

    private List<BoMonTheoCoSoResponse> boMonTheoCoSo;

}
