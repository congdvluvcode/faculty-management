package fplhn.udpm.quanlygiangvien.repository;

import fplhn.udpm.quanlygiangvien.entity.BoMonTheoCoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoMonTheoCoSoRepository extends JpaRepository<BoMonTheoCoSo,Long> {
}
