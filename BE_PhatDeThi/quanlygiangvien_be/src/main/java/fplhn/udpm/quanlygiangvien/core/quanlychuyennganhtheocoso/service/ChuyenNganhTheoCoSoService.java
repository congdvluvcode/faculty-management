package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.GetChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.PutChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.PostChuyenNganhTheoCoSoRequest;
import org.springframework.data.domain.Page;

public interface ChuyenNganhTheoCoSoService {

    ChuyenNganhTheoCoSoResponse getChuyenNganhTheoCoSo(Long id);

    Page<ChuyenNganhTheoCoSoResponse> getAllList(GetChuyenNganhTheoCoSoRequest dataRequest);

    ResponseModel addChuyenNganhTheoCoSo(PostChuyenNganhTheoCoSoRequest dataRequest);

    ResponseModel updateChuyenNganhTheoCoSo(Long id, PutChuyenNganhTheoCoSoRequest dataRequest);

    ResponseModel deleteChuyenNganhTheoCoSo(Long id);


}
