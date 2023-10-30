package Default;

import java.io.IOException;

public class DisableAddress {

    public static void main(String[] args) throws InterruptedException, IOException {
/*

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("test-type");
        options.addArguments("disable-notifications");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        //options.setCapability("autofill.profile_enabled", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://arrkaplatform.in/arr-test/login.php");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Ok']")).click();
        driver.findElement(By.name("email")).sendKeys("hariharan@obibike.net");
        driver.findElement(By.name("password")).sendKeys("Password@123");
        driver.findElement(By.name("captcha_code")).sendKeys("1234");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(50000);
*/

        Thread.sleep(4000);
        Runtime.getRuntime().exec("C:\\Users\\Vijay\\Desktop\\Automation\\Save.exe");

    }
}
