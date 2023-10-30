package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetValidation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://arrkaplatform.in/arr-test/");
        Thread.sleep(2000);
        driver.findElement(By.name("button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Thread.sleep(2000);
        String mssg = driver.findElement(By.name("email")).getAttribute("validationMessage");
        System.out.println(mssg);
    }

}
