package fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PutLopMonRequest extends PostLopMonRequest{

    private Long lopMonId;

}
