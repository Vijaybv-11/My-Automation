package Excelutilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelData {

    public static void main(String[] args) {

        try {
            String filePath = "C:\\Users\\Vijay\\Downloads\\LiquiLoans Data.xlsx";
            FileInputStream stream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(stream);
            Sheet sheet = workbook.getSheet("Borrower Registration");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

            stream.close();
            workbook.close();

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
