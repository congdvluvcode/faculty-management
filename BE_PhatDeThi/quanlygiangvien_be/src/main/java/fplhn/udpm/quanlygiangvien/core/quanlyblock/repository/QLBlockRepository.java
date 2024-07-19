package fplhn.udpm.quanlygiangvien.core.quanlyblock.repository;

import fplhn.udpm.quanlygiangvien.entity.Block;
import fplhn.udpm.quanlygiangvien.repository.BlockRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLBlockRepository extends BlockRepository {

    @Query(value = "SELECT * FROM block WHERE id_hoc_ky = :idHocKy", nativeQuery = true)
    List<Block> selectBlockByIdHocKy(@Param("idHocKy") Long idHocKy);

}