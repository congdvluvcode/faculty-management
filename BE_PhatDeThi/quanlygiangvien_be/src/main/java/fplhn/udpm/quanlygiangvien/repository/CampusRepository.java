package fplhn.udpm.quanlygiangvien.repository;

import fplhn.udpm.quanlygiangvien.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends JpaRepository<Campus,Long> {
}
