package Excelutilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {
    private static final String FILE_PATH = "C:\\Users\\Vijay\\Downloads\\Fireflink_standard_manualtestcase_template.xlsx";

    @DataProvider(name = "excelData")
    public static Iterator<Object[]> testData() throws IOException {
        List<Object[]> data = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;
        Sheet sheet = null;

        try {
            fis = new FileInputStream(FILE_PATH);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    rowData.add(cell.toString());
                }
                data.add(rowData.toArray());
            }
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        }

        return data.iterator();
    }
}
