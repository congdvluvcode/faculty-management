package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.service.Impl;

import fplhn.udpm.quanlygiangvien.core.common.PageCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlybomon.repository.DataBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request.GetMonHocRequest;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.request.PostMonHocRequest;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.response.MonHocResponse;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.repository.DataMonHocRepository;
import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.service.MonHocService;
import fplhn.udpm.quanlygiangvien.entity.BoMon;
import fplhn.udpm.quanlygiangvien.entity.MonHoc;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.HinhThuc;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TrangThaiMonHoc;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import fplhn.udpm.quanlygiangvien.infrastructure.exception.KeyValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MonHocServiceImpl implements MonHocService {

    private final DataMonHocRepository dataMonHocRepository;

    private final DataBoMonRepository dataBoMonRepository;


    @Override
    public Page<MonHocResponse> getAll(GetMonHocRequest getMonHocRequest) {
        Pageable pageable = PageRequest.of(getMonHocRequest.getPageNo()-1,getMonHocRequest.getPageSize());
        Set<String> list = new HashSet<>();

        Long start = getMonHocRequest.getPageSize()*(getMonHocRequest.getPageNo()-1)*1L;

        Page<MonHocResponse> monHocPage = dataMonHocRepository.paginateAndSearch(pageable, getMonHocRequest.getMa(), getMonHocRequest.getTen(),
                getMonHocRequest.getTrangThai(), getMonHocRequest.getBoMon(), getMonHocRequest.getHinhThuc(),
                getMonHocRequest.getThoiGianTao(),start);
        return new PageImpl<>(
                new ArrayList<>(monHocPage.getContent()),
                monHocPage.getPageable(),
                monHocPage.getTotalElements()
        );
    }

    @Override
    public MonHocResponse getMonHoc(Long id) {
        return dataMonHocRepository.getMonHoc(id);
    }

    @Override
    public ResponseModel addMonHoc(PostMonHocRequest postMonHocRequest) {
        Map<String,String> error = new HashMap<>();
        Optional<BoMon> boMonOptional = dataBoMonRepository.findById(postMonHocRequest.getBoMon());
        if(!boMonOptional.isPresent()){
            error.put("Bộ môn","Bộ môn không tồn tại");
        }
        if(dataMonHocRepository.existsByTen(postMonHocRequest.getTen())){
            error.put("Tên môn học","Tên môn học đã tồn tại");
        }
        if(dataMonHocRepository.existsByMaMon(postMonHocRequest.getMa())){
            error.put("Mã môn học","Mã môn học đã tồn tại");
        }
        if(!error.isEmpty()){
            throw new KeyValueException(error);
        }
        MonHoc monHoc = new MonHoc();
        monHoc.setBoMon(boMonOptional.get());
        monHoc.setTen(postMonHocRequest.getTen());
        monHoc.setMaMon(postMonHocRequest.getMa());
        String hinhthuc = postMonHocRequest.getHinhThuc();
        monHoc.setTrangThaiMonHoc(TrangThaiMonHoc.MO);
        monHoc.setHinhThuc(hinhthuc.equalsIgnoreCase("TRADITIONAL")? HinhThuc.TRADITIONAL:(hinhthuc.equalsIgnoreCase(" ONLINE")?HinhThuc.ONLINE:hinhthuc.equalsIgnoreCase("BLEND")?HinhThuc.BLEND:HinhThuc.TRUC_TUYEN));
        monHoc.setXoaMem(XoaMem.CHUA_XOA);
        monHoc.setPathNoiQuyThi(postMonHocRequest.getPathNoiQuyThi());
        monHoc.setThoiGianTao(postMonHocRequest.getThoiGianTao());
        dataMonHocRepository.save(monHoc);
        return new ResponseModel(HttpStatus.CREATED,"Thêm thành công");
    }

    @Override
    public ResponseModel updateMonHoc(PostMonHocRequest postMonHocRequest, Long id) {
        Map<String,String> error = new HashMap<>();
        Optional<BoMon> boMonOptional = dataBoMonRepository.findById(postMonHocRequest.getBoMon());
        Optional<MonHoc> monHocOptional = dataMonHocRepository.findById(id);
        if(!boMonOptional.isPresent()){
            error.put("Bộ môn","Bộ môn không tồn tại");
        }
        if(!monHocOptional.isPresent()){
            error.put("Môn học","Môn học không tồn tại");
        }
        if(dataMonHocRepository.existsByTenAndIdNot(postMonHocRequest.getTen(),id)){
            error.put("Tên môn học","Tên môn học đã tồn tại");
        }
        if(dataMonHocRepository.existsByMaMonAndIdNot(postMonHocRequest.getMa(),id)){
            error.put("Mã môn học","Mã môn học đã tồn tại");
        }
        if(!error.isEmpty()){
            throw new KeyValueException(error);
        }
        MonHoc monHoc = monHocOptional.get();
        monHoc.setBoMon(boMonOptional.get());
        monHoc.setTen(postMonHocRequest.getTen());
        monHoc.setMaMon(postMonHocRequest.getMa());
        String trangthai = postMonHocRequest.getTrangThai();
        String hinhthuc = postMonHocRequest.getHinhThuc();
        if(trangthai!= null){
            monHoc.setTrangThaiMonHoc(trangthai.equalsIgnoreCase("mo")?TrangThaiMonHoc.MO:trangthai.equalsIgnoreCase("dong")?TrangThaiMonHoc.DONG:TrangThaiMonHoc.DANG_DANG_KY);
        }
        monHoc.setHinhThuc(hinhthuc.equalsIgnoreCase("TRADITIONAL")? HinhThuc.TRADITIONAL:hinhthuc.equalsIgnoreCase("ONLINE")?HinhThuc.ONLINE:hinhthuc.equalsIgnoreCase("BLEND")?HinhThuc.BLEND:HinhThuc.TRUC_TUYEN);
        monHoc.setPathNoiQuyThi(postMonHocRequest.getPathNoiQuyThi());
        monHoc.setThoiGianTao(postMonHocRequest.getThoiGianTao());
        dataMonHocRepository.save(monHoc);
        return new ResponseModel(HttpStatus.OK,"Sửa thành công");
    }

    @Override
    public ResponseModel updateXoaMemMonHoc(Long id) {
        MonHoc monHoc = dataMonHocRepository.findById(id).get();
        TrangThaiMonHoc th = monHoc.getTrangThaiMonHoc();
        monHoc.setTrangThaiMonHoc(th.equals(TrangThaiMonHoc.DONG)?TrangThaiMonHoc.MO:th.equals(TrangThaiMonHoc.MO)?TrangThaiMonHoc.DANG_DANG_KY:TrangThaiMonHoc.DONG);
        dataMonHocRepository.save(monHoc);
        return new ResponseModel(HttpStatus.OK,"Sửa thành công");
    }
}
