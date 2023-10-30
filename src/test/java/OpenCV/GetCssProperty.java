package OpenCV;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCssProperty {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.schemecolor.com");
        Thread.sleep(2000);
        String hexcode = driver.findElement(By.linkText("Pink")).getCssValue("background");
        System.out.println(hexcode);
    }
}