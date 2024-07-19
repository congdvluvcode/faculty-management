package fplhn.udpm.quanlygiangvien.core.quanlybomon.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetBoMonRequest {

    private List<String> searchName;

    private int page = 1;

    private int limit = 5;

}
