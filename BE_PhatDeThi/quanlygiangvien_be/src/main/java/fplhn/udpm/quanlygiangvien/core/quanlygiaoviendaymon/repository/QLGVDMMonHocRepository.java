package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenMonHocChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.repository.MonHocRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLGVDMMonHocRepository extends MonHocRepository {

    @Query(value = " SELECT  mh.id, mh.ten FROM mon_hoc mh WHERE mh.xoa_mem = 'CHUA_XOA' ", nativeQuery = true)
    List<GetIdTenMonHocChuaXoaResponse> getMonHocChuaXoa();

}
