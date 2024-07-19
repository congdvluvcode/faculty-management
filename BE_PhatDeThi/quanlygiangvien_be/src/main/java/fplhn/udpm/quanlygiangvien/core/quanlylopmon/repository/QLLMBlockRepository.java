package fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListBlockResponse;
import fplhn.udpm.quanlygiangvien.repository.BlockRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLLMBlockRepository extends BlockRepository {

    @Query(value = """
                SELECT
                b.id AS blockId,
                b.ten AS tenBlock FROM block b
                JOIN hoc_ky hk ON hk.id = b.id_hoc_ky
                WHERE hk.id = :hocKyId AND b.xoa_mem = "CHUA_XOA"
                """,nativeQuery = true)
    List<ListBlockResponse> getListBlockByHocKyId(Long hocKyId);

}
