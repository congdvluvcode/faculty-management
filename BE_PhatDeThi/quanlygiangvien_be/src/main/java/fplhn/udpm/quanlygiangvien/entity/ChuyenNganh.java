package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "chuyen_nganh")
public class ChuyenNganh extends BaseEntity {

    @Column(name = "ten", length = 255, nullable = true)
    @Nationalized
    private String ten;

    @ManyToOne
    @JoinColumn(name = "id_bo_mon")
    private BoMon boMon;
}
