package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenHocKyChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.repository.HocKyRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLGVDMHocKyRepository extends HocKyRepository {

    @Query(value = " SELECT  hk.id, hk.ten FROM hoc_ky hk WHERE hk.xoa_mem = 'CHUA_XOA' ", nativeQuery = true)
    List<GetIdTenHocKyChuaXoaResponse> getIdTenHocKyChuaXoa();

}
