package fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request.PostLopMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListLopMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.LopMonDetailResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.LopMonResponse;
import fplhn.udpm.quanlygiangvien.repository.LopMonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLLMLopMonRepository extends LopMonRepository {

    @Query(value = """
                SELECT	lm.id AS lopMonId,
                		mh.ten AS tenMonHoc,
                		lm.ma_lop AS maLop,
                		lm.phong AS phongHoc,
                		lm.ca AS caHoc,
                		lm.ngay AS ngayBatDau,
                		nv.ten AS tenGiaoVien,
                		b.ten AS tenBlock,
                		cs.ten AS tenCoSo,
                		lm.xoa_mem AS trangThai
                FROM lop_mon lm
                JOIN block b ON lm.id_block = b.id
                JOIN campus c ON lm.id_campus = c.id
                JOIN mon_hoc mh ON lm.id_mon_hoc = mh.id
                JOIN nhan_vien nv ON lm.id_nhan_vien = nv.id
                JOIN co_so cs ON c.id_co_so = cs.id
                WHERE
                (
                mh.ten LIKE CONCAT("%", IFNULL(NULLIF(:input ,""),mh.ten) , "%") OR
                lm.ma_lop LIKE CONCAT("%", IFNULL(NULLIF(:input ,"") ,lm.ma_lop), "%") OR
                lm.phong LIKE CONCAT("%", IFNULL(NULLIF(:input,"") ,lm.phong), "%") OR
                lm.ca LIKE CONCAT("%", IFNULL(NULLIF(:input,"") ,lm.ca), "%") OR
                b.ten LIKE CONCAT("%", IFNULL(NULLIF(:input,"") ,b.ten), "%") OR
                nv.ten LIKE CONCAT("%", IFNULL(NULLIF(:input,"") ,nv.ten), "%")
                )
                ORDER BY lm.id DESC
                """,nativeQuery = true)
    Page<ListLopMonResponse> searchLopMon(String input , Pageable pageable);

    @Query(value = """
                SELECT	lm.id AS lopMonId,
                        mh.ten AS tenMonHoc,
                		lm.ma_lop AS maLop,
                        lm.phong AS phongHoc,
                        lm.ca AS caHoc,
                        lm.ngay AS ngayBatDau,
                        nv.ten AS tenGiaoVien,
                        b.ten AS tenBlock,
                        cs.ten AS tenCoSo,
                        lm.xoa_mem AS trangThai
                FROM lop_mon lm
                JOIN block b ON lm.id_block = b.id
                JOIN campus c ON lm.id_campus = c.id
                JOIN mon_hoc mh ON lm.id_mon_hoc = mh.id
                JOIN nhan_vien nv ON lm.id_nhan_vien = nv.id
                JOIN co_so cs ON c.id_co_so = cs.id
                """,nativeQuery = true)
    List<ListLopMonResponse> getListLopMon();

    @Query(value = """
                SELECT	lm.id AS lopMonId,
                        mh.ten AS tenMonHoc,
                		lm.ma_lop AS maLop,
                        lm.phong AS phongHoc,
                        lm.ca AS caHoc,
                        lm.ngay AS ngayBatDau,
                        nv.ten AS tenGiaoVien,
                        b.ten AS tenBlock,
                        cs.ten AS tenCoSo,
                        hk.ten AS tenHocKy,
                        lm.xoa_mem AS trangThai
                FROM lop_mon lm
                JOIN block b ON lm.id_block = b.id
                JOIN hoc_ky hk ON b.id_hoc_ky = hk.id
                JOIN campus c ON lm.id_campus = c.id
                JOIN mon_hoc mh ON lm.id_mon_hoc = mh.id
                JOIN nhan_vien nv ON lm.id_nhan_vien = nv.id
                JOIN co_so cs ON c.id_co_so = cs.id
                WHERE lm.id = :lopMonId
                """,nativeQuery = true)
    LopMonDetailResponse getLopMonDetail(Long lopMonId);

    @Query(value = """
                SELECT 	lm.id AS lopMonId,
                		mh.id AS monHocId,
                		lm.ma_lop AS maLop,
                		lm.phong AS phongHoc,
                		lm.ca AS caHoc,
                		lm.ngay AS ngayBatDau,
                		nv.id AS nhanVienId,
                		b.id AS blockId,
                		c.id AS campusId,
                        hk.id AS hocKyId
                FROM lop_mon lm
                JOIN block b ON lm.id_block = b.id
                JOIN campus c ON lm.id_campus = c.id
                JOIN mon_hoc mh ON lm.id_mon_hoc = mh.id
                JOIN nhan_vien nv ON lm.id_nhan_vien = nv.id
                JOIN co_so cs ON c.id_co_so = cs.id
                JOIN hoc_ky hk ON b.id_hoc_ky = hk.id
                WHERE lm.id = :lopMonId
                """,nativeQuery = true)
    LopMonResponse getLopMonByLopMonId(Long lopMonId);

    @Query(value = """
                SELECT
                	CASE
                		WHEN COUNT(*) > 0 THEN "TRUE" ELSE "FALSE"
                    END
                FROM lop_mon lm
                WHERE
                lm.ma_lop = :#{#postLopMonRequest.maLop} AND
                lm.phong = :#{#postLopMonRequest.phongHoc} AND
                lm.ca = :#{#postLopMonRequest.caHoc} AND
                lm.id_mon_hoc = :#{#postLopMonRequest.monHocId} AND
                lm.id_block = :#{#postLopMonRequest.blockId} AND
                lm.id_campus = :#{#postLopMonRequest.campusId} AND
                lm.id_nhan_vien = :#{#postLopMonRequest.nhanVienId}
                """,nativeQuery = true)
    Boolean isLopMonExist(PostLopMonRequest postLopMonRequest);

}
