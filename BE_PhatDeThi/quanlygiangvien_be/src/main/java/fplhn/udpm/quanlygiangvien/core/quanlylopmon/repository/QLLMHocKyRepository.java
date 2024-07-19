package fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListHocKyResponse;
import fplhn.udpm.quanlygiangvien.repository.HocKyRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLLMHocKyRepository extends HocKyRepository {

    @Query(value = """
                SELECT  h.id AS hocKyId,
                		h.ten AS tenHocKy,
                		h.nam AS namHocKy
                FROM hoc_ky h WHERE h.xoa_mem = "CHUA_XOA" AND h.nam = YEAR(NOW())
                """,nativeQuery = true)
    List<ListHocKyResponse> getListHocKyResponse();
}
