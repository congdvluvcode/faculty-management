package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataChuyenNganhRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chuyenNganhTheoCoSo_chuyenNganh")
public class ChuyenNganhServiceImpl implements ChuyenNganhService {

    @Autowired
    private DataChuyenNganhRepository dataChuyenNganhRepository;

    @Override
    public List<ChuyenNganhResponse> getAllList() {
        return dataChuyenNganhRepository.getAllChuyenNganh();
    }
}
