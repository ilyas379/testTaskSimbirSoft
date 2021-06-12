import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadXls {
    public Object[][] readExcel() throws IOException{
        FileInputStream fis = new FileInputStream("src\\main\\resources\\users.xls");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("login");
        int totalRows = sheet.getLastRowNum()-1;
        int totalColums = sheet.getRow(0).getPhysicalNumberOfCells();

        Object obj[][] = new Object[totalRows][totalColums];
        for(int i = 0; i < totalRows; i++){
            obj[i][0] = sheet.getRow(i+1).getCell(0).toString();
            obj[i][1] = sheet.getRow(i+1).getCell(1).toString();
        }
        return obj;
    }

    @DataProvider(name = "dataProvider4Users")
    public Object[][] excelData() throws IOException{
        return new ReadXls().readExcel();
    }
}
