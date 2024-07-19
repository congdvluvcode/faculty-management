package fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSBoMonTheoCoSoResponse;
import fplhn.udpm.quanlygiangvien.core.quanlybomontheocoso.model.response.BMCSNhanVienResponse;
import fplhn.udpm.quanlygiangvien.repository.NhanVienRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BMCSNhanVienRepository extends NhanVienRepository {

    @Query(value = "SELECT nv.id as idNhanVien, nv.ten as tenNhanVien, nv.tai_khoan_fe as taiKhoan" +
            " FROM nhan_vien nv"
        ,nativeQuery = true)
    List<BMCSNhanVienResponse> getAll();

}
