package Default;

import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadowTsest {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-experimental-web-platform-features");
        options.addArguments("--show-user-agent-shadow-dom");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://nabuqa.z30.web.core.windows.net/#/companies/all");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name=\"seachText\"]")).sendKeys("567df");
        driver.findElement(By.xpath("//input[@name=\"seachText\"]")).click();
        Thread.sleep(6000);
        Shadow shadow = new Shadow(driver);
        shadow.findElement("div[pseudo='-webkit-search-cancel-button']").click();

    }
}
