package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.HinhThuc;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TrangThaiMonHoc;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "mon_hoc")
public class MonHoc extends BaseEntity {

    @Column(name = "ten", length = 255, nullable = true)
    private String ten;

    @Column(name = "ma_mon", length = 255, nullable = true)
    private String maMon;

    @Column(name = "hinh_thuc")
    @Enumerated(EnumType.STRING)
    private HinhThuc hinhThuc;

    @Column(name = "path_noi_quy_thi")
    private String pathNoiQuyThi;

    @Column(name = "trang_thai")
    @Enumerated(EnumType.STRING)
    private TrangThaiMonHoc trangThaiMonHoc;

    @Column(name = "thoi_gian_tao")
    private Long thoiGianTao;

    @ManyToOne
    @JoinColumn(name = "id_bo_mon")
    private BoMon boMon;
}
