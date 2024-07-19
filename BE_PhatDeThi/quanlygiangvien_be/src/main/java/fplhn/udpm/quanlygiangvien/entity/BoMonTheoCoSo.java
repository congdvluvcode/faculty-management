package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "bo_mon_theo_co_so")
public class BoMonTheoCoSo extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_co_so")
    private CoSo coSo;

    @ManyToOne
    @JoinColumn(name = "id_bo_mon")
    private BoMon boMon;

    @ManyToOne
    @JoinColumn(name = "id_chu_nhiem_bo_mon", nullable = true)
    private NhanVien nhanVien;
}
