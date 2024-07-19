package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.BoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.repository.BoMonTheoCoSoRepository;
import fplhn.udpm.quanlygiangvien.repository.ChuyenNganhRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("quanLyChuyenNganhTheoCoSo_data_boMonTheoCoSo")
public interface DataBoMonTheoCoSoRepository extends BoMonTheoCoSoRepository {

    @Query(value = """
            SELECT 
                bmtcs.id AS id,
                bmtcs.id_bo_mon AS idBoMon,
                bm.ten AS tenBoMon,
                bmtcs.id_co_so AS idCoSo,
                cs.ten AS tenCoSo,
                bmtcs.xoa_mem AS trangThai
            FROM bo_mon_theo_co_so AS bmtcs
            LEFT JOIN co_so AS cs ON bmtcs.id_co_so = cs.id
            LEFT JOIN bo_mon AS bm ON bmtcs.id_bo_mon = bm.id
            WHERE bmtcs.id = :id
            """,
            nativeQuery = true)
    Optional<BoMonTheoCoSoResponse> getBoMonTheoCoSoById(@Param("id") Long id);

    @Query(value = """
            SELECT 
                bmtcs.id AS id,
                bmtcs.id_bo_mon AS idBoMon,
                bm.ten AS tenBoMon,
                bmtcs.id_co_so AS idCoSo,
                cs.ten AS tenCoSo,
                bmtcs.xoa_mem AS trangThai
            FROM bo_mon_theo_co_so AS bmtcs
            LEFT JOIN co_so AS cs ON bmtcs.id_co_so = cs.id
            LEFT JOIN bo_mon AS bm ON bmtcs.id_bo_mon = bm.id
            WHERE 
                bmtcs.xoa_mem = :#{T(fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem).CHUA_XOA.name()}
            """,
            nativeQuery = true)
    List<BoMonTheoCoSoResponse> getAllBoMonTheoCoSo();

}
