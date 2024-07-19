package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository;

import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllBoMonTheoCoSoByCoSoIdResponse;
import fplhn.udpm.quanlygiangvien.entity.BoMonTheoCoSo;
import fplhn.udpm.quanlygiangvien.repository.BoMonTheoCoSoRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QLNVBoMonTheoCoSoRepository extends BoMonTheoCoSoRepository {

    @Query(value = """
            SELECT  bmtcs.id AS id,
                    bm.ten AS name
            FROM bo_mon_theo_co_so bmtcs JOIN bo_mon bm ON bmtcs.id_bo_mon = bm.id
            WHERE bmtcs.id_co_so = :coSoId AND bmtcs.xoa_mem = "CHUA_XOA"
            """,nativeQuery = true)
    List<GetAllBoMonTheoCoSoByCoSoIdResponse> getAllBoMonTheoCoSo_ByCoSoId(Long coSoId);

    @Query("""
            SELECT bmtcs FROM bo_mon_theo_co_so bmtcs WHERE bmtcs.boMon.id = :boMonId AND bmtcs.coSo.id = :coSoId
            """)
    Optional<BoMonTheoCoSo> getBoMonTheoCoSoByBoMonIdAndCoSoId(Long boMonId,Long coSoId);

}
