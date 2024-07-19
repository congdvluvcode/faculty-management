package fplhn.udpm.quanlygiangvien.core.quanlycoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoResponse;
import fplhn.udpm.quanlygiangvien.repository.CoSoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CSCoSoRepository extends CoSoRepository {

    @Query(value = "SELECT (@row_number \\:= @row_number + 1) AS stt, id AS idCoSo, ten AS tenCoSo, xoa_mem AS xoaMemCoSo" +
            " FROM co_so cs" +
            " JOIN (SELECT @row_number \\:= :start) AS init" +
            " WHERE cs.id IN :searchTermList ORDER BY cs.id DESC", nativeQuery = true)
    Page<CSCoSoResponse> paginateAndSearch(Pageable pageable, @Param("searchTermList")Set<String> lisTenCoSo,@Param("start")Long start);

    @Query(value = "SELECT id as idCoSo, ten as tenCoSo, xoa_mem as xoaMemCoSo " +
            "FROM co_so ", nativeQuery = true)
    List<CSCoSoResponse> getAll();

    @Query(value = "SELECT id " +
            " FROM co_so cs" +
            " WHERE cs.ten like CONCAT('%',:searchTermList,'%')", nativeQuery = true)
    Set<String> searchName(@Param("searchTermList")String lisTenCoSo);


    Boolean existsByTen(String ten);

}
