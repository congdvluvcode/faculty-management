package fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListNhanVienResponse;
import fplhn.udpm.quanlygiangvien.repository.NhanVienRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLLMNhanVienRepository extends NhanVienRepository {

    @Query(value = """
                SELECT 	nv.id AS nhanVienId,
                		nv.ten AS tenNhanVien
                FROM nhan_vien nv
                JOIN bo_mon_theo_co_so bmtcs ON nv.id_bo_mon_theo_co_so = bmtcs.id
                JOIN co_so cs ON bmtcs.id_co_so = cs.id
                WHERE nv.xoa_mem = "CHUA_XOA" AND trang_thai = "HOAT_DONG" AND cs.id = :coSoId
                """,nativeQuery = true)
    List<ListNhanVienResponse> getListNhanVienByCoSoId(Long coSoId);

}
