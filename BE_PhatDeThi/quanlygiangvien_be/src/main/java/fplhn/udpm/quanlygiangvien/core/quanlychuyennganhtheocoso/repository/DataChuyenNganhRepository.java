package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.repository.ChuyenNganhRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("quanLyChuyenNganhTheoCoSo_data_chuyenNganh")
public interface DataChuyenNganhRepository extends ChuyenNganhRepository {
    @Query(value = """
            SELECT 
                0 AS stt,
                cn.id AS id,
                cn.id_bo_mon AS idBoMon,
                cn.ten AS ten,
                cn.xoa_mem AS trangThai
            FROM chuyen_nganh AS cn
            WHERE 
                cn.id = :idChuyenNganh AND
                cn.id_bo_mon = :idBoMon
            """,
            nativeQuery = true)
    Optional<ChuyenNganhResponse> getChuyenNganhByIdAndIdBoMon(@Param("idChuyenNganh") Long idChuyenNganh, @Param("idBoMon") Long idBoMon);

    @Query(value = """
            SELECT 
                id,
                ten,
                id_bo_mon AS idBoMon,
                xoa_mem AS trangThai
            FROM chuyen_nganh
            WHERE 
                xoa_mem = :#{T(fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem).CHUA_XOA.name()}
            """,
            nativeQuery = true)
    List<ChuyenNganhResponse> getAllChuyenNganh();

}
