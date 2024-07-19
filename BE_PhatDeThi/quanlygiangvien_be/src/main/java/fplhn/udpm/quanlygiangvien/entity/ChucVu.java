package fplhn.udpm.quanlygiangvien.entity;

import fplhn.udpm.quanlygiangvien.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "chuc_vu")
public class ChucVu extends BaseEntity {

    @Column(name = "ten", length = 255, nullable = true)
    private String ten;

    @ManyToOne
    @JoinColumn(name = "id_co_so", nullable = true)
    private CoSo coSo;
}
