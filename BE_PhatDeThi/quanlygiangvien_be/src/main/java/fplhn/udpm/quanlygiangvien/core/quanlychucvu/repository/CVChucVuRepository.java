package fplhn.udpm.quanlygiangvien.core.quanlychucvu.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.response.CVChucVuResponse;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.repository.ChucVuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CVChucVuRepository extends ChucVuRepository {

    @Query(value = """
                SELECT  cv.id as idChucVu, 
                        cv.ten as tenChucVu, 
                        cs.id as idCoSo, 
                        cs.ten as tenCoSo, 
                        cv.xoa_mem as trangThai
                FROM chuc_vu cv
                JOIN co_so cs ON cv.id_co_so = cs.id
                WHERE (:idCoSo = 0 OR cv.id_co_so = :idCoSo) AND cv.ten LIKE CONCAT('%', :tenChucVu ,'%')
                """,nativeQuery = true)
    Page<CVChucVuResponse> paginateAndSearch(Pageable pageable, @Param("idCoSo") Long idCoSo, @Param("tenChucVu") String tenChucVu);

    Boolean existsByTenAndCoSo(String ten, CoSo coSo);
}
