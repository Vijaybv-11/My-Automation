package Windows;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LaunchStandalone {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "Windows PC");
        cap.setCapability("mswait", "15");

        cap.setCapability("app", "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Sophos\\Sophos Connect.lnk");

        WindowsDriver driver = new WindowsDriver(new URL("http://localhost:4723/wd/hub"), cap);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      WebElement isdisplayed= driver.findElement(By.name("Connect"));
        isdisplayed.click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("Disconnect"))));
      Boolean flag=  driver.findElement(By.name("Disconnect")).isDisplayed();
        driver.findElement(By.name("Disconnect")).click();
        System.out.println(flag);



    }
}
