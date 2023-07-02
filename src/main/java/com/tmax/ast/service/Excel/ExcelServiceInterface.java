package com.tmax.ast.service.Excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelServiceInterface {
  public abstract void createExcelSheet(XSSFWorkbook wb) throws Exception;
}
