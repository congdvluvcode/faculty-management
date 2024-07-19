package fplhn.udpm.quanlygiangvien.core.quanlycoso.service.impl;

import fplhn.udpm.quanlygiangvien.core.common.ResponseModel;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.model.request.CSCreateCoSoRequest;
import fplhn.udpm.quanlygiangvien.core.quanlycoso.repository.CSCoSoRepository;
import fplhn.udpm.quanlygiangvien.entity.CoSo;
import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CSImportExcel {

    private final CSCoSoRepository csCoSoRepository;

    public List<CoSo> importExcelCoSo(MultipartFile multipartFile){
        List<CoSo> dataList = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            // Iterate through rows
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Iterate through cells
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    CoSo coSo = new CoSo();
                    coSo.setTen(cell.toString());
                    coSo.setXoaMem(XoaMem.CHUA_XOA);
                    Boolean tonTai = csCoSoRepository.existsByTen(coSo.getTen());
                    if(!tonTai){
//                        csCoSoRepository.save(coSo);
                        dataList.add(coSo);
                    }
                }
            }
            System.out.println(dataList);
            return dataList;
        } catch (IOException | InvalidFormatException ex) {
            ex.printStackTrace();
            ex.printStackTrace();
            return dataList;
        }
    }

    public ResponseModel saveImportExcel(List<CoSo> coSos){
        for (CoSo coSo : coSos){
            csCoSoRepository.save(coSo);
        }
        return new ResponseModel( HttpStatus.CREATED,"Import excel file thành công");
    }

//    public String getStringCellValue(Cell cell) {
//        if (cell == null) {
//            return null;
//        }
//        switch (cell.getCellType()) {
//            case :
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return String.valueOf((int) cell.getNumericCellValue());
//            default:
//                return null;
//        }
//    }

}
