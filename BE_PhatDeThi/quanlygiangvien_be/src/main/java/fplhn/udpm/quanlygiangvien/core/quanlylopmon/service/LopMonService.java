package fplhn.udpm.quanlygiangvien.core.quanlylopmon.service;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request.PostLopMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request.PutLopMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListBlockResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListCampusResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListHocKyResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListLopMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListMonHocResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListNhanVienResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.LopMonDetailResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.LopMonResponse;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.Ca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LopMonService {

    LopMonResponse getLopMonByLopMonId(Long lopMonId);

    LopMonDetailResponse getLopMonDetail(Long lopMonId);

    Page<ListLopMonResponse> searchLopMon(String input , Pageable pageable);

    List<ListLopMonResponse> getListLopMon();

    ResponseModel postLopMon(PostLopMonRequest postLopMonRequest);

    ResponseModel putLopMon(PutLopMonRequest putLopMonRequest);

    ResponseModel deleteLopMon(Long lopMonId);

    List<ListBlockResponse> getListBlockByHocKyId(Long hocKyId);

    List<ListCampusResponse> getListCampusByCoSoId(Long coSoId);

    List<ListHocKyResponse> getListHocKyResponse();

    List<ListMonHocResponse> getListMonHoc();

    List<ListNhanVienResponse> getListNhanVienByCoSoId(Long coSoId);

    Ca[] getListCaHoc();

}
