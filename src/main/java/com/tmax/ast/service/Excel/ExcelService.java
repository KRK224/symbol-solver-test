package com.tmax.ast.service.Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmax.ast.service.Excel.impl.ClassExcel;
import com.tmax.ast.service.Excel.impl.MceExcel;
import com.tmax.ast.service.Excel.impl.MdExcel;
import com.tmax.ast.service.Excel.impl.MvdExcel;
import com.tmax.ast.service.Excel.impl.SvdExcel;

public class ExcelService {
  private ClassExcel classExcel;
  private MceExcel mceExcel;
  private MdExcel mdExcel;
  private MvdExcel mvdExcel;
  private SvdExcel svdExcel;

  public ExcelService(ClassExcel ce, MceExcel mce, MdExcel mde, MvdExcel mvde, SvdExcel svde) {
    classExcel = ce;
    mceExcel = mce;
    mdExcel = mde;
    mvdExcel = mvde;
    svdExcel = svde;
  }

  public void createExcelFile(String projectName) throws Exception {
    try {
      XSSFWorkbook wb = new XSSFWorkbook();
      classExcel.createExcelSheet(wb);
      mceExcel.createExcelSheet(wb);
      mdExcel.createExcelSheet(wb);
      mvdExcel.createExcelSheet(wb);
      svdExcel.createExcelSheet(wb);

      LocalDateTime now = LocalDateTime.now();
      String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss_"));
      File currDir = new File(".");

      String path = currDir.getAbsolutePath();
      String fileLocation = path.substring(0, path.length() - 1) + "result/" +
          formatedNow
          + projectName + ".xlsx";
      System.out.println(fileLocation);
      FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);
      wb.write(fileOutputStream);
      wb.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }

  }

}
