package fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganh.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import fplhn.udpm.quanlygiangvien.repository.ChuyenNganhRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface DataChuyenNganhRepository extends ChuyenNganhRepository {

    @Query(value = """
            SELECT 
                @row_number \\:= @row_number + 1 AS stt,
                cn.id AS id,
                cn.id_bo_mon AS idBoMon,
                cn.ten AS ten,
                cn.xoa_mem AS trangThai
            FROM 
                (SELECT @row_number \\:= :startItem) AS init,
                chuyen_nganh AS cn
            WHERE
                id_bo_mon = :id
                AND
                (
                    :searchName IS NULL
                    OR
                    cn.ten REGEXP :searchName
                )
            ORDER BY cn.id DESC
            """,
            countQuery = """
            SELECT COUNT(*) 
            FROM chuyen_nganh 
            WHERE
                id_bo_mon = :id
                AND
                (
                    :searchName IS NULL
                    OR
                    ten REGEXP :searchName
                )
            """,
            nativeQuery = true)
    Page<ChuyenNganhResponse> getAllChuyenNganh(
            @Param("id") Long idBoMon,
            @Param("startItem") Long startItem,
            Pageable pageable,
            @Param("searchName") String searchName
    );

    @Query(value = """
        SELECT 
            CASE 
                WHEN COUNT(*) > 0
                THEN \\"true\\"
                ELSE \\"false\\"
            END
        FROM chuyen_nganh 
        WHERE id_bo_mon = :id AND LOWER(ten) LIKE LOWER(:ten)            
        """, nativeQuery = true)
    boolean existsByTen(@Param("id") Long idBoMon, @Param("ten") String name);

    @Query(value = """
        SELECT 
            CASE 
                WHEN COUNT(*) > 0
                THEN \\"true\\"
                ELSE \\"false\\"
            END
        FROM chuyen_nganh 
        WHERE id != :id AND LOWER(ten) LIKE LOWER(:ten)            
        """, nativeQuery = true)
    boolean existsByTenWidthOutId(@Param("id") Long id, @Param("ten") String name);

    @Query(value = """
            SELECT 
                0 AS stt,
                cn.id AS id,
                cn.id_bo_mon AS idBoMon,
                cn.ten AS ten,
                cn.xoa_mem AS trangThai
            FROM chuyen_nganh AS cn
            WHERE cn.id = :id
            """,
            nativeQuery = true)
    Optional<ChuyenNganhResponse> getChuyenNganhById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = """
            UPDATE chuyen_nganh 
            SET xoa_mem = :#{T(fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem).DA_XOA.name()}
            WHERE id_bo_mon = :id
            """,
            nativeQuery = true)
    void updateXoaMemAllChuyenNganhByIdBoMon(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = """
            DELETE 
            FROM chuyen_nganh 
            WHERE id_bo_mon = :id
            """,
            nativeQuery = true)
    void deleteAllChuyenNganhByIdBoMon(@Param("id") Long id);
}
