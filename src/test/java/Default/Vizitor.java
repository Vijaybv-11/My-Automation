package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vizitor {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vizitorapp.com/signup/");
        Thread.sleep(3000);

      String ele =  driver.findElement(By.name("adminName")).getAttribute("validationMessage");
        System.out.println("Element Message is ----> "+ele);
    }
}
