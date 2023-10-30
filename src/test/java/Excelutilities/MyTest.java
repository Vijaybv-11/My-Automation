package Excelutilities;

import org.testng.annotations.Test;

public class MyTest {
    @Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
    public void myTestMethod(String TestCaseName, String RequirementID, String Type, String Module_Path, String Description, String Severity, String Priority, String Status, String Pre_Conditions, String TestSteps, String Input, String Expected_Result, String Actual_Result, String Status2) {
        // Use the column values (col1, col2, col3) in your test logic
        System.out.println("Column 1: " + TestCaseName);
        System.out.println("Column 2: " + RequirementID);
        System.out.println("Column 3: " + Type);
        System.out.println("Column 4: " + Module_Path);
        System.out.println("Column 5: " + Description);
        System.out.println("Column 6: " + Severity);
        System.out.println("Column 7: " + Priority);
        System.out.println("Column 8: " + Status);
        System.out.println("Column 9: " + Pre_Conditions);
        System.out.println("Column 10: " + TestSteps);
        System.out.println("Column 11: " + Input);
        System.out.println("Column 12: " + Expected_Result);
        System.out.println("Column 13: " + Actual_Result);
        System.out.println("Column 14: " + Status2);

    }
}

