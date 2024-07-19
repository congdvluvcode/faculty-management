package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.service;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request.GetMonHocRequest;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request.PostMonHocRequest;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.response.MonHocResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MonHocService {

    Page<MonHocResponse> getAll(GetMonHocRequest getMonHocRequest);

    MonHocResponse getMonHoc(Long id);

    ResponseModel addMonHoc(PostMonHocRequest postMonHocRequest);

    ResponseModel updateMonHoc(PostMonHocRequest postMonHocRequest,Long id);

    ResponseModel updateXoaMemMonHoc(Long id);

}
