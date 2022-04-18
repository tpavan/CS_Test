package config;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelParser {
    private String fileName;
    private String testName;
    private String sheetName;

    String dataDir = AppConstant.APP_PATH+File.separator+"properties"+File.separator+"env"+
            File.separator+AppConstant.APP_ENV+File.separator+"data";

    public ExcelParser(String dataFilePath, String testName) throws Exception {
        this.testName = testName;
        this.fileName = dataDir+File.separator+dataFilePath;
        this.sheetName = "";

    }

    public ExcelParser(String dataFilePath, String testName, String sheetName) {
        this.testName = testName;
        this.fileName = dataDir+File.separator+dataFilePath;
        this.sheetName = sheetName;
    }

    private int getLastCol(XSSFSheet sheet, String lastCol) {
        Iterator<?> row = sheet.getRow(0).cellIterator();
        int column = -1;

        while(row.hasNext()) {
            XSSFCell cell = (XSSFCell)row.next();
            if (lastCol.equalsIgnoreCase(cell.toString())) {
                column = cell.getColumnIndex();
            }
        }
        return column;
    }

    public HashMap<String,String> readTestData() {
        ArrayList testData = new ArrayList();
        HashMap<String,String> map = new HashMap<>();
        StringWriter stackTrace;
        try {

            // OPCPackage pkg = OPCPackage.open(this.fileName);
            FileInputStream fileInputStream = new FileInputStream(new File(this.fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            boolean isExecutedTestCase = true;
            XSSFSheet sheet = null;
            Iterator<?> rows = null;
            XSSFRow row = null;
            HashMap<String, String> testDataMap = null;
            XSSFCell cell = null;
            XSSFCell cell1 = null;
            Map<String,Map<String,String>> testDate = new HashMap<>();
            if (this.sheetName == "") {
                sheet = workbook.getSheetAt(1);
            } else {
                sheet = workbook.getSheet(this.sheetName);
            }

            rows = sheet.rowIterator();
            int maxCol = this.getLastCol(sheet, "StatusCode");

            //Itegrate over row
            for(int rw = 0; rows.hasNext(); ++rw){
                row = (XSSFRow)rows.next();
                cell = row.getCell(0);
                String cellFirst = cell.getStringCellValue();
                cell1 = row.getCell(1);
                String cellSecond = cell1.getStringCellValue();
                map.put(cellFirst,cellSecond);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }

    public static void main(String[] args) throws Exception{
        ExcelParser ep = new ExcelParser("C:\\Users\\ptuptewar\\Repo\\WebTAF\\properties\\env\\qa\\data\\Trade_Data.xlsx", "bookTrade","Test_Data");
        /*ArrayList<HashMap<String, String>> testDataSheet =  testDataSheet =*/ ep.readTestData();
    }
}
