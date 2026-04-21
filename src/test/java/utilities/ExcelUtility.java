package utilities;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    private String path;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtility(String path) throws IOException {
        this.path = path;
        FileInputStream fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        fi.close();
    }

    public int getRowCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum(); // index-based
    }

    public int getCellCount(String sheetName, int rownum) {
        sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rownum);
        return (row == null) ? 0 : row.getLastCellNum();
    }

    public String getCellData(String sheetName, int rownum, int colnum) {
        sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rownum);

        if (row == null) return "";

        XSSFCell cell = row.getCell(colnum);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        sheet = workbook.getSheet(sheetName);

        if (sheet == null)
            sheet = workbook.createSheet(sheetName);

        XSSFRow row = sheet.getRow(rownum);
        if (row == null)
            row = sheet.createRow(rownum);

        XSSFCell cell = row.createCell(colnum);
        cell.setCellValue(data);

        FileOutputStream fo = new FileOutputStream(path);
        workbook.write(fo);
        fo.close();
    }

    public void fillColor(String sheetName, int rownum, int colnum, IndexedColors color) throws IOException {
        sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rownum);
        if (row == null) return;

        XSSFCell cell = row.getCell(colnum);
        if (cell == null) return;

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        FileOutputStream fo = new FileOutputStream(path);
        workbook.write(fo);
        fo.close();
    }

    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}