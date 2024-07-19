package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "giao_vien_day_mon")
public class GiaoVienDayMon extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_giao_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_mon_hoc")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "id_hoc_ky_gan_nhat")
    private HocKy hocKy;
}
