package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository;

import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllHocKyResponse;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TenHocKy;
import fplhn.udpm.quanlygiangvien.repository.HocKyRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QLNVHocKyRepository extends HocKyRepository {

    @Query(value = """
                SELECT  h.id AS id,
                        h.ten AS name,
                        h.nam AS nam
                FROM hoc_ky h WHERE h.xoa_mem = "CHUA_XOA" AND h.nam = YEAR(NOW())
                """,nativeQuery = true)
    List<GetAllHocKyResponse> getAllHocKy();

    @Query("""
            SELECT hk FROM hoc_ky hk WHERE hk.ten = :tenHocKy AND hk.nam = :namHocKy
            """)
    Optional<HocKy> getHocKyByTenHocKyAndNamHocKy(TenHocKy tenHocKy, Long namHocKy);

}
