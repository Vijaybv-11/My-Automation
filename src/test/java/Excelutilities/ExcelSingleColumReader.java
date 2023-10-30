package Excelutilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelSingleColumReader {
    public static void main(String[] args) {
        try {

            FileInputStream excelFile = new FileInputStream("C:\\Users\\Vijay\\Downloads\\VizitorData.xlsx");

            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheet("Employee Details");
            List<String> columnData = new ArrayList<>();
            for (Row row : sheet) {
                // Assuming the data is in the first column (column index 0)
                Cell cell = row.getCell(5);

                // Check if the cell is not empty and add its value to the list
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String cellValue = cell.getStringCellValue();
                    columnData.add(cellValue);
                }
            }

            // Close the workbook and input stream
            workbook.close();
            excelFile.close();

            // Display the list of column data
            for (String data : columnData) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
