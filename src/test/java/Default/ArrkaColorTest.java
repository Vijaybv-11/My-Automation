package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArrkaColorTest {

    public static void main(String[] args) throws Exception {

        //ScreenRecorderUtil.startRecord("main");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://arrkaplatform.in/arr-test/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Ok']")).click();
        driver.findElement(By.name("email")).sendKeys("shashankJo@quertzs.com");
        driver.findElement(By.name("password")).sendKeys("Password@123");
        driver.findElement(By.name("captcha_code")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//a[@data-type='active']")).click();

        //  ScreenRecorderUtil.stopRecord();
       /* Thread.sleep(25000);

       WebElement date = driver.findElement(By.xpath("(//input[@type='date'])[2]"));
        Thread.sleep(2000);


        JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].value='0-08-2023';",date);
*/
       /* WebElement element = driver.findElement(By.xpath("(//button[text()='ok'])[1]"));
       Thread.sleep(6000);
        if (element.isDisplayed()){

            js.executeScript("arguments[0].click();",element);

            Thread.sleep(2000);
        }

        if (driver.findElement(By.xpath("(//button[text()='ok'])[2]")).isDisplayed()){

            js.executeScript("arguments[0].click();",element);
            Thread.sleep(2000);
        }
        if (driver.findElement(By.xpath("(//button[text()='ok'])[1]")).isDisplayed()){

            js.executeScript("arguments[0].click();",element);
            Thread.sleep(2000);
        }*/

       /* driver.findElement(By.xpath("//button[@id='final_submit2']")).click();
        driver.findElement(By.xpath("//button[text()='confirm']")).click();*/


    }

}
