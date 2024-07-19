package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository;

import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.repository.CoSoRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QLNVCoSoRepository extends CoSoRepository {

    @Query("""
            SELECT cs FROM co_so cs WHERE cs.ten = :tenCoSo
            """)
    Optional<CoSo> getCoSoByTen(String tenCoSo);

}
