package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSBoMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSNhanVienResponse;
import fplhn.udpm.quanlygiangvien.repository.BoMonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BMCSBoMonRepository extends BoMonRepository {

    @Query(value = "SELECT bm.id as idBoMon, bm.ten as tenBoMon" +
            " FROM bo_mon bm"
            ,nativeQuery = true)
    List<BMCSBoMonResponse> getAll();

}
