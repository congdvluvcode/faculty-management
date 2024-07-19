package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.NhanVienResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataNhanVienRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chuyenNganhTheoCoSo_nhanVien")
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private DataNhanVienRepository dataNhanVienRepository;

    @Override
    public List<NhanVienResponse> getAllList() {
        return dataNhanVienRepository.getAllNhanVien();
    }
}
