package fplhn.udpm.quanlygiangvien.core.quanlylopmon.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request.PostLopMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.request.PutLopMonRequest;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListBlockResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListCampusResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListHocKyResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListLopMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListMonHocResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.ListNhanVienResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.LopMonDetailResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.model.response.LopMonResponse;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository.QLLMBlockRepository;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository.QLLMCampusRepository;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository.QLLMHocKyRepository;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository.QLLMLopMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository.QLLMMonHocRepository;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.repository.QLLMNhanVienRepository;
import fplhn.udpm.quanlygiangvien.core.quanlylopmon.service.LopMonService;
import fplhn.udpm.quanlygiangvien.entity.Block;
import fplhn.udpm.quanlygiangvien.entity.Campus;
import fplhn.udpm.quanlygiangvien.entity.LopMon;
import fplhn.udpm.quanlygiangvien.entity.MonHoc;
import fplhn.udpm.quanlygiangvien.entity.NhanVien;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.Ca;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import fplhn.udpm.quanlygiangvien.infrastructure.exception.KeyValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LopMonServiceImpl implements LopMonService {

    private final QLLMLopMonRepository lopMonRepository;

    private final QLLMBlockRepository blockRepository;

    private final QLLMCampusRepository campusRepository;

    private final QLLMHocKyRepository hocKyRepository;

    private final QLLMMonHocRepository monHocRepository;

    private final QLLMNhanVienRepository nhanVienRepository;

    @Override
    public LopMonResponse getLopMonByLopMonId(Long lopMonId) {
        return lopMonRepository.getLopMonByLopMonId(lopMonId);
    }

    @Override
    public LopMonDetailResponse getLopMonDetail(Long lopMonId) {
        return lopMonRepository.getLopMonDetail(lopMonId);
    }

    @Override
    public Page<ListLopMonResponse> searchLopMon(String input , Pageable pageable) {
        return lopMonRepository.searchLopMon(input , pageable);
    }

    @Override
    public List<ListLopMonResponse> getListLopMon() {
        return lopMonRepository.getListLopMon();
    }

    @Override
    public ResponseModel postLopMon(PostLopMonRequest postLopMonRequest) {
        Map<String,String> errors = new HashMap<>();

        //check length
        if(postLopMonRequest.getMaLop().length() > 100){
            errors.put("error","Độ dài của mã lớp phải dưới 100 kí tự!");
        }
        if(postLopMonRequest.getPhongHoc().length() > 100){
            errors.put("error","Độ dài của phòng học phải dưới 100 kí tự!");
        }
        //throw errors
        if(!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //check exist
        Optional<MonHoc> isMonHocExist = monHocRepository.findById(postLopMonRequest.getMonHocId());
        if(isMonHocExist.isEmpty()){
            errors.put("error","Môn học này không tồn tại!");
        }
        Optional<Block> isBlockExist = blockRepository.findById(postLopMonRequest.getBlockId());
        if (isBlockExist.isEmpty()){
            errors.put("error","Block này không tồn tại!");
        }
        Optional<Campus> isCampusExist = campusRepository.findById(postLopMonRequest.getCampusId());
        if (isCampusExist.isEmpty()){
            errors.put("error","Campus này không tồn tại!");
        }
        Optional<NhanVien> isNhanVienExist = nhanVienRepository.findById(postLopMonRequest.getNhanVienId());
        if (isNhanVienExist.isEmpty()){
            errors.put("error","Nhân Viên này không tồn tại!");
        }
        //throw errors
        if(!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //check duplicate
        if(lopMonRepository.isLopMonExist(postLopMonRequest)){
            errors.put("error","Đã có lớp môn này trong hệ thống!");
            throw new KeyValueException(errors);
        }

        //post Lop Mon
        LopMon postLopMon = new LopMon();
        postLopMon.setMaLop(postLopMonRequest.getMaLop());
        postLopMon.setPhong(postLopMonRequest.getPhongHoc());
        postLopMon.setNgay(postLopMonRequest.getNgayHoatDong());
        for (Ca ca : Ca.values()){
            if(postLopMonRequest.getCaHoc().equalsIgnoreCase(ca.name())){
                postLopMon.setCa(ca);
            }
        }
        postLopMon.setXoaMem(XoaMem.CHUA_XOA);
        postLopMon.setMonHoc(isMonHocExist.get());
        postLopMon.setBlock(isBlockExist.get());
        postLopMon.setCampus(isCampusExist.get());
        postLopMon.setNhanVien(isNhanVienExist.get());
        lopMonRepository.save(postLopMon);

        return new ResponseModel(HttpStatus.OK,"Thêm lớp môn thành công!");
    }

    @Override
    public ResponseModel putLopMon(PutLopMonRequest putLopMonRequest) {
        Map<String,String> errors = new HashMap<>();

        //check length
        if(putLopMonRequest.getMaLop().length() > 100){
            errors.put("error","Độ dài của mã lớp phải dưới 100 kí tự!");
        }
        if(putLopMonRequest.getPhongHoc().length() > 100){
            errors.put("error","Độ dài của phòng học phải dưới 100 kí tự!");
        }
        //throw error
        if(!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //check exist
        Optional<MonHoc> isMonHocExist = monHocRepository.findById(putLopMonRequest.getMonHocId());
        if(isMonHocExist.isEmpty()){
            errors.put("error","Môn học này không tồn tại!");
        }
        Optional<Block> isBlockExist = blockRepository.findById(putLopMonRequest.getBlockId());
        if (isBlockExist.isEmpty()){
            errors.put("error","Block này không tồn tại!");
        }
        Optional<Campus> isCampusExist = campusRepository.findById(putLopMonRequest.getCampusId());
        if (isCampusExist.isEmpty()){
            errors.put("error","Campus này không tồn tại!");
        }
        Optional<NhanVien> isNhanVienExist = nhanVienRepository.findById(putLopMonRequest.getNhanVienId());
        if (isNhanVienExist.isEmpty()){
            errors.put("error","Nhân Viên này không tồn tại!");
        }
        //throw error
        if(!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //Nếu mà giữ liệu trả về giống nó ban đầu thì sẽ không check
        Optional<LopMon> isLopMonExist = lopMonRepository.findById(putLopMonRequest.getLopMonId());
        if(isLopMonExist.isEmpty()){
            errors.put("error","Không tìm thấy lớp môn này!");
            throw new KeyValueException(errors);
        }else{
            LopMon checkLopMon = isLopMonExist.get();
            if(     !putLopMonRequest.getMaLop().equalsIgnoreCase(checkLopMon.getMaLop()) ||
                    !putLopMonRequest.getPhongHoc().equalsIgnoreCase(checkLopMon.getPhong()) ||
                    !putLopMonRequest.getCaHoc().equalsIgnoreCase(checkLopMon.getCa().name()) ||
                    !putLopMonRequest.getMonHocId().equals(checkLopMon.getMonHoc().getId()) ||
                    !putLopMonRequest.getBlockId().equals(checkLopMon.getBlock().getId()) ||
                    !putLopMonRequest.getCampusId().equals(checkLopMon.getCampus().getId()) ||
                    !putLopMonRequest.getNhanVienId().equals(checkLopMon.getNhanVien().getId())
            ){
                //check duplicate
                if(lopMonRepository.isLopMonExist(putLopMonRequest)){
                    errors.put("error","Đã có lớp môn này trong hệ thống!");
                    throw new KeyValueException(errors);
                }
            }
        }

        //post Lop Mon
        LopMon putLopMon = lopMonRepository.getReferenceById(putLopMonRequest.getLopMonId());
        putLopMon.setMaLop(putLopMonRequest.getMaLop());
        putLopMon.setPhong(putLopMonRequest.getPhongHoc());
        putLopMon.setNgay(putLopMonRequest.getNgayHoatDong());
        for (Ca ca : Ca.values()){
            if(putLopMonRequest.getCaHoc().equalsIgnoreCase(ca.name())){
                putLopMon.setCa(ca);
            }
        }
        putLopMon.setXoaMem(XoaMem.CHUA_XOA);
        putLopMon.setMonHoc(isMonHocExist.get());
        putLopMon.setBlock(isBlockExist.get());
        putLopMon.setCampus(isCampusExist.get());
        putLopMon.setNhanVien(isNhanVienExist.get());
        lopMonRepository.save(putLopMon);
        return new ResponseModel(HttpStatus.OK,"Cập nhật lớp môn thành công!");
    }

    @Override
    public ResponseModel deleteLopMon(Long lopMonId) {

        Map<String,String> errors = new HashMap<>();

        Optional<LopMon> isLopMonExist = lopMonRepository.findById(lopMonId);
        if(isLopMonExist.isEmpty()){
            errors.put("error","Lớp môn này không tồn tại!");
        }
        //throw Error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        if(isLopMonExist.get().getXoaMem().equals(XoaMem.CHUA_XOA)){
            //update
            isLopMonExist.get().setXoaMem(XoaMem.DA_XOA);
            lopMonRepository.save(isLopMonExist.get());

            return new ResponseModel(HttpStatus.OK,"Xóa Lớp Môn Thành Công!");
        }else{
            //update
            isLopMonExist.get().setXoaMem(XoaMem.CHUA_XOA);
            lopMonRepository.save(isLopMonExist.get());
            return new ResponseModel(HttpStatus.OK,"Lớp Môn Đã Được Hoạt Động Lại!");
        }

    }

    @Override
    public List<ListBlockResponse> getListBlockByHocKyId(Long hocKyId) {
        return blockRepository.getListBlockByHocKyId(hocKyId);
    }

    @Override
    public List<ListCampusResponse> getListCampusByCoSoId(Long coSoId) {
        return campusRepository.getListCampusByCoSoId(coSoId);
    }

    @Override
    public List<ListHocKyResponse> getListHocKyResponse() {
        return hocKyRepository.getListHocKyResponse();
    }

    @Override
    public List<ListMonHocResponse> getListMonHoc() {
        return monHocRepository.getListMonHoc();
    }

    @Override
    public List<ListNhanVienResponse> getListNhanVienByCoSoId(Long coSoId) {
        return nhanVienRepository.getListNhanVienByCoSoId(coSoId);
    }

    @Override
    public Ca[] getListCaHoc() {
        return Ca.values();
    }

}
