package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.utils;

import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVNhanVienCheckValidRepository;
import fplhn.udpm.quanlygiangvien.entity.NhanVien;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TenHocKy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CheckValid {

    private final QLNVNhanVienCheckValidRepository nhanVienCheckValidRepository;

    @Autowired
    public CheckValid(QLNVNhanVienCheckValidRepository nhanVienCheckValidRepository) {
        this.nhanVienCheckValidRepository = nhanVienCheckValidRepository;
    }

    public Boolean isValidEmailFe (String emailFE) {
        String regex = "[a-zA-Z]+\\d*@fe.edu.vn";
        return emailFE.matches(regex);
    }

    public Boolean isExistEmailFe (String emailFE) {
        Optional<NhanVien> isNhanVienExist = nhanVienCheckValidRepository.findNhanVienBy_TaiKhoanFE(emailFE);
        if (isNhanVienExist.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public Boolean isExistMaNhanVien (String maNhanVien) {
        Optional<NhanVien> isNhanVienExist = nhanVienCheckValidRepository.findNhanVienBy_MaNhanVien(maNhanVien);
        if (isNhanVienExist.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public TenHocKy parseTenHocKy (String tenHocKy){
        for (TenHocKy tenParse : TenHocKy.values()){
            if (tenHocKy.equalsIgnoreCase(tenParse.name())){
                return tenParse;
            }
        }
        return null;
    }



}
