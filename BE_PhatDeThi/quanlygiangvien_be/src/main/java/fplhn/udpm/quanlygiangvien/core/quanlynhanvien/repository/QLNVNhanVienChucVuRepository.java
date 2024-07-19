package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository;

import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllNhanVienChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetDetailNhanVienChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetNhanVienChucVuByIdResponse;
import fplhn.udpm.quanlygiangvien.entity.NhanVienChucVu;
import fplhn.udpm.quanlygiangvien.repository.NhanVienChucVuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLNVNhanVienChucVuRepository extends NhanVienChucVuRepository {

    @Query(value = """
            SELECT  nv.id AS id,
                    nv.ten AS tenNhanVien,
            		nv.ma_nhan_vien AS maNhanVien,
                    nv.tai_khoan_fe AS taiKhoanFE,
                    nv.loai_hop_dong AS loaiHopDong,
                    nv.trang_thai AS trangThaiNhanVien,
                    bm.ten AS boMon,
                    cs.ten AS coSo,
                    hk.ten AS hocKy,
                    GROUP_CONCAT(DISTINCT cv.ten ORDER BY cv.ten SEPARATOR ',') AS tenChucVu
            FROM nhan_vien nv
            LEFT JOIN nhan_vien_chuc_vu nvcv ON nvcv.id_nhan_vien = nv.id
            LEFT JOIN chuc_vu cv ON nvcv.id_chuc_vu = cv.id
            LEFT JOIN bo_mon_theo_co_so bmtcs ON nv.id_bo_mon_theo_co_so = bmtcs.id
            LEFT JOIN bo_mon bm ON bmtcs.id_bo_mon = bm.id
            LEFT JOIN co_so cs ON bmtcs.id_co_so = cs.id
            LEFT JOIN hoc_ky hk ON nv.id_hoc_ky_tham_gia_day = hk.id
            WHERE nv.xoa_mem = "CHUA_XOA" AND
            (nv.ten LIKE CONCAT("%", IFNULL(NULLIF(:input,''),nv.ten),"%")  OR
            nv.ma_nhan_vien LIKE CONCAT("%", IFNULL(NULLIF(:input,''),nv.ma_nhan_vien) ,"%") OR
            hk.ten LIKE CONCAT("%", IFNULL(NULLIF(:input,''),hk.ten) ,"%") OR
            nv.tai_khoan_fe LIKE CONCAT("%", IFNULL(NULLIF(:input,''),nv.tai_khoan_fe) ,"%") OR
            bm.ten LIKE CONCAT("%", IFNULL(NULLIF(:input,''),bm.ten) ,"%")
            )
            GROUP BY nv.id,nv.ten,nv.ma_nhan_vien,nv.tai_khoan_fe,nv.loai_hop_dong,
                     nv.trang_thai,bm.ten,cs.ten,hk.ten
            ORDER BY nv.id DESC
                """,nativeQuery = true)
    Page<GetAllNhanVienChucVuResponse> getAllNhanVienChucVu(Pageable pageable,String input);

    @Query(value = """
            SELECT  nv.id AS id,
                    nv.ten AS tenNhanVien,
            		nv.ma_nhan_vien AS maNhanVien,
                    nv.tai_khoan_fe AS taiKhoanFE,
                    nv.loai_hop_dong AS loaiHopDong,
                    nv.trang_thai AS trangThaiNhanVien,
                    bm.id AS boMonId,
                    cs.ten AS coSo,
                    hk.id AS hocKyId,
                    GROUP_CONCAT(DISTINCT cv.id ORDER BY cv.ten SEPARATOR ',') AS chucVuId
            FROM nhan_vien nv
            LEFT JOIN nhan_vien_chuc_vu nvcv ON nvcv.id_nhan_vien = nv.id
            LEFT JOIN chuc_vu cv ON nvcv.id_chuc_vu = cv.id
            LEFT JOIN bo_mon_theo_co_so bmtcs ON nv.id_bo_mon_theo_co_so = bmtcs.id
            LEFT JOIN bo_mon bm ON bmtcs.id_bo_mon = bm.id
            LEFT JOIN co_so cs ON bmtcs.id_co_so = cs.id
            LEFT JOIN hoc_ky hk ON nv.id_hoc_ky_tham_gia_day = hk.id
            WHERE nv.xoa_mem = "CHUA_XOA" AND nv.id = :nhanVienId
            GROUP BY nv.id,nv.ten,nv.ma_nhan_vien,nv.tai_khoan_fe,nv.loai_hop_dong,
                     nv.trang_thai,bm.id,cs.ten,hk.id
                """,nativeQuery = true)
    GetNhanVienChucVuByIdResponse getAllNhanVienChucVuById(Long nhanVienId);

    @Query("""
            SELECT nvcv FROM nhan_vien_chuc_vu nvcv WHERE nvcv.nhanVien.id = :nhanVienId
          """)
    List<NhanVienChucVu> getNhanVienChucVuByNhanVienId(Long nhanVienId);

    @Query(value = """
            SELECT  nv.ma_nhan_vien AS maNhanVien,
            		nv.ten AS tenNhanVien,
                    GROUP_CONCAT(DISTINCT cv.ten ORDER BY cv.ten SEPARATOR ',') AS chucVu,
                    hk.ten AS kyOnBroad,
            		nv.tai_khoan_fe AS taiKhoanFE,
                    nv.trang_thai AS trangThai,
            		nv.loai_hop_dong AS loaiHopDong,
                    CONCAT(bm.ten,' - ',cs.ten) AS boMonCoSo
            FROM nhan_vien nv
            LEFT JOIN nhan_vien_chuc_vu nvcv ON nvcv.id_nhan_vien = nv.id
            LEFT JOIN chuc_vu cv ON nvcv.id_chuc_vu = cv.id
            LEFT JOIN bo_mon_theo_co_so bmtcs ON nv.id_bo_mon_theo_co_so = bmtcs.id
            LEFT JOIN bo_mon bm ON bmtcs.id_bo_mon = bm.id
            LEFT JOIN co_so cs ON bmtcs.id_co_so = cs.id
            LEFT JOIN hoc_ky hk ON nv.id_hoc_ky_tham_gia_day = hk.id
            WHERE nv.xoa_mem = "CHUA_XOA" AND nv.id = :nhanVienId
            GROUP BY nv.id,nv.ten,nv.ma_nhan_vien,nv.tai_khoan_fe,nv.loai_hop_dong,
            		 nv.trang_thai,bm.id,cs.ten,hk.id
                """,nativeQuery = true)
    GetDetailNhanVienChucVuResponse getDetailNhanVienChucVu(Long nhanVienId);

}
