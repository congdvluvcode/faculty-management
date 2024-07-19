package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository;

import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllChucVuByCoSoIdResponse;
import fplhn.udpm.quanlygiangvien.entity.ChucVu;
import fplhn.udpm.quanlygiangvien.repository.ChucVuRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QLNVChucVuRepository extends ChucVuRepository {

    @Query(value = """
                SELECT  cv.id AS id,
                        cv.ten AS name
                FROM chuc_vu cv
                WHERE cv.id_co_so = :coSoId
                AND xoa_mem = "CHUA_XOA"
                """,nativeQuery = true)
    List<GetAllChucVuByCoSoIdResponse> getAllChucVu_ByCoSoId(Long coSoId);

    @Query("""
            SELECT cv FROM chuc_vu cv WHERE cv.ten = :tenChucVu AND cv.coSo.id = 1
            """)
    Optional<ChucVu> getChucVuByTen(String tenChucVu);

}
