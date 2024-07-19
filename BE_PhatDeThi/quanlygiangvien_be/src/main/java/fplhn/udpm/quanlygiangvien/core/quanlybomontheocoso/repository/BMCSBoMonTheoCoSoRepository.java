package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSBoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.entity.BoMon;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.repository.BoMonTheoCoSoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BMCSBoMonTheoCoSoRepository extends BoMonTheoCoSoRepository {
    @Query(value = """
                SELECT  (@row_number \\:= @row_number + 1) AS stt,
                        bmcs.id as idBoMonTheoCoSo,
                        bm.ten as tenBoMon,
                        cs.ten as tenCoSo,
                        nv.ten as tenTruongBoMon,
                        bmcs.xoa_mem as xoaMem
                FROM bo_mon_theo_co_so bmcs
                LEFT JOIN co_so cs ON bmcs.id_co_so = cs.id
                LEFT JOIN bo_mon bm ON bm.id = bmcs.id_bo_mon
                LEFT JOIN nhan_vien nv ON nv.id = bmcs.id_chu_nhiem_bo_mon
                JOIN (SELECT @row_number \\:= :start) AS init
                WHERE (:idCoSo = 0 OR :idCoSo = cs.id) AND
                bm.ten LIKE CONCAT('%', :tenBoMon, '%')
                ORDER BY bmcs.id DESC
                """,nativeQuery = true)
    Page<BMCSBoMonTheoCoSoResponse> paginateAndSearch(Pageable pageable, @Param("idCoSo") Long idCoSo, @Param("tenBoMon")String tenBoMon,@Param("start")Long start);

    Boolean existsByBoMonAndCoSo(BoMon boMon, CoSo coSo);
}
