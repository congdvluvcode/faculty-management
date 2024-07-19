package fplhn.udpm.quanlygiangvien.core.quanlyblock.model.request;

import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PutBlockRequest extends PostBlockRequest{

    private Long id;

    private XoaMem xoaMem;
}
