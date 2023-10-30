package FileRelated;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FileUploadExample {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload"); // Replace with your target website URL
        Thread.sleep(5000);
        // Find the file input element
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']")); // Replace with your file input locator


        String filePath = "C:\\Users\\Vijay\\Downloads\\qr_code_barcode.jpg"; // Replace with the path to your file
        setFileInputValue(driver, fileInput, filePath);


    }

    private static void setFileInputValue(WebDriver driver, WebElement fileInput, String filePath) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.display = 'block';", fileInput);
        fileInput.sendKeys(filePath);

    }
}

