package config;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;

/**
 * Class contains CRUD util methods for excel sheets
 */
public class XlsSheetUtil {
    String dataFileDir = AppConstant.APP_PATH+File.separator+"properties"+File.separator+AppConstant.APP_ENV+File.separator;

    public void readExcelSheet(String fileName, String sheetName){
        String dataSheet = dataFileDir+"data"+fileName;

    }

    public void readTestData(){

    }
}
