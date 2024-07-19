package fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlychuyennganhtheocoso.model.response.CoSoResponse;
import fplhn.udpm.quanlygiangvien.repository.CoSoRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("quanLyChuyenNganhTheoCoSo_data_coso")
public interface DataCoSoRepository extends CoSoRepository {
    @Query(value = """
            SELECT 
                id,
                ten
            FROM co_so
            WHERE 
                xoa_mem = :#{T(fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem).CHUA_XOA.name()}
            """,
            nativeQuery = true)
    List<CoSoResponse> getAllCoSo();

}
