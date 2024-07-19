package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.CoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.CoSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chuyenNganhTheoCoSo_coSo")
public class CoSoServiceImpl implements CoSoService {

    @Autowired
    private DataCoSoRepository dataCoSoRepository;

    @Override
    public List<CoSoResponse> getAllList() {
        return dataCoSoRepository.getAllCoSo();
    }
}
