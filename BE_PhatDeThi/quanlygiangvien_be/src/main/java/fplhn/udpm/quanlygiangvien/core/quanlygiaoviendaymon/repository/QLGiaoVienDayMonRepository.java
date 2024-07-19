package fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDataFillTableResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDataUpdateResponse;
import fplhn.udpm.quanlygiangvien.core.quanlygiaoviendaymon.model.response.GetDetailGiaoVienDayMonResponse;
import fplhn.udpm.quanlygiangvien.repository.GiaoVienDayMonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QLGiaoVienDayMonRepository extends GiaoVienDayMonRepository {

    @Query(value = """
        SELECT  gvdm.id AS idGiaoVienDayMon,
                nv.ma_nhan_vien AS maGiaoVien,
                nv.ten AS tenGiaoVien,
                mh.ma_mon AS maMonHoc,
                mh.ten AS tenMonHoc,
                mh.hinh_thuc AS hinhThuc,
                hk.ten AS tenHocKy
        FROM giao_vien_day_mon gvdm\s
        LEFT JOIN nhan_vien nv ON gvdm.id_giao_vien = nv.id
        LEFT JOIN hoc_ky hk ON gvdm.id_hoc_ky_gan_nhat = hk.id
        LEFT JOIN mon_hoc mh ON gvdm.id_mon_hoc = mh.id
    """, nativeQuery = true)
    Page<GetDataFillTableResponse> getDataFillTable(Pageable pageable);

    @Query(value = """
        SELECT  gvdm.id AS idGiaoVienDayMon,
        		nv.ma_nhan_vien AS maGiaoVien,
        		nv.ten AS tenGiaoVien,
                hk.ten AS tenHocKy,
                bm.ten AS tenBoMon,
        		mh.ma_mon AS maMonHoc,
        		mh.ten AS tenMonHoc,
        		mh.hinh_thuc AS hinhThuc,
        		mh.trang_thai AS trangThai
        FROM giao_vien_day_mon gvdm\s
        LEFT JOIN hoc_ky hk ON gvdm.id_hoc_ky_gan_nhat = hk.id
        LEFT JOIN mon_hoc mh ON gvdm.id_mon_hoc = mh.id
        LEFT JOIN nhan_vien nv ON gvdm.id_giao_vien = nv.id
        LEFT JOIN bo_mon_theo_co_so bmtcs ON nv.id_bo_mon_theo_co_so = bmtcs.id
        LEFT JOIN bo_mon bm ON bmtcs.id_bo_mon = bm.id
        WHERE gvdm.id = :idGiaoVienDayMon
    """, nativeQuery = true)
    GetDetailGiaoVienDayMonResponse getDetailGVDMById(Long idGiaoVienDayMon);

    @Query(value = """
        SELECT  gvdm.id AS idGiaoVienDayMon,
        		nv.id AS idGiaoVien,
        		mh.id AS idMonHoc,
                hk.id AS idHocKy,
                nv.ten AS tenGiaoVien,
                mh.ten AS tenMonHoc,
                hk.ten AS tenHocKy
        FROM giao_vien_day_mon gvdm\s
        LEFT JOIN hoc_ky hk ON gvdm.id_hoc_ky_gan_nhat = hk.id
        LEFT JOIN mon_hoc mh ON gvdm.id_mon_hoc = mh.id
        LEFT JOIN nhan_vien nv ON gvdm.id_giao_vien = nv.id
        WHERE gvdm.id = :idGiaoVienDayMon
    """, nativeQuery = true)
    GetDataUpdateResponse getDataUpdateById(Long idGiaoVienDayMon);

}