package WindowSwitch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchTab {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/windows");

        driver.findElement(By.linkText("Click Here")).click();
        Set<String> window = driver.getWindowHandles();

        Iterator<String> iterator = window.iterator();
        String first = iterator.next();
        String second = iterator.next();

        driver.switchTo().window(second);
        driver.getCurrentUrl();

        driver.quit();
    }
}
