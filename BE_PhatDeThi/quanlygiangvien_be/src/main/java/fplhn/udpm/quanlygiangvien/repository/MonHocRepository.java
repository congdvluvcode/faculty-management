package fplhn.udpm.quanlygiangvien.repository;

import fplhn.udpm.quanlygiangvien.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc,Long> {
}
