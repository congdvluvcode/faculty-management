package fplhn.udpm.quanlygiangvien.core.quanlybomon.service;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request.GetBoMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request.PostBoMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.response.BoMonResponse;
import org.springframework.data.domain.Page;

public interface BoMonService {

    BoMonResponse getBoMon(Long id);

    Page<BoMonResponse> getAllList(GetBoMonRequest dataRequest);

    ResponseModel addBoMon(PostBoMonRequest dataRequest);

    ResponseModel updateBoMon(Long id, PostBoMonRequest dataRequest);

    ResponseModel deleteBoMon(Long id);


}
