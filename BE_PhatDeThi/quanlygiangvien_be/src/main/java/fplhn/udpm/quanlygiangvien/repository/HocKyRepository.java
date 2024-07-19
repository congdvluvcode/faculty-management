package fplhn.udpm.quanlygiangvien.repository;

import fplhn.udpm.quanlygiangvien.entity.HocKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocKyRepository extends JpaRepository<HocKy,Long> {
}
