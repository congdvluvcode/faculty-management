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
@Entity(name = "campus")
public class Campus extends BaseEntity {

    @Column(name = "ten", length = 255, nullable = true)
    private String ten;

    @ManyToOne
    @JoinColumn(name = "id_co_so")
    private CoSo coSo;
}
