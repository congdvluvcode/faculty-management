package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.BoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataBoMonTheoCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataChuyenNganhRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.BoMonTheoCoSoService;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chuyenNganhTheoCoSo_boMonTheoCoSo")
public class BoMonTheoCoSoServiceImpl implements BoMonTheoCoSoService {

    @Autowired
    private DataBoMonTheoCoSoRepository dataBoMonTheoCoSoRepository;

    @Override
    public List<BoMonTheoCoSoResponse> getAllList() {
        return dataBoMonTheoCoSoRepository.getAllBoMonTheoCoSo();
    }
}
