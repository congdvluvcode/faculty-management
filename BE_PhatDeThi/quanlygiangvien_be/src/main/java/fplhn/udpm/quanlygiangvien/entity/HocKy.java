package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TenHocKy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "hoc_ky")
public class HocKy extends BaseEntity {

    @Column(name = "ten", length = 255, nullable = true)
    @Nationalized
    @Enumerated(EnumType.STRING)
    private TenHocKy ten;

    @Column(name = "nam")
    private Long nam;

    @Column(name = "thoi_gian_bat_dau")
    private LocalDate thoiGianBatDau;
}
