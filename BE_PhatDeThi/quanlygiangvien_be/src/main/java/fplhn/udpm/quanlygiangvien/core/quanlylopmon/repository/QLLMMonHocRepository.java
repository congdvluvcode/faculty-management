package fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository;

import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListMonHocResponse;
import fplhn.udpm.quanlygiangvien.repository.MonHocRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QLLMMonHocRepository extends MonHocRepository {

    @Query(value = """
                SELECT 	mh.id AS monHocId,
                		mh.ten AS tenMonHoc
                FROM mon_hoc mh
                """,nativeQuery = true)
    List<ListMonHocResponse> getListMonHoc();
}
