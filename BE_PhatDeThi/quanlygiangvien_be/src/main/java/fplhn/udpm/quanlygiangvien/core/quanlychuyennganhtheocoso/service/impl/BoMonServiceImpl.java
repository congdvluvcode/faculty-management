package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository.DataBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.service.BoMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chuyenNganhTheoCoSo_boMon")
public class BoMonServiceImpl implements BoMonService {

    @Autowired
    private DataBoMonRepository dataBoMonRepository;

    @Override
    public List<BoMonResponse> getAllList() {
        return dataBoMonRepository.getAllBoMon();
    }
}
