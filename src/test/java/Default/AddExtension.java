package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtension {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        String loadpath= "C:\\Users\\Vijay\\Downloads\\Dark-Mode";
        options.addArguments("-load-extension="+loadpath);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://careers.microsoft.com/v2/global/en/home.html");
        driver.manage().window().maximize();
        /*Thread.sleep(10000);
        String locatorType="xpath";
        String method ="click";
        Shadow shadow = new Shadow(driver);

        if (method.equalsIgnoreCase("click") && locatorType.equalsIgnoreCase("css")) {
            shadow.findElement("textarea[placeholder='Specific feedback gives better results.']").sendKeys("Vijay");
            System.out.println("Entered using css");

        }
       else if (method.equalsIgnoreCase("click") ) {
            shadow.findElementByXPath("//textarea[@placeholder='Specific feedback gives better results.']").sendKeys("Vijay");
            System.out.println("Entered using Xpath");
        }*/
    }
}
