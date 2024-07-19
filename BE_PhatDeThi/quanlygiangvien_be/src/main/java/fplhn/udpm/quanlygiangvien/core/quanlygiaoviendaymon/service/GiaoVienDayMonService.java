package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.service;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request.PostGiaoVienDayMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request.PutGiaoVienDayMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDataFillTableResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDataUpdateResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDetailGiaoVienDayMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenHocKyChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenMonHocChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenNhanVienChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.entity.GiaoVienDayMon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GiaoVienDayMonService {

    Page<GetDataFillTableResponse> getPageGiaoVienDayMon(Pageable pageable);

    Optional<GiaoVienDayMon> getGiaoVienDayMonById(Long id);

    ResponseModel postGiaoVienDayMon(PostGiaoVienDayMonRequest postGiaoVienDayMonRequest);

    ResponseModel putGiaoVienDayMon(Long idGiaoVienDayMon, PutGiaoVienDayMonRequest putGiaoVienDayMonRequest);

    ResponseModel xoaMemGiaoVienDayMon(Long idGiaoVienDayMon);

    List<GetIdTenNhanVienChuaXoaResponse> getNVChuaXoa();

    List<GetIdTenMonHocChuaXoaResponse> getIdTenMonHocChuaXoa();

    List<GetIdTenHocKyChuaXoaResponse> getIdTenHocKyChuaXoa();

    GetDetailGiaoVienDayMonResponse getGVDMById(Long idGiaoVienDayMon);

    GetDataUpdateResponse getDataUpdateById(Long idGiaoVienDayMon);

}
