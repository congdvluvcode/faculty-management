package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.ChuyenNganhResponse;
import fplhn.udpm.quanlygiangvien.repository.BoMonRepository;
import fplhn.udpm.quanlygiangvien.repository.ChuyenNganhRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("quanLyChuyenNganhTheoCoSo_data_boMon")
public interface DataBoMonRepository extends BoMonRepository {
    @Query(value = """
            SELECT 
                id,
                ten
            FROM bo_mon
            WHERE 
                xoa_mem = :#{T(fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem).CHUA_XOA.name()}
            """,
            nativeQuery = true)
    List<BoMonResponse> getAllBoMon();

}
