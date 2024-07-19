package fplhn.udpm.quanlygiangvien.core.quanlycoso.repository;

import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response.CSCoSoConResponse;
import fplhn.udpm.quanlygiangvien.repository.CampusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CSCoSoConRepository extends CampusRepository {

    @Query(value = "SELECT id as idCoSoCon, id_co_so as idCoSo, ten as tenCoSoCon, xoa_mem as xoaMemCoSoCon " +
            "FROM campus " +
            "WHERE ( id IN :searchTermList) And id_co_so = :idCoSo", nativeQuery = true)
    Page<CSCoSoConResponse> paginateAndSearch(Pageable pageable, @Param("searchTermList") Set<String> lisTenCoSoCon, @Param("idCoSo")Long idCoSo);

    @Query(value = "SELECT id " +
            " FROM campus cs" +
            " WHERE cs.ten like CONCAT('%',:searchTermList,'%')", nativeQuery = true)
    Set<String> searchName(@Param("searchTermList")String lisTenCoSo);

    Boolean existsByTen(String ten);

}
