package fplhn.udpm.quanlygiangvien.core.quanlychucvu.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CVCreateChucVuRequest {

    private long idCoSo;

    private String tenChucVu;

}