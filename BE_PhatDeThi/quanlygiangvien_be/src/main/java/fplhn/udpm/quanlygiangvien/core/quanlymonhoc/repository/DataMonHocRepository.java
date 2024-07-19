package fplhn.udpm.quanlygiangvien.core.quanlymonhoc.repository;

import fplhn.udpm.quanlygiangvien.core.quanlymonhoc.model.response.MonHocResponse;
import fplhn.udpm.quanlygiangvien.repository.MonHocRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMonHocRepository extends MonHocRepository {

    @Query(value = "SELECT (@row_number \\:= @row_number + 1) AS stt,mh.id as id, mh.ten as ten, ma_mon as ma, mh.hinh_thuc as hinhThuc, mh.path_noi_quy_thi as pathNoiQuyThi," +
            " mh.trang_thai as trangThai, mh.thoi_gian_tao as thoiGianTao, bm.ten as boMon, bm.id as idBoMon" +
            " FROM mon_hoc mh" +
            " LEFT JOIN bo_mon bm ON mh.id_bo_mon = bm.id" +
            " JOIN (SELECT @row_number \\:= :start) AS init" +
            " WHERE (:ma IS NULL OR mh.ma_mon LIKE %:ma%)" +
            " AND (:ten IS NULL OR mh.ten LIKE %:ten%)" +
            " AND (:trangThai IS NULL OR mh.trang_thai LIKE %:trangThai%)" +
            " AND (:boMon =0 OR mh.id_bo_mon = :boMon)" +
            " AND (:hinhThuc IS NULL OR mh.hinh_thuc LIKE %:hinhThuc%)" +
            " AND (:thoiGianTao IS NULL OR mh.thoi_gian_tao >= :thoiGianTao) ORDER BY mh.id DESC",
            countQuery = "SELECT COUNT(mh.id) FROM mon_hoc mh LEFT JOIN bo_mon bm ON mh.id_bo_mon = bm.id" +
                    " WHERE (:ma IS NULL OR mh.ma_mon LIKE %:ma%)" +
                    " AND (:ten IS NULL OR mh.ten LIKE %:ten%)" +
                    " AND (:trangThai IS NULL OR mh.trang_thai LIKE %:trangThai%)" +
                    " AND (:boMon =0 OR mh.id_bo_mon = :boMon)" +
                    " AND (:hinhThuc IS NULL OR mh.hinh_thuc LIKE %:hinhThuc%)" +
                    " AND (:thoiGianTao IS NULL OR mh.thoi_gian_tao >= :thoiGianTao)",
            nativeQuery = true)
    Page<MonHocResponse> paginateAndSearch(Pageable pageable,
                                           @Param("ma") String ma,
                                           @Param("ten") String ten,
                                           @Param("trangThai") String trangThai,
                                           @Param("boMon")Long boMon,
                                           @Param("hinhThuc") String hinhThuc,
                                           @Param("thoiGianTao") Long thoiGianTao,
                                           @Param("start") Long start);

    @Query(value = """
                SELECT  mh.id AS id,
                        mh.ten AS ten,
                        mh.ma_mon AS ma,
                        mh.hinh_thuc AS hinhThuc,
                        mh.path_noi_quy_thi AS pathNoiQuyThi,
                        mh.trang_thai AS trangThai,
                        mh.thoi_gian_tao AS thoiGianTao,
                        bm.id AS idBoMon,
                        bm.ten AS boMon
                FROM mon_hoc mh
                JOIN bo_mon bm ON mh.id_bo_mon = bm.id
                WHERE  mh.id = :id
                """,nativeQuery = true)
    MonHocResponse getMonHoc(@Param("id") Long id);

    Boolean existsByTenAndIdNot(String ten,Long id);

    Boolean existsByMaMonAndIdNot(String maMon,Long id);

    Boolean existsByTen(String ten);

    Boolean existsByMaMon(String maMon);
}
