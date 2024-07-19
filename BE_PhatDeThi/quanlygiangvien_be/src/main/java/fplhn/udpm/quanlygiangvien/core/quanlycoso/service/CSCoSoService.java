package fplhn.udpm.quanlygiangvien.core.quanlycoso.service;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CSCoSoService {

    PageCoSoResponse getAllCoSo(CSFindCoSoRequest csFindCoSoRequest);

    List<CSCoSoResponse> getAll();

    ResponseModel addCoSo(CSCreateCoSoRequest csCreateCoSoRequest);

    ResponseModel updateCoSo(CSCreateCoSoRequest csCreateCoSoRequest,Long id);

    ResponseModel updateXoaMemCoSo(Long id);

}
