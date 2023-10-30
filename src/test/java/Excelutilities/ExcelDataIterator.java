package Excelutilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataIterator {
    private static final String FILE_PATH = "C:\\Users\\Vijay\\Downloads\\TestMotilal.xlsx";

    public static void main(String[] args) {
        FileInputStream fis = null;
        Workbook workbook = null;
        Sheet sheet = null;

        try {
            fis = new FileInputStream(FILE_PATH);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                String TestCaseName
                        = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String RequirementID
                        = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Type
                        = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Module_Path = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Description
                        = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Severity
                        = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Priority
                        = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Status = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Pre_Conditions
                        = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String TestSteps
                        = row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Input
                        = row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Expected_Result

                        = row.getCell(10, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Actual_Result

                        = row.getCell(12, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                String Status2
                        = row.getCell(13, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();


                System.out.println("Row " + row.getRowNum() + ":");
                System.out.println("Column 1: " + TestCaseName);
                System.out.println("Column 2: " + RequirementID);
                System.out.println("Column 3: " + Type);
                System.out.println("Column 1: " + Module_Path);
                System.out.println("Column 2: " + Description);
                System.out.println("Column 3: " + Severity);
                System.out.println("Column 1: " + Priority);
                System.out.println("Column 2: " + Status);
                System.out.println("Column 3: " + Pre_Conditions);
                System.out.println("Column 1: " + TestSteps);
                System.out.println("Column 2: " + Input);
                System.out.println("Column 3: " + Expected_Result);
                System.out.println("Column 2: " + Actual_Result);
                System.out.println("Column 3: " + Status2);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
