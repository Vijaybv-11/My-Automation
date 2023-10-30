package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class TabSwitchExample {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nonprofit.microsoft.com/en-us/getting-started");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(6000);
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[text()='Submit an inquiry']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Submit an inquiry']")).click();
        Thread.sleep(10000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Page URL: " + driver.getCurrentUrl());
        for (String handle : windowHandles) {
            System.out.println("Page URL: " + driver.getCurrentUrl());
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("contactus")) {

                System.out.println("Page URL: " + driver.getTitle());
                break;
            }
        }

        driver.findElement(By.xpath("//h2[text()='Contact Us']")).isDisplayed();
    }
}
