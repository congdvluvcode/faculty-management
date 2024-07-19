package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetIdTenNhanVienChuaXoaResponse;
import fplhn.udpm.quanlygiangvien.repository.NhanVienRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLGVDMNhanVienRepository extends NhanVienRepository {

    @Query(value = " SELECT  nv.id, nv.ten FROM nhan_vien nv WHERE nv.xoa_mem = 'CHUA_XOA' ",nativeQuery = true)
    List<GetIdTenNhanVienChuaXoaResponse> getNhanVienChuaXoa();

}
