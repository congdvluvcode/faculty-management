package fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.impl;

import fplhn.udpm.quanlygiangvien.core.quanlyhocky.repository.QLHocKyRepository;
import fplhn.udpm.quanlygiangvien.core.quanlyhocky.service.HocKyService;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HocKyServiceImpl implements HocKyService {

    private final QLHocKyRepository qlHocKyRepository;

    @Override
    public Page<HocKy> getPageHocKy(Pageable pageable) {
        return qlHocKyRepository.findAll(pageable);
    }

    @Override
    public Optional<HocKy> getById(Long id) {
        return qlHocKyRepository.findById(id);
    }

    @Override
    public HocKy insert(HocKy hocKy) {
        return qlHocKyRepository.save(hocKy);
    }

    @Override
    public HocKy update(HocKy hocKy, HocKy hocKyUpdate) {
        hocKy.setTen(hocKyUpdate.getTen());
        hocKy.setNam(hocKyUpdate.getNam());
        hocKy.setThoiGianBatDau(hocKyUpdate.getThoiGianBatDau());
        hocKy.setXoaMem(hocKyUpdate.getXoaMem());
        return qlHocKyRepository.save(hocKy);
    }

    @Override
    public boolean delete(Long id) {
        try {
            qlHocKyRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
