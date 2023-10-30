package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DebuggerChrome {

    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\chromeData");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.fireflink.com/");
    }
}
