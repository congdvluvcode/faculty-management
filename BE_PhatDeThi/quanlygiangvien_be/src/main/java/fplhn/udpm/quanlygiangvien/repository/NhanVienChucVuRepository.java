package fplhn.udpm.quanlygiangvien.repository;

import fplhn.udpm.quanlygiangvien.entity.NhanVienChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienChucVuRepository extends JpaRepository<NhanVienChucVu,Long> {
}
