package Excelutilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataFetcherusingColumnHeader {
    public static void main(String[] args) {
        String columnHeader = "Test Steps";
        String sheetName = "TestCases";
        int rowIndex = 1;
        try {
            FileInputStream fis = new FileInputStream(new File("C:\\Users\\Vijay\\Downloads\\Fireflink_standard_manualtestcase_template.xlsx"));
            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet(sheetName);

            int columnIndex = -1;
            Row headerRow = sheet.getRow(0);
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                if (cell != null && cell.getStringCellValue().equals(columnHeader)) {
                    columnIndex = i;
                    break;
                }
            }

            Row dataRow = sheet.getRow(rowIndex);
            if (dataRow != null && columnIndex >= 0) {
                Cell cell = dataRow.getCell(columnIndex);
                if (cell != null) {
                    // Print the cell value
                    System.out.println("Value at Row " + rowIndex + ", Column " + columnHeader + ": " + cell.toString());
                } else {
                    System.out.println("Cell is empty.");
                }
            } else {
                System.out.println("Row or column not found.");
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
