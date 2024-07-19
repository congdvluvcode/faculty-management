package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository;

import fplhn.udpm.quanlygiangvien.entity.NhanVien;
import fplhn.udpm.quanlygiangvien.repository.NhanVienRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QLNVNhanVienCheckValidRepository extends NhanVienRepository {

    @Query("""
            SELECT nv FROM nhan_vien nv WHERE nv.maNhanVien = :ma_nhan_vien
            """)
    Optional<NhanVien> findNhanVienBy_MaNhanVien(String ma_nhan_vien);

    @Query("""
            SELECT nv FROM nhan_vien nv WHERE nv.taiKhoanFE = :taiKhoanFE
            """)
    Optional<NhanVien> findNhanVienBy_TaiKhoanFE(String taiKhoanFE);

}
