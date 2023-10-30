package FileRelated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class FileUploadThroughAutoit {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        Thread.sleep(1000);
        WebElement ele = driver.findElement(By.name("upfile"));
        Actions actions = new Actions(driver);
        actions.click(ele).build().perform();

        String Autoitpath = "C:\\Users\\Vijay\\Desktop\\Automation\\FileUpload.exe";
        Thread.sleep(1000);
        String uploadFilePath = "C:\\Users\\Vijay\\Pictures\\Turing.aspx";
        String title = "Open";
        ProcessBuilder pb = new ProcessBuilder(Autoitpath,
                uploadFilePath, title);
        pb.start();

    }
}
