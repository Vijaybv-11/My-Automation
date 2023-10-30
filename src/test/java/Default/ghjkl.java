package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ghjkl {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://brainberg.in/");

        WebElement test = driver.findElement(By.xpath("//button[@class='close autoModalClose']"));
        System.out.println("Before the Element " + test.isDisplayed());
        Thread.sleep(10000);
        test.click();
        System.out.println("After the Element " + test.isDisplayed());


    }
}
