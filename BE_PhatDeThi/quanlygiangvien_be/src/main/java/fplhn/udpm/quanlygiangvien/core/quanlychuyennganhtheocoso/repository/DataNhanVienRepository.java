package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.NhanVienResponse;
import fplhn.udpm.quanlygiangvien.repository.NhanVienRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("quanLyChuyenNganhTheoCoSo_data_nhanVien")
public interface DataNhanVienRepository extends NhanVienRepository {

    @Query(value = """
            SELECT 
                nv.id,
                nv.ten,
                nv.ma_nhan_vien AS maNhanVien,
                bmtcs.id_bo_mon AS idBoMon
            FROM nhan_vien AS nv
            LEFT JOIN bo_mon_theo_co_so AS bmtcs ON bmtcs.id = nv.id_bo_mon_theo_co_so
            WHERE 
                nv.id = :idNhanVien AND
                nv.id_bo_mon_theo_co_so = :idBoMonTheoCoSo
            """,
            nativeQuery = true)
    Optional<NhanVienResponse> getNhanVienByIdAndIdBoMonCoSo(@Param("idNhanVien") Long idNhanVien, @Param("idBoMonTheoCoSo") Long idBoMonTheoCoSo);

    @Query(value = """
            SELECT 
                nv.id,
                nv.ten,
                nv.ma_nhan_vien AS maNhanVien,
                bmtcs.id_bo_mon AS idBoMon
            FROM nhan_vien AS nv
            LEFT JOIN bo_mon_theo_co_so AS bmtcs ON bmtcs.id = nv.id_bo_mon_theo_co_so
            WHERE 
                nv.xoa_mem = :#{T(fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem).CHUA_XOA.name()}
            """,
            nativeQuery = true)
    List<NhanVienResponse> getAllNhanVien();
}
