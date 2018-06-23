package stepDefinition;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

public class TestFile {
    private String filePath;
    private File o_fileXLSX;

    TestFile() {
        this(System.getProperty("user.dir") + "/src/main/resources/test1.xlsx");
    }

    TestFile(String filePath) {
        this.filePath = filePath;
        o_fileXLSX = new File(filePath);
    }

    public HashMap<String, String> fileReadXLSX() {
        //переменная с типом коллекции HashMap
        HashMap params = new HashMap<String, String>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(o_fileXLSX));
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                XSSFRow row = sheet.getRow(i);
                params.put(row.getCell(1).toString(), row.getCell(2).toString());
            }
            workbook.close();
        } catch (Exception e) {
            System.out.println("TestFileReadXLS: ошибка! " + e.getMessage());
        }

        return params;
    }
}
