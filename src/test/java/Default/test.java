package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(2560,1440));
        driver.get("https://kapiva.in/");
        Thread.sleep(20000);
       /* WebElement ele = driver.findElement(By.xpath("//a[contains(@href,'facebook')]//*[name()='use' and contains(@*,'icon')]"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ele);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click;",ele);*/
        // ele.click();

    }
}
