package fplhn.udpm.quanlygiangvien.core.quanlyblock.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request.PostBlockRequest;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request.PutBlockRequest;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.repository.QLBlockRepository;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.service.BlockService;
import fplhn.udpm.quanlygiangvien.core.quanlyhocky.repository.QLHocKyRepository;
import fplhn.udpm.quanlygiangvien.entity.Block;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import fplhn.udpm.quanlygiangvien.infrastructure.exception.KeyValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {

    private final QLBlockRepository qlBlockRepository;
    private final QLHocKyRepository qlHocKyRepository;

    @Override
    public Page<Block> getPage(Pageable pageable) {
        return qlBlockRepository.findAll(pageable);
    }

    @Override
    public Optional<Block> getById(Long id) {
        return qlBlockRepository.findById(id);
    }

    @Override
    public ResponseModel postBlock(PostBlockRequest postBlockRequest) {
        Map<String, String> errors = new HashMap<>();

        if(!postBlockRequest.getTen().trim().contains("BLOCK")) {
            errors.put("ten", "Name is not valid!");
        }

        Optional<HocKy> isHocKyExists = qlHocKyRepository.findById(postBlockRequest.getIdHocKy());
        if(isHocKyExists.isEmpty()) {
            errors.put("hocKy", "Học kỳ không tồn tại!");
        }
        if(!errors.isEmpty()) {
            throw new KeyValueException(errors);
        }

        Block block = new Block();
        block.setTen(postBlockRequest.getTen());
        block.setThoiGianBatDau(postBlockRequest.getThoiGianBatDau());
        block.setThoiGianKetThuc(postBlockRequest.getThoiGianKetThuc());
        block.setHocKy(isHocKyExists.get());
        block.setXoaMem(XoaMem.CHUA_XOA);
        qlBlockRepository.save(block);
        return new ResponseModel(HttpStatus.CREATED, "Add block successfully!", block);
    }

    @Override
    public ResponseModel putBlock(Long idBlock, PutBlockRequest putBlockRequest) {
        Map<String, String> errors = new HashMap<>();

        Optional<Block> isBlockExists = qlBlockRepository.findById(idBlock);
        Optional<HocKy> isHocKyExists = qlHocKyRepository.findById(putBlockRequest.getIdHocKy());
        if(isBlockExists.isEmpty()) {
            errors.put("id", "Block does not exists!");
        }
        if(!putBlockRequest.getTen().trim().contains("BLOCK")) {
            errors.put("ten", "Name is not valid!");
        }
        if(isHocKyExists.isEmpty()) {
            errors.put("idHocKy", "Hoc ky does not exists!");
        }
        if(!errors.isEmpty()) {
            throw new KeyValueException(errors);
        }

        Block blockUpdate = isBlockExists.get();
        blockUpdate.setTen(putBlockRequest.getTen());
        blockUpdate.setThoiGianBatDau(putBlockRequest.getThoiGianBatDau());
        blockUpdate.setThoiGianKetThuc(putBlockRequest.getThoiGianKetThuc());
        blockUpdate.setHocKy(isHocKyExists.get());
        blockUpdate.setXoaMem(putBlockRequest.getXoaMem());
        qlBlockRepository.save(blockUpdate);
        return new ResponseModel(HttpStatus.OK, "Updated successfully!", blockUpdate);
    }

    @Override
    public ResponseModel xoaMemBlock(Long idBlock) {
        Map<String, String> errors = new HashMap<>();

        Optional<Block> isBlockExists = qlBlockRepository.findById(idBlock);

        if(isBlockExists.isEmpty()) {
            errors.put("Block", "Block does not exists!");
        }
        if(!errors.isEmpty()) {
            throw new KeyValueException(errors);
        } else {
            Block block = isBlockExists.get();
            block.setXoaMem(XoaMem.DA_XOA);
            qlBlockRepository.save(block);
        }
        return new ResponseModel(HttpStatus.OK, "Delete successfully!");
    }

    @Override
    public List<Block> getBlockByHocKyId(Long id) {
        List<Block> block = qlBlockRepository.selectBlockByIdHocKy(id); //<-->
        System.out.println(block.get(0).getThoiGianBatDau());
        System.out.println(block.get(0).getThoiGianKetThuc());
//        System.out.println(block.get(1).getThoiGianBatDau());
        return block;
    }

}
