package fplhn.udpm.quanlygiangvien.core.quanlyhocky.service;

import fplhn.udpm.quanlygiangvien.entity.HocKy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HocKyService {

    Page<HocKy> getPageHocKy(Pageable pageable);

    Optional<HocKy> getById(Long id);

    HocKy insert(HocKy hocKy);

    HocKy update(HocKy hocKy, HocKy hocKyUpdate);

    boolean delete(Long id);

}
