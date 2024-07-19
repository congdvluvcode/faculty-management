package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository;

import fplhn.udpm.quanlygiangvien.entity.BoMon;
import fplhn.udpm.quanlygiangvien.repository.BoMonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QLNVBoMonRepository extends BoMonRepository {

    @Query("""
            SELECT bm FROM bo_mon bm WHERE bm.ten = :tenBoMon
            """)
    Optional<BoMon> getBoMonByTen(String tenBoMon);

}
