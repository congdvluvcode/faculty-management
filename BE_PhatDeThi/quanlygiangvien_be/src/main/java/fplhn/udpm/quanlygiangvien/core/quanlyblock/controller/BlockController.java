package fplhn.udpm.quanlygiangvien.core.quanlyblock.controller;

import fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request.PostBlockRequest;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request.PutBlockRequest;
import fplhn.udpm.quanlygiangvien.core.quanlyblock.service.BlockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/block")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    private int pageSize = 5;

    @GetMapping("/get-list/page={pageIndex}")
    public ResponseEntity<?> getPage(@PathVariable("pageIndex") Optional<Integer> pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex.orElse(0), pageSize, Sort.by("id").descending());
        return ResponseEntity.status(HttpStatus.OK).body(blockService.getPage(pageable));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(blockService.getById(id));
    }

    @GetMapping("/get-block-by-id-hoc-ky/{id}")
    public ResponseEntity<?> getByIdHocKy(@PathVariable("id") Long id) {
        System.out.println(id);
        return ResponseEntity.status(HttpStatus.OK).body(blockService.getBlockByHocKyId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@Valid @RequestBody PostBlockRequest postBlockRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blockService.postBlock(postBlockRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody PutBlockRequest putBlockRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(blockService.putBlock(id, putBlockRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long idBlock) {
        return ResponseEntity.status(HttpStatus.OK).body(blockService.xoaMemBlock(idBlock));
    }

}
