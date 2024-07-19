package fplhn.udpm.quanlygiangvien.repository;

import fplhn.udpm.quanlygiangvien.entity.ChuyenNganhTheoCoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenNganhTheoCoSoRepository extends JpaRepository<ChuyenNganhTheoCoSo,Long> {
}
