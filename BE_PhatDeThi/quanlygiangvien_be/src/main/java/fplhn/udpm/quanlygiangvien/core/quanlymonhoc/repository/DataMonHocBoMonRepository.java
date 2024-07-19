package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.repository;

import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.response.BoMonResponse;
import fplhn.udpm.quanlygiangvien.repository.BoMonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMonHocBoMonRepository extends BoMonRepository {
    @Query(value = "SELECT id as id, ten as ten" +
            " FROM bo_mon" +
            " WHERE  xoa_mem = 'CHUA_XOA'", nativeQuery = true)
    List<BoMonResponse> getBoMon();
}
