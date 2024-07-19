package fplhn.udpm.quanlygiangvien.core.quanlychucvu.service;

import fplhn.udpm.quanlygiangvien.core.common.PageChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request.CVCreateChucVuRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request.CVFindChucVuRequest;

public interface CVChucVuService {

    PageChucVuResponse getAllChucVuByIdCoSo(CVFindChucVuRequest cvFindChucVuRequest);

    ResponseModel addChucVu(CVCreateChucVuRequest cvCreateChucVuRequest);

    ResponseModel updateChucVu(CVCreateChucVuRequest cvCreateChucVuRequest,Long idChucVu);

    ResponseModel deleteChucVu(Long idChucVu);
}
