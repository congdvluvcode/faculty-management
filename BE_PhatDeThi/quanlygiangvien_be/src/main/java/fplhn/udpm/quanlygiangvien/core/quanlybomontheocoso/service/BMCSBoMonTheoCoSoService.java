package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.service;

import fplhn.udpm.quanlygiangvien.core.common.PageBoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request.BMCSCreateBoMonTheoCoSoRequets;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.request.BMCSFindBoMonTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSBoMonTheoCoSoResponse;
import org.springframework.data.domain.Pageable;

public interface BMCSBoMonTheoCoSoService {

    PageBoMonTheoCoSoResponse paginateAndSearch(BMCSFindBoMonTheoCoSoRequest bmcsFindBoMonTheoCoSoRequest);

    ResponseModel addBoMonTheoCoSo(BMCSCreateBoMonTheoCoSoRequets bmcsCreateBoMonTheoCoSoRequets);

    ResponseModel updateXoaMemBoMonTheoCoSo(Long idBoMonTheoSoCo);


}
