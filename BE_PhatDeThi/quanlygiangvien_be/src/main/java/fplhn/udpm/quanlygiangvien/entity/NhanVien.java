package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.LoaiHopDong;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TrangThaiNhanVien;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nhan_vien")
public class NhanVien extends BaseEntity {

    @Column(name = "ten", length = 255, nullable = true)
    private String ten;

    @Column(name = "ma_nhan_vien", length = 255, nullable = true)
    private String maNhanVien;

    @Column(name = "tai_khoan_fe", length = 255, nullable = true)
    private String taiKhoanFE;

    @Column(name = "loai_hop_dong", columnDefinition = "nvarchar(255)")
    @Enumerated(EnumType.STRING)
    private LoaiHopDong loaiHopDong;

    @Column(name = "trang_thai", columnDefinition = "nvarchar(255)")
    @Enumerated(EnumType.STRING)
    private TrangThaiNhanVien trangThai;

    @ManyToOne
    @JoinColumn(name = "id_bo_mon_theo_co_so")
    private BoMonTheoCoSo boMonTheoCoSo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hoc_ky_tham_gia_day")
    @ToString.Exclude
    private HocKy hocKy;
}
