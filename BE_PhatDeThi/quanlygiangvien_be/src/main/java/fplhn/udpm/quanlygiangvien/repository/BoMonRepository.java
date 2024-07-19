package fplhn.udpm.quanlygiangvien.repository;

import fplhn.udpm.quanlygiangvien.entity.BoMon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoMonRepository extends JpaRepository<BoMon,Long> {
}
