package fplhn.udpm.quanlygiangvien.entity.base;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "xoa_mem")
    @Enumerated(EnumType.STRING)
    private XoaMem xoaMem;
}
