package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.request.GetChuyenNganhTheoCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.repository.ChuyenNganhRepository;
import fplhn.udpm.quanlygiangvien.repository.ChuyenNganhTheoCoSoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataChuyenNganhTheoCoSoRepository extends ChuyenNganhTheoCoSoRepository {

    @Query(value = """
            SELECT 
                @row_number \\:= @row_number + 1 AS stt,
                cntcs.id AS id,
                cntcs.id_bo_mon_theo_co_so AS idBoMonTheoCoSo,
                bm.id AS idBoMon,
                bm.ten AS tenBoMon,
                cntcs.id_chuyen_nganh AS idChuyenNganh,
                cn.ten AS tenChuyenNganh,
                cs.id AS idCoSo,
                cs.ten AS tenCoSo,
                cntcs.id_truong_mon AS idTruongMon,
                nv.ten AS tenTruongMon,
                cntcs.xoa_mem AS trangThai
            FROM 
                (SELECT @row_number \\:= :startItem) AS init,
                chuyen_nganh_theo_co_so AS cntcs
            LEFT JOIN bo_mon_theo_co_so AS bmtcs ON bmtcs.id = cntcs.id_bo_mon_theo_co_so
            LEFT JOIN bo_mon AS bm ON bmtcs.id_bo_mon = bm.id
            LEFT JOIN co_so AS cs ON cs.id = bmtcs.id_co_so
            LEFT JOIN chuyen_nganh AS cn ON cn.id = cntcs.id_chuyen_nganh
            LEFT JOIN nhan_vien AS nv ON nv.id = cntcs.id_truong_mon
            WHERE
                (:#{#dataRequest.tenChuyenNganh} IS NULL OR LOWER(cn.ten) LIKE LOWER(CONCAT('%', :#{#dataRequest.tenChuyenNganh}, '%'))) AND
                (COALESCE(:#{#dataRequest.idBoMon}, 0) = 0 OR bmtcs.id_bo_mon = :#{#dataRequest.idBoMon}) AND
                (COALESCE(:#{#dataRequest.idCoSo}, 0) = 0 OR bmtcs.id_co_so = :#{#dataRequest.idCoSo}) AND
                (COALESCE(:#{#dataRequest.tinhTrang}, 0) = 0 OR cntcs.xoa_mem = :#{#dataRequest.tinhTrang})
            ORDER BY cntcs.id DESC
            """,
            countQuery = """
            SELECT COUNT(*) 
            FROM chuyen_nganh_theo_co_so AS cntcs 
            LEFT JOIN bo_mon_theo_co_so AS bmtcs ON bmtcs.id = cntcs.id_bo_mon_theo_co_so
            WHERE
                (:#{#dataRequest.tenChuyenNganh} IS NULL OR LOWER(cn.ten) LIKE LOWER(CONCAT('%', :#{#dataRequest.tenChuyenNganh}, '%'))) AND
                (COALESCE(:#{#dataRequest.idBoMon}, 0) = 0 OR bmtcs.id_bo_mon = :#{#dataRequest.idBoMon}) AND
                (COALESCE(:#{#dataRequest.idCoSo}, 0) = 0 OR bmtcs.id_co_so = :#{#dataRequest.idCoSo}) AND
                (COALESCE(:#{#dataRequest.tinhTrang}, 0) = 0 OR cntcs.xoa_mem = :#{#dataRequest.tinhTrang})
            """,
            nativeQuery = true)
    Page<ChuyenNganhTheoCoSoResponse> getAllChuyenNganh(
            @Param("dataRequest") GetChuyenNganhTheoCoSoRequest dataRequest,
            @Param("startItem") Long startItem,
            Pageable pageable
    );

    @Query(value = """
        SELECT 
            CASE 
                WHEN COUNT(*) > 0
                THEN \\"true\\"
                ELSE \\"false\\"
            END
        FROM chuyen_nganh_theo_co_so 
        WHERE 
            id_bo_mon_theo_co_so = :idBoMonTheoCoSo AND 
            id_chuyen_nganh = :idChuyenNganh           
        """, nativeQuery = true)
    boolean existsChuyenNganhTheoCoSo(@Param("idBoMonTheoCoSo") Long idBoMonTheoCoSo, @Param("idChuyenNganh") Long idChuyenNganh);

    @Query(value = """
        SELECT 
            CASE 
                WHEN COUNT(*) > 0
                THEN \\"true\\"
                ELSE \\"false\\"
            END
        FROM chuyen_nganh_theo_co_so
        WHERE 
            id != :id AND
            id_bo_mon_theo_co_so = :idBoMonTheoCoSo AND 
            id_chuyen_nganh = :idChuyenNganh             
        """, nativeQuery = true)
    boolean existsChuyenNganhTheoCoSoWidthOutId(@Param("id") Long id, @Param("idBoMonTheoCoSo") Long idBoMonTheoCoSo, @Param("idChuyenNganh") Long idChuyenNganh);

    @Query(value = """
            SELECT 
                0 AS stt,
                cntcs.id AS id,
                cntcs.id_bo_mon_theo_co_so AS idBoMonTheoCoSo,
                bm.id AS idBoMon,
                bm.ten AS tenBoMon,
                cntcs.id_chuyen_nganh AS idChuyenNganh,
                cn.ten AS tenChuyenNganh,
                cs.id AS idCoSo,
                cs.ten AS tenCoSo,
                cntcs.id_truong_mon AS idTruongMon,
                nv.ten AS tenTruongMon,
                cntcs.xoa_mem AS trangThai
            FROM chuyen_nganh_theo_co_so AS cntcs
            LEFT JOIN bo_mon_theo_co_so AS bmtcs ON bmtcs.id = cntcs.id_bo_mon_theo_co_so
            LEFT JOIN bo_mon AS bm ON bm.id = bmtcs.id_bo_mon
            LEFT JOIN co_so AS cs ON cs.id = bmtcs.id_co_so
            LEFT JOIN chuyen_nganh AS cn ON cn.id = cntcs.id_chuyen_nganh
            LEFT JOIN nhan_vien AS nv ON nv.id = cntcs.id_truong_mon
            WHERE cntcs.id = :id
            """,
            nativeQuery = true)
    Optional<ChuyenNganhTheoCoSoResponse> getChuyenNganhTheoCoSoById(@Param("id") Long id);

}
