package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request.PostGiaoVienDayMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.request.PutGiaoVienDayMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDataFillTableResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDataUpdateResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDetailGiaoVienDayMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenHocKyChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenMonHocChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenNhanVienChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository.QLGVDMHocKyRepository;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository.QLGVDMMonHocRepository;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository.QLGVDMNhanVienRepository;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository.QLGiaoVienDayMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.service.GiaoVienDayMonService;
import fplhn.udpm.quanlygiangvien.entity.GiaoVienDayMon;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import fplhn.udpm.quanlygiangvien.entity.MonHoc;
import fplhn.udpm.quanlygiangvien.entity.NhanVien;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import fplhn.udpm.quanlygiangvien.infrastructure.exception.KeyValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GiaoVienDayMonServiceImpl implements GiaoVienDayMonService {

    private final QLGiaoVienDayMonRepository qlGiaoVienDayMonRepository;

    private final QLGVDMNhanVienRepository qlgvdmNhanVienRepository;

    private final QLGVDMMonHocRepository qlgvdmMonHocRepository;

    private final QLGVDMHocKyRepository qlgvdmHocKyRepository;

    @Override
    public Page<GetDataFillTableResponse> getPageGiaoVienDayMon(Pageable pageable) {
        return qlGiaoVienDayMonRepository.getDataFillTable(pageable);
    }

    @Override
    public Optional<GiaoVienDayMon> getGiaoVienDayMonById(Long id) {
        return qlGiaoVienDayMonRepository.findById(id);
    }

    @Override
    public ResponseModel postGiaoVienDayMon(PostGiaoVienDayMonRequest postGiaoVienDayMonRequest) {
        Map<String, String> errors = new HashMap<>();

        Optional<NhanVien> isNhanVienExists = qlgvdmNhanVienRepository.findById(postGiaoVienDayMonRequest.getIdNhanVien());

        Optional<MonHoc> isMonHocExists = qlgvdmMonHocRepository.findById(postGiaoVienDayMonRequest.getIdMonHoc());

        Optional<HocKy> isHocKyExists = qlgvdmHocKyRepository.findById(postGiaoVienDayMonRequest.getIdHocKy());

        if(isHocKyExists.isEmpty()) {
            errors.put("idHocKy", "ID hoc ky does not exists!");
        }
        if(isNhanVienExists.isEmpty()) {
            errors.put("idNhanVien", "ID nhan vien does not exists!");
        }
        if(isMonHocExists.isEmpty()) {
            errors.put("idMonHoc", "ID mon hoc does not exists!");
        }
        if(!errors.isEmpty()) {
            throw new KeyValueException(errors);
        }
        GiaoVienDayMon postGiaoVienDayMon = new GiaoVienDayMon();
        postGiaoVienDayMon.setNhanVien(isNhanVienExists.get());
        postGiaoVienDayMon.setMonHoc(isMonHocExists.get());
        postGiaoVienDayMon.setHocKy(isHocKyExists.get());
        postGiaoVienDayMon.setXoaMem(XoaMem.CHUA_XOA);
        qlGiaoVienDayMonRepository.save(postGiaoVienDayMon);
        return new ResponseModel(HttpStatus.CREATED, "Created successfully!", postGiaoVienDayMon);
    }

    @Override
    public ResponseModel putGiaoVienDayMon(Long idGiaoVienDayMon, PutGiaoVienDayMonRequest putGiaoVienDayMonRequest) {
        Map<String, String> errors = new HashMap<>();
        Optional<GiaoVienDayMon> isGiaoVienDayMonExists = qlGiaoVienDayMonRepository.findById(idGiaoVienDayMon);

        if(isGiaoVienDayMonExists.isEmpty()) {
            errors.put("GiaoVienDayMon", "Giao vien day mon does not exists!");
        }

        Optional<HocKy> isHocKyExists = qlgvdmHocKyRepository.findById(putGiaoVienDayMonRequest.getIdHocKy());

        if(isHocKyExists.isEmpty()) {
            errors.put("idHocKy", "ID hoc ky does not exists!");
        }

        Optional<MonHoc> isMonHocExists = qlgvdmMonHocRepository.findById(putGiaoVienDayMonRequest.getIdMonHoc());

        if(isMonHocExists.isEmpty()) {
            errors.put("idMonHoc", "ID mon hoc does not exists!");
        }

        Optional<NhanVien> isNhanVienExists = qlgvdmNhanVienRepository.findById(putGiaoVienDayMonRequest.getIdNhanVien());

        if(isNhanVienExists.isEmpty()) {
            errors.put("idNhanVien", "ID nhan vien does not exists!");
        }

        if(!errors.isEmpty()) {
            throw new KeyValueException(errors);
        }
        GiaoVienDayMon putGiaoVienDayMon = isGiaoVienDayMonExists.get();
        putGiaoVienDayMon.setNhanVien(isNhanVienExists.get());
        putGiaoVienDayMon.setMonHoc(isMonHocExists.get());
        putGiaoVienDayMon.setHocKy(isHocKyExists.get());
        putGiaoVienDayMon.setXoaMem(putGiaoVienDayMon.getXoaMem());
        qlGiaoVienDayMonRepository.save(putGiaoVienDayMon);

        return new ResponseModel(HttpStatus.OK, "Updated successfully!");
    }

    @Override
    public ResponseModel xoaMemGiaoVienDayMon(Long idGiaoVienDayMon) {
        Map<String, String> errors = new HashMap<>();
        Optional<GiaoVienDayMon> idGiaoVienDayMonExists = qlGiaoVienDayMonRepository.findById(idGiaoVienDayMon);
        if(idGiaoVienDayMonExists.isEmpty()) {
            errors.put("Giao vien day mon", "Giao vien day mon does not exists!");
        }
        if(!errors.isEmpty()) {
            throw new KeyValueException(errors);
        } else {
            qlGiaoVienDayMonRepository.delete(idGiaoVienDayMonExists.get());
        }
        return new ResponseModel(HttpStatus.OK, "Delete successfully!");
    }

    @Override
    public List<GetIdTenNhanVienChuaXoaResponse> getNVChuaXoa() {
        return qlgvdmNhanVienRepository.getNhanVienChuaXoa();
    }

    @Override
    public List<GetIdTenMonHocChuaXoaResponse> getIdTenMonHocChuaXoa() {
        return qlgvdmMonHocRepository.getMonHocChuaXoa();
    }

    @Override
    public List<GetIdTenHocKyChuaXoaResponse> getIdTenHocKyChuaXoa() {
        return qlgvdmHocKyRepository.getIdTenHocKyChuaXoa();
    }

    @Override
    public GetDetailGiaoVienDayMonResponse getGVDMById(Long idGiaoVienDayMon) {
        return qlGiaoVienDayMonRepository.getDetailGVDMById(idGiaoVienDayMon);
    }

    @Override
    public GetDataUpdateResponse getDataUpdateById(Long idGiaoVienDayMon) {
        return qlGiaoVienDayMonRepository.getDataUpdateById(idGiaoVienDayMon);
    }

}
