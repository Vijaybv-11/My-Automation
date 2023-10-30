package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BrowserWindowSwitching {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wordpress-205471-3653890.cloudwaysapps.com/microsoft-azure-syllabus/");
        WebElement ele = driver.findElement(By.xpath("//a[contains(@href,'http')][not(contains(@href,'https://wordpress'))]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
        String[] titles = {"Aimore Technologies | Facebook", "AIMORE TECHNOLOGIES (@aimoretechnologies) • Instagram photos and videos", "Log in to Twitter / X", "Security Verification | LinkedIn", "aimore technologies - YouTube", "Share on WhatsApp"};

        List<WebElement> thirdpartlinks = driver.findElements(By.xpath("//a[contains(@href,'http')][not(contains(@href,'https://wordpress'))]"));

        for (WebElement webElement : thirdpartlinks) {
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", webElement);

            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> windowIterator = windowHandles.iterator();
            String firstWindowHandle = windowIterator.next();
            String secondWindowHandle = windowIterator.next();

            driver.switchTo().window(secondWindowHandle);
            Thread.sleep(5000);
            String title = driver.getTitle();
            System.out.println("Title of the page is " + title);
            driver.close();
            for (String s : titles) {
                if (s.contains(title)) {
                    System.out.println("Title is Matched " + s);

                }
            }
            driver.switchTo().window(firstWindowHandle);

        }
    }


}
