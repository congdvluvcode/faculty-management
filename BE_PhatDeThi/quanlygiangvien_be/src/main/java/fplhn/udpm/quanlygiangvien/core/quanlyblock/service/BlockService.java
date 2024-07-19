package fplhn.udpm.quanlygiangvien.core.quanlyblock.service;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request.PostBlockRequest;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request.PutBlockRequest;
import fplhn.udpm.quanlygiangvien.entity.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlockService {

    Page<Block> getPage(Pageable pageable);

    Optional<Block> getById(Long id);

    ResponseModel postBlock(PostBlockRequest postBlockRequest);

    ResponseModel putBlock(Long idBlock, PutBlockRequest putBlockRequest);

    ResponseModel xoaMemBlock(Long idBlock);

    List<Block> getBlockByHocKyId(Long id);

}