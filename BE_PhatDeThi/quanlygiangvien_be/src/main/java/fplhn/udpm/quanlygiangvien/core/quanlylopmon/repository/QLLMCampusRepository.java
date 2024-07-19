package fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListCampusResponse;
import fplhn.udpm.quanlygiangvien.repository.CampusRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLLMCampusRepository extends CampusRepository {

    @Query(value = """
            SELECT 	c.id AS campusId,
            		c.ten AS tenCampus
            FROM campus c
            JOIN co_so cs ON c.id_co_so = cs.id
            WHERE c.xoa_mem = "CHUA_XOA" AND id_co_so = :coSoId
            """,nativeQuery = true)
    List<ListCampusResponse> getListCampusByCoSoId(Long coSoId);

}
