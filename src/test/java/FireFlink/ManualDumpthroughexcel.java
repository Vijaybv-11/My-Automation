package FireFlink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManualDumpthroughexcel {
    public static String username = "bvvijay1@gmail.com";
    public static String Password = "Vijay@11";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://app.fireflink.com");

        driver.findElement(By.name("emailId")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(Password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);
//wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//a[@title='Manual Dump Testing']"))));
        driver.findElement(By.xpath("//span[text()='Manual Dump Testing']")).click();

        String input = "LOGIN/REGISTER";
        String[] parts = input.split("/");
        if (parts.length == 2) {
            String ModuleName = parts[0];
            String SubModuleName = parts[1];
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[text()='+ Module']")).click();
            driver.findElement(By.name("moduleName")).sendKeys(ModuleName);
            driver.findElement(By.xpath("//button[text()='Create']")).click();


        }
    }
}
