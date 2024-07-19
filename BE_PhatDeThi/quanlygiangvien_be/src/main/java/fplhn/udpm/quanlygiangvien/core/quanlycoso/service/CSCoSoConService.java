package fplhn.udpm.quanlygiangvien.core.quanlycoso.service;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoConResponse;
import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoConRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoConRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSFindCoSoRequest;

public interface CSCoSoConService {

    PageCoSoConResponse getAllCoSoConByIdCoSo(CSFindCoSoConRequest csFindCoSoConRequest,Long idCoSo);

    ResponseModel addCoSoCon(CSCreateCoSoConRequest csCreateCoSoRequest);

    ResponseModel updateCoSoCon(CSCreateCoSoConRequest csCreateCoSoConRequest,Long idCoSoCon);

    ResponseModel updateXoaMemCoSoCon(Long idCoSoCon);

}
