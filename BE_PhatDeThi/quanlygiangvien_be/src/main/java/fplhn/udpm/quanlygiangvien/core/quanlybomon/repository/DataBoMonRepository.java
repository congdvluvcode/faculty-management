package fplhn.udpm.quanlygiangvien.core.quanlybomon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlybomon.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.repository.BoMonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataBoMonRepository extends BoMonRepository {

    @Query(value = """
            SELECT 
                @row_number \\:= @row_number + 1 AS stt,
                bm.id AS id,
                bm.ten AS ten,
                bm.xoa_mem AS trangThai
            FROM 
                (SELECT @row_number \\:= :startItem) AS init,
                bo_mon AS bm
            WHERE
                (
                    :searchName IS NULL
                    OR
                    bm.ten REGEXP :searchName
                )
            ORDER BY bm.id DESC
            """,
            countQuery = """
            SELECT COUNT(*) 
            FROM bo_mon 
            WHERE
                (
                    :searchName IS NULL
                    OR
                    ten REGEXP :searchName
                )
            """,
            nativeQuery = true)
    Page<BoMonResponse> getAllBoMon(
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
        FROM bo_mon 
        WHERE LOWER(ten) LIKE LOWER(:ten)            
        """, nativeQuery = true)
    boolean existsByTen(@Param("ten") String name);

    @Query(value = """
        SELECT 
            CASE 
                WHEN COUNT(*) > 0
                THEN \\"true\\"
                ELSE \\"false\\"
            END
        FROM bo_mon 
        WHERE id != :id AND LOWER(ten) LIKE LOWER(:ten)            
        """, nativeQuery = true)
    boolean existsByTenWidthOutId(@Param("id") Long id, @Param("ten") String name);

    @Query(value = """
            SELECT 
                0 AS stt,
                bm.id AS id,
                bm.ten AS ten,
                bm.xoa_mem AS trangThai
            FROM bo_mon AS bm
            WHERE bm.id = :id
            """,
            nativeQuery = true)
    Optional<BoMonResponse> getBoMonById(@Param("id") Long id);
}
