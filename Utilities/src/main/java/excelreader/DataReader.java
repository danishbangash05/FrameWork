package excelreader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DataReader {
    protected XSSFSheet excelWorkSheet;
    protected XSSFWorkbook excelWorkBook;
    protected XSSFCell cell;
    protected XSSFRow row;

    public void setExcelFile(String Path) {
        try{
            File file;
            FileInputStream excelFile = new FileInputStream(Path);
            excelWorkBook = new XSSFWorkbook(excelFile);
            //excelWorkSheet = excelWorkBook.getSheet(SheetName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String[][]getExcelSheetData(String sheetName){
        String[][] data = null;
        String[][] myData = null;

        if (excelWorkBook != null){
            XSSFSheet sheet = excelWorkBook.getSheet(sheetName);
            if (sheet != null){
                int rows = sheet.getLastRowNum();
                int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
                int arrayrow = rows + 1;
                data = new String[arrayrow][cols];
                myData = new String[rows][cols];

                for (int i = 0; i < arrayrow; i++){
                    for (int j = 0; j < cols; j++){
                        Cell cell = sheet.getRow(i).getCell(j);
                        String cellData = cell.getStringCellValue();
                        data[i][j] = cellData;
                    }
                }
                for (int m = 0; m < rows; m++){
                    for (int n = 0; n < cols; n++){
                        myData[m][n] = data[m + 1][n];
                    }
                }
            }
        }
        return myData;
    }
}
