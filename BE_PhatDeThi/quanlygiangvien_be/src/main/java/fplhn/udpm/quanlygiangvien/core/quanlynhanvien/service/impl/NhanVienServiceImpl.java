package fplhn.udpm.quanlygiangvien.core.quanlynhanvien.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.request.PostNhanVienRequest;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.request.PutNhanVienRequest;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllBoMonTheoCoSoByCoSoIdResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllChucVuByCoSoIdResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllHocKyResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetAllNhanVienChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetDetailNhanVienChucVuResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.model.response.GetNhanVienChucVuByIdResponse;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVBoMonRepository;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVBoMonTheoCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVChucVuRepository;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVCoSoRepository;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVHocKyRepository;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVNhanVienChucVuRepository;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.repository.QLNVNhanVienRepository;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.service.NhanVienService;
import fplhn.udpm.quanlygiangvien.core.quanlynhanvien.utils.CheckValid;
import fplhn.udpm.quanlygiangvien.entity.BoMon;
import fplhn.udpm.quanlygiangvien.entity.BoMonTheoCoSo;
import fplhn.udpm.quanlygiangvien.entity.ChucVu;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.entity.HocKy;
import fplhn.udpm.quanlygiangvien.entity.NhanVien;
import fplhn.udpm.quanlygiangvien.entity.NhanVienChucVu;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.LoaiHopDong;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TenHocKy;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.TrangThaiNhanVien;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import fplhn.udpm.quanlygiangvien.infrastructure.exception.KeyValueException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    private final QLNVBoMonTheoCoSoRepository boMonTheoCoSoRepository;

    private final QLNVChucVuRepository chucVuRepository;

    private final QLNVHocKyRepository hocKyRepository;

    private final QLNVNhanVienRepository nhanVienRepository;

    private final QLNVNhanVienChucVuRepository nhanVienChucVuRepository;

    private final QLNVBoMonRepository boMonRepository;

    private final QLNVCoSoRepository coSoRepository;

    private final CheckValid checkValid;

    @Autowired
    public NhanVienServiceImpl(QLNVBoMonTheoCoSoRepository boMonTheoCoSoRepository, QLNVChucVuRepository chucVuRepository,
                               QLNVHocKyRepository hocKyRepository, QLNVNhanVienRepository nhanVienRepository,
                               QLNVNhanVienChucVuRepository nhanVienChucVuRepository, QLNVBoMonRepository boMonRepository,
                               QLNVCoSoRepository coSoRepository, CheckValid checkValid){
        this.boMonTheoCoSoRepository = boMonTheoCoSoRepository;
        this.chucVuRepository = chucVuRepository;
        this.hocKyRepository = hocKyRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.nhanVienChucVuRepository = nhanVienChucVuRepository;
        this.boMonRepository = boMonRepository;
        this.coSoRepository = coSoRepository;
        this.checkValid = checkValid;
    }

    @Override
    public Page<GetAllNhanVienChucVuResponse> getAllNhanVienChucVu(Pageable pageable,String input) {
        return nhanVienChucVuRepository.getAllNhanVienChucVu(pageable,input);
    }

    @Override
    public GetNhanVienChucVuByIdResponse getAllNhanVienChucVuById(Long nhanVienId) {
        return nhanVienChucVuRepository.getAllNhanVienChucVuById(nhanVienId);
    }

    @Override
    public GetDetailNhanVienChucVuResponse getDetailNhanVienChucVu(Long nhanVienId) {
        return nhanVienChucVuRepository.getDetailNhanVienChucVu(nhanVienId);
    }

    @Override
    public List<GetAllHocKyResponse> getAllHocKy() {
        return hocKyRepository.getAllHocKy();
    }

    @Override
    public List<GetAllChucVuByCoSoIdResponse> getAllChucVu_ByCoSoId(Long coSoId) {
        return chucVuRepository.getAllChucVu_ByCoSoId(coSoId);
    }

    @Override
    public List<GetAllBoMonTheoCoSoByCoSoIdResponse> getAllBoMonTheoCoSo_ByCoSoId(Long coSoId) {
        return boMonTheoCoSoRepository.getAllBoMonTheoCoSo_ByCoSoId(coSoId);
    }

    @Override
    public List<LoaiHopDong> getAllLoaiHopDong() {
        return Arrays.asList(LoaiHopDong.values());
    }

    @Override
    public List<TrangThaiNhanVien> getAllTrangThaiNhanVien() {
        return Arrays.asList(TrangThaiNhanVien.values());
    }

    @Override
    public ResponseModel postNhanVien(PostNhanVienRequest postNhanVienRequest) {
        Map<String,String> errors = new HashMap<>();

        //Check space
        if(postNhanVienRequest.getTen().trim().matches(".*\\s{2,}.*")){
            errors.put("ten","Tên Nhân Viên Không Được Có Trên 2 Khoảng Trắng!");
        }
        if(postNhanVienRequest.getMaNhanVien().trim().matches(".*\\s{2,}.*")){
            errors.put("maNhanVien","Mã Nhân Viên Không Được Có Trên 2 Khoảng Trắng!");
        }
        if(postNhanVienRequest.getTaiKhoanFE().trim().matches(".*\\s{2,}.*")){
            errors.put("taiKhoanFE","Tài Khoản FE Không Được Có Trên 2 Khoảng Trắng!");
        }
        //throw error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //Check Valid Length
        if(postNhanVienRequest.getTen().length() > 100){
            errors.put("ten","Độ Dài Của Tên Nhân Viên Phải Nhỏ Hơn 100!");
        }
        if(postNhanVienRequest.getMaNhanVien().length() > 100){
            errors.put("maNhanVien","Độ Dài Của Mã Nhân Viên Phải Nhỏ Hơn 100!");
        }
        if(postNhanVienRequest.getTaiKhoanFE().length() > 100){
            errors.put("taiKhoanFE","Độ Dài Của Tài Khoản FE Phải Nhỏ Hơn 100!");
        }
        //throw error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        if(!postNhanVienRequest.getMaNhanVien().equalsIgnoreCase(
                postNhanVienRequest.getTaiKhoanFE().substring(0,postNhanVienRequest.getTaiKhoanFE().indexOf("@")))
        ){
            errors.put("maNhanVien","Tài Khoản Fe Không Chứa Mã Nhân Viên!");
        }else{
            //check maNhanVien
            if(checkValid.isExistMaNhanVien(postNhanVienRequest.getMaNhanVien())){
                errors.put("maNhanVien","Đã Có Mã Nhân Viên Này Trong Hệ Thống!");
            }
            //check account FE
            if(checkValid.isExistEmailFe(postNhanVienRequest.getTaiKhoanFE())){
                errors.put("taiKhoanFE","Đã Có Tài Khoản FE Này Trong Hệ Thống!");
            }
        }
        //Check Bo Mon Co So
        Optional<BoMonTheoCoSo> isBoMonCoSoNotFound = boMonTheoCoSoRepository.findById(postNhanVienRequest.getBoMonTheoCoSo_id());
        if(isBoMonCoSoNotFound.isEmpty()){
            errors.put("boMonCoSo","Không tìm thấy cơ sở bạn chọn!");
        }
        //Check Hoc Ky
        Optional<HocKy> isHocKyNotFound = hocKyRepository.findById(postNhanVienRequest.getHocKy_id());
        if(isHocKyNotFound.isEmpty()){
            errors.put("hocKy","Không tìm thấy học kỳ bạn chọn!");
        }
        //throw Error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //post Nhan Vien
        NhanVien postNhanVien = new NhanVien();
        postNhanVien.setTen(postNhanVienRequest.getTen());
        postNhanVien.setMaNhanVien(postNhanVienRequest.getMaNhanVien());
        postNhanVien.setTaiKhoanFE(postNhanVienRequest.getTaiKhoanFE());
        for (LoaiHopDong loaiHopDong : LoaiHopDong.values()){
            if(postNhanVienRequest.getLoaiHopDong().equalsIgnoreCase(loaiHopDong.name())){
                postNhanVien.setLoaiHopDong(loaiHopDong);
            }
        }
        postNhanVien.setTrangThai(TrangThaiNhanVien.HOAT_DONG);
        postNhanVien.setBoMonTheoCoSo(isBoMonCoSoNotFound.get());
        postNhanVien.setHocKy(isHocKyNotFound.get());
        postNhanVien.setXoaMem(XoaMem.CHUA_XOA);
        NhanVien nhanVienSaved = nhanVienRepository.save(postNhanVien);

        //post NhanVienChucVu
        for(Long chucVuId : postNhanVienRequest.getChucVu()){
            NhanVienChucVu nhanVienChucVu = new NhanVienChucVu();
            nhanVienChucVu.setNhanVien(nhanVienRepository.getReferenceById(nhanVienSaved.getId()));
            nhanVienChucVu.setChucVu(chucVuRepository.getReferenceById(chucVuId));
            nhanVienChucVu.setXoaMem(XoaMem.CHUA_XOA);
            nhanVienChucVuRepository.save(nhanVienChucVu);
        }

        return new ResponseModel(HttpStatus.CREATED,"Thêm Mới Nhân Viên Thành Công!");
    }

    @Override
    public ResponseModel putNhanVien(PutNhanVienRequest putNhanVienRequest) {
        Map<String,String> errors = new HashMap<>();

        //Check space
        if(putNhanVienRequest.getTen().trim().matches(".*\\s{2,}.*")){
            errors.put("ten","Tên Nhân Viên Không Được Có Trên 2 Khoảng Trắng!");
        }
        if(putNhanVienRequest.getMaNhanVien().trim().matches(".*\\s{2,}.*")){
            errors.put("maNhanVien","Mã Nhân Viên Không Được Có Trên 2 Khoảng Trắng!");
        }
        if(putNhanVienRequest.getTaiKhoanFE().trim().matches(".*\\s{2,}.*")){
            errors.put("taiKhoanFE","Tài Khoản FE Không Được Có Trên 2 Khoảng Trắng!");
        }
        //throw error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //Check Valid Length
        if(putNhanVienRequest.getTen().length() > 100){
            errors.put("ten","Độ Dài Của Tên Nhân Viên Phải Nhỏ Hơn 100!");
        }
        if(putNhanVienRequest.getMaNhanVien().length() > 100){
            errors.put("maNhanVien","Độ Dài Của Mã Nhân Viên Phải Nhỏ Hơn 100!");
        }
        if(putNhanVienRequest.getTaiKhoanFE().length() > 100){
            errors.put("taiKhoanFE","Độ Dài Của Tài Khoản FE Phải Nhỏ Hơn 100!");
        }
        //throw error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //Check contain
        if(!putNhanVienRequest.getMaNhanVien().equalsIgnoreCase(
                putNhanVienRequest.getTaiKhoanFE().substring(0,putNhanVienRequest.getTaiKhoanFE().indexOf("@")))
        ){
            errors.put("maNhanVien","Tài Khoản Fe Không Chứa Mã Nhân Viên!");
        }
        //throw Error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //Check NhanVien Exist
        Optional<NhanVien> isNhanVienExist = nhanVienRepository.findById(putNhanVienRequest.getId());
        if(!putNhanVienRequest.getMaNhanVien().equalsIgnoreCase(isNhanVienExist.get().getMaNhanVien())){
            //Nếu mà nhân viên này trùng dữ liệu với nhân viên id mang về thì không check
            if(checkValid.isExistMaNhanVien(putNhanVienRequest.getMaNhanVien())){
                errors.put("maNhanVien","Đã Có Mã Nhân Viên Này Trong Hệ Thống!");
            }
        }
        if(!putNhanVienRequest.getTaiKhoanFE().equalsIgnoreCase(isNhanVienExist.get().getTaiKhoanFE())){
            //Nếu mà nhân viên này trùng dữ liệu với nhân viên id mang về thì không check
            if(checkValid.isExistEmailFe(putNhanVienRequest.getTaiKhoanFE())){
                errors.put("taiKhoanFE","Đã Có Tài Khoản FE Này Trong Hệ Thống!");
            }
        }
        //Check Bo Mon Co So
        Optional<BoMonTheoCoSo> isBoMonCoSoNotFound = boMonTheoCoSoRepository.findById(putNhanVienRequest.getBoMonTheoCoSo_id());
        if(isBoMonCoSoNotFound.isEmpty()){
            errors.put("boMonCoSo","Không tìm thấy cơ sở bạn chọn!");
        }
        //Check Hoc Ky
        Optional<HocKy> isHocKyNotFound = hocKyRepository.findById(putNhanVienRequest.getHocKy_id());
        if(isHocKyNotFound.isEmpty()){
            errors.put("hocKy","Không tìm thấy học kỳ bạn chọn!");
        }
        //throw Error
        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        //put Nhan Vien
        NhanVien putNhanVien = isNhanVienExist.get();
        putNhanVien.setTen(putNhanVienRequest.getTen());
        putNhanVien.setMaNhanVien(putNhanVienRequest.getMaNhanVien());
        putNhanVien.setTaiKhoanFE(putNhanVienRequest.getTaiKhoanFE());
        for (LoaiHopDong loaiHopDong : LoaiHopDong.values()){
            if(putNhanVienRequest.getLoaiHopDong().equalsIgnoreCase(loaiHopDong.name())){
                putNhanVien.setLoaiHopDong(loaiHopDong);
            }
        }
        for (TrangThaiNhanVien trangThaiNhanVien : TrangThaiNhanVien.values()){
            if(putNhanVienRequest.getTrangThaiNhanVien().equalsIgnoreCase(trangThaiNhanVien.name())){
                putNhanVien.setTrangThai(trangThaiNhanVien);
            }
        }
        putNhanVien.setBoMonTheoCoSo(isBoMonCoSoNotFound.get());
        putNhanVien.setHocKy(isHocKyNotFound.get());
        NhanVien nhanVienSaved = nhanVienRepository.save(putNhanVien);

        //Delete Nhan Vien Chuc Vu
        for(NhanVienChucVu nhanVienChucVu : nhanVienChucVuRepository.getNhanVienChucVuByNhanVienId(putNhanVien.getId())){
            nhanVienChucVuRepository.deleteById(nhanVienChucVu.getId());
        }

        //Put NhanVienChucVu
        for(Long chucVuId : putNhanVienRequest.getChucVu()){
            NhanVienChucVu nhanVienChucVu = new NhanVienChucVu();
            nhanVienChucVu.setNhanVien(nhanVienRepository.getReferenceById(nhanVienSaved.getId()));
            nhanVienChucVu.setChucVu(chucVuRepository.getReferenceById(chucVuId));
            nhanVienChucVu.setXoaMem(XoaMem.CHUA_XOA);
            nhanVienChucVuRepository.save(nhanVienChucVu);
        }

        return new ResponseModel(HttpStatus.OK,"Cập Nhật Nhân Viên Thành Công!");
    }

    @Override
    public ResponseModel deleteNhanVien(Long nhanVienId) {
        Map<String,String> errors = new HashMap<>();

        Optional<NhanVien> isNhanVienExist = nhanVienRepository.findById(nhanVienId);
        if (isNhanVienExist.isEmpty()){
            errors.put("nhanVienExist","Không tìm thấy nhân viên này!");
        }

        if (!errors.isEmpty()){
            throw new KeyValueException(errors);
        }

        NhanVien deleteNhanVien = isNhanVienExist.get();
        deleteNhanVien.setXoaMem(XoaMem.DA_XOA);
        nhanVienRepository.save(deleteNhanVien);

        return new ResponseModel(HttpStatus.OK,"Xóa Nhân Viên Thành Công!");
    }

    @Override
    public ResponseModel importExcelNhanVien(MultipartFile file) throws IOException {
        Map<String,String> error = new HashMap<>();
        String[] fileNameSplit = file.getOriginalFilename().split("\\.");
        if(!fileNameSplit[1].equalsIgnoreCase("xlsx")){
            error.put("excel","File Bạn Chọn Không Phải Là File Excel!");
        }
        //throw error
        if (!error.isEmpty()){
            throw new KeyValueException(error);
        }
        //check Size
        if(file.getSize() > 10 * 1024 * 1024){
            error.put("excel","Dung Lượng File Không Được Lớn Hơn 10MB!");
        }
        //throw error
        if (!error.isEmpty()){
            throw new KeyValueException(error);
        }

        try{
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet){
                boolean hasData = false;
                for (Cell cell : row) {
                    if (cell.getCellTypeEnum() != CellType.BLANK) {
                        hasData = true;
                        break;
                    }
                }
                if (hasData && row.getRowNum() > 0) {
                    String tenNhanVien = row.getCell(0).getStringCellValue();
                    String maNhanVien = row.getCell(1).getStringCellValue();
                    String taiKhoanFE = row.getCell(2).getStringCellValue();
                    String loaiHopDong = row.getCell(3).getStringCellValue();
                    String boMonTheoCoSo = row.getCell(4).getStringCellValue();
                    String hocKy = row.getCell(5).getStringCellValue();
                    String chucVu = row.getCell(6).getStringCellValue();

                    //check Ma Nhan Vien
                    Boolean maNhanVienValid = checkValid.isExistMaNhanVien(maNhanVien);
                    if (maNhanVienValid){
                        continue;
                    }

                    //check EmailFe
                    Boolean isValidEmailFe = checkValid.isValidEmailFe(taiKhoanFE);
                    if (!isValidEmailFe){
                        continue;
                    }
                    Boolean isExistEmailFe = checkValid.isExistEmailFe(taiKhoanFE);
                    if (isExistEmailFe){
                        continue;
                    }

                    //check exist BMCS
                    String tenBoMon = boMonTheoCoSo.split("-")[0].trim();
                    String tenCoSo = boMonTheoCoSo.split("-")[1].trim();
                    Optional<BoMon> isBoMonExist = boMonRepository.getBoMonByTen(tenBoMon);
                    if (isBoMonExist.isEmpty()){
                        continue;
                    }
                    Optional<CoSo> isCoSoExist = coSoRepository.getCoSoByTen(tenCoSo);
                    if (isCoSoExist.isEmpty()){
                        continue;
                    }
                    Optional<BoMonTheoCoSo> isBoMonTheoCoSoExist = boMonTheoCoSoRepository.getBoMonTheoCoSoByBoMonIdAndCoSoId(isBoMonExist.get().getId(),isCoSoExist.get().getId());
                    if (isBoMonTheoCoSoExist.isEmpty()){
                        continue;
                    }

                    //check Exist HocKy
                    String tenHocKy = hocKy.split("-")[0].trim();
                    String namHocKy = hocKy.split("-")[1].trim();
                    TenHocKy tenHocKyParse = checkValid.parseTenHocKy(tenHocKy);
                    if(tenHocKyParse == null){
                        continue;
                    }
                    Optional<HocKy> isHocKyExist = hocKyRepository.getHocKyByTenHocKyAndNamHocKy(tenHocKyParse,Long.parseLong(namHocKy));
                    if (isHocKyExist.isEmpty()){
                        continue;
                    }

                    //check List ChucVu
                    String[] listTenChucVu = chucVu.split(",");
                    for(String tenChucVu : listTenChucVu){
                        Optional<ChucVu> isChucVuExist = chucVuRepository.getChucVuByTen(tenChucVu);
                        if (isChucVuExist.isEmpty()){
                            break;
                        }
                    }

                    //add
                    //Add Nhan Vien
                    NhanVien postNhanVien = new NhanVien();
                    postNhanVien.setTen(tenNhanVien);
                    postNhanVien.setMaNhanVien(maNhanVien);
                    postNhanVien.setTaiKhoanFE(taiKhoanFE);
                    for(LoaiHopDong lhd : LoaiHopDong.values()){
                        if (loaiHopDong.equalsIgnoreCase(lhd.name())){
                            postNhanVien.setLoaiHopDong(lhd);
                        }
                    }
                    postNhanVien.setTrangThai(TrangThaiNhanVien.HOAT_DONG);
                    postNhanVien.setBoMonTheoCoSo(isBoMonTheoCoSoExist.get());
                    postNhanVien.setXoaMem(XoaMem.CHUA_XOA);
                    postNhanVien.setHocKy(isHocKyExist.get());
                    NhanVien nhanVienSaved = nhanVienRepository.save(postNhanVien);

                    //Add NhanVien ChucVu
                    for(String tenChucVu : listTenChucVu){
                        Optional<ChucVu> isChucVuExist = chucVuRepository.getChucVuByTen(tenChucVu);

                        NhanVienChucVu postNhanVienChucVu = new NhanVienChucVu();
                        postNhanVienChucVu.setNhanVien(nhanVienSaved);
                        postNhanVienChucVu.setChucVu(isChucVuExist.get());
                        postNhanVienChucVu.setXoaMem(XoaMem.CHUA_XOA);
                        nhanVienChucVuRepository.save(postNhanVienChucVu);
                    }
                }
            }
        }catch (IOException e){
            error.put("error","Đã sảy ra một vài lỗi nhỏ!");
            throw new KeyValueException(error);
        }
        return new ResponseModel(HttpStatus.CREATED,"Import File Thành Công!");
    }

}
