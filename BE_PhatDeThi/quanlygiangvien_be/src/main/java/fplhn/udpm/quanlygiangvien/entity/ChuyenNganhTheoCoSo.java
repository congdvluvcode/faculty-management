package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "chuyen_nganh_theo_co_so")
public class ChuyenNganhTheoCoSo extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_bo_mon_theo_co_so")
    private BoMonTheoCoSo boMonTheoCoSo;

    @ManyToOne
    @JoinColumn(name = "id_chuyen_nganh")
    private ChuyenNganh chuyenNganh;

    @ManyToOne
    @JoinColumn(name = "id_truong_mon")
    private NhanVien nhanVien;
}
