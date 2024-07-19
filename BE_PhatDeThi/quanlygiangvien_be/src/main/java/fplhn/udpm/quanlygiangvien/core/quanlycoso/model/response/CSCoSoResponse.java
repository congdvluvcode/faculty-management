package fplhn.udpm.quanlygiangvien.core.quanlycoso.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface CSCoSoResponse {

    Long getStt();

    Long getIdCoSo();

    String getXoaMemCoSo();

    String getTenCoSo();

}
