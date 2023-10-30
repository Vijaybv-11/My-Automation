package FireFlink;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelManualDump {

    public WebDriver driver;
    public Actions actions;
    public String UserName = "bvvijay1@gmail.com";
    public String password = "Vijay@11";
    public String projectName = "Manual Dump Testing";
    public String testURL = "https://app.fireflink.com/signin";
    String ModuleName = "Login/Register";
    String[] arr = ModuleName.split("/");
    Boolean moduleExists = true;
    String ModuleBeforeLastModule;
    String LastModule;

    String Status="Not Executed";

    @Test
    public void manualTest() throws InterruptedException, MalformedURLException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            actions = new Actions(driver);
            driver.manage().window().maximize();
            driver.get(testURL);
            driver.findElement(By.name("emailId")).sendKeys(UserName);
            driver.findElement(By.name("password")).sendKeys(password, Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='All Projects']")).click();
            driver.findElement(By.xpath("//span[text()='" + projectName + "']")).click();
            Thread.sleep(2000);
            moduleExists = driver.findElement(By.xpath("//span[text()='" + arr[0] + "']")).isDisplayed();
            driver.findElement(By.xpath("//span[text()='" + arr[0] + "']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@title='Hide all scripts']")).click();
            driver.findElement(By.xpath("//button[@title='Expand All']")).click();
        } catch (NoSuchElementException first) {
            driver.findElement(By.xpath("//button[text()='+ Module']")).click();
            driver.findElement(By.id("moduleName")).sendKeys(arr[0]);
            try {
                // root Module Creation
                if (driver.findElement(By.xpath("//button[normalize-space()='Choose Module']")).isDisplayed()) {
                    driver.findElement(By.xpath("//button[normalize-space()='Choose Module']")).click();
                    driver.findElement(By.xpath("(//span[text()='Root Module']/../..//input)[2]")).click();
                    driver.findElement(By.xpath("//button[text()='Select']")).click();
                    Thread.sleep(4000);
                    driver.findElement(By.xpath("//button[text()='Create']")).click();
                    //js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[text()='Create']")));
                }
            } catch (NoSuchElementException second) {
                driver.findElement(By.xpath("//button[text()='Create']")).click();
            }
            try {
                driver.findElement(By.xpath("//span[text()='" + arr[0] + "']")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//button[@title='Hide all scripts']")).click();
                driver.findElement(By.xpath("//button[@title='Expand All']")).click();
                LastModule=arr[arr.length-1];
                //Check for Duplicates
                if (arr.length==2) {
                     ModuleBeforeLastModule = arr[arr.length - 2];

                }
                else {
                    ModuleBeforeLastModule =arr[arr.length-1];
                }
                Thread.sleep(5000);
                if (moduleExists == true) {
                    List<WebElement> listOfModules = driver.findElements(By.xpath("//div[@class=\"table-tree-wrp table-height overflow-auto overflow-x-hidden\"]//span[@class=\"fancytree-title \"]"));
                    List<String> matchedModules = new ArrayList<>();
                    for (int i = 1; i < arr.length; i++) {
                        for (int j = 0; j < listOfModules.size(); j++) {

                            System.out.println("given module value " + arr[i]);
                            System.out.println("ui module value " + listOfModules.get(j).getText());
                            if (arr[i].equals(listOfModules.get(j).getText())) {
                                matchedModules.add(arr[i]);
                                listOfModules.remove(j);

                                actions.moveToElement(driver.findElement(By.xpath("//span[text()='" + LastModule + "']"))).build().perform();
                                driver.findElement(By.xpath("//span[text()='" +LastModule+ "']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//button[text()='Add Manual Test Case']")).click();
                                driver.findElement(By.id("scriptName")).sendKeys("TC001");
                                driver.findElement(By.xpath("//div[text()='Select script type']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//li[text()='Web']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//button[text()='Create']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.id("Requirement Id")).sendKeys("requirementId");
                                driver.findElement(By.id("Status")).click();
                                Thread.sleep(200);
                                driver.findElement(By.xpath("//li[text()='"+Status+"']")).click();

                                // Add TestCase to Template
                                driver.findElement(By.xpath("//tbody/tr/td[2]")).sendKeys("1");  //Sl no
                                driver.findElement(By.xpath("//tbody/tr/td[3]")).sendKeys("Test Description");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[4]")).sendKeys("Priority");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[5]")).sendKeys("Severity");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[6]")).sendKeys("Pre-Conditions");  //Add Test Description
                                //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[8]")).sendKeys("Username");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[9]")).sendKeys("NA");  //Add Test Description
                                List<WebElement> testSteps = driver.findElements(By.xpath("//tbody/tr/td[7]"));
                                for (WebElement steps: testSteps
                                ) {
                                    steps.sendKeys("Hello");
                                }

                                driver.findElement(By.xpath("//button[text()='Save']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//span[text()='Test Development']")).click();


                            } else {
                                //add Module and Create a Test Case
                                actions.moveToElement(driver.findElement(By.xpath("//span[text()='" + ModuleBeforeLastModule + "']"))).build().perform();
                                driver.findElement(By.xpath("//span[text()='"+ModuleBeforeLastModule+"']/..//button[@title='Add']")).click();
                                driver.findElement(By.xpath("//button[text()='Add Module']")).click();
                                Thread.sleep(1000);
                                driver.findElement(By.name("moduleName")).sendKeys(LastModule);
                                Thread.sleep(1000);

                                driver.findElement(By.xpath("//button[text()='Create']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//button[@title='Hide all scripts']")).click();
                                Thread.sleep(1000);
                                driver.findElement(By.xpath("//button[@title='Expand All']")).click();
                                Thread.sleep(1000);
                                actions.moveToElement(driver.findElement(By.xpath("//span[text()='" + LastModule + "']"))).build().perform();
                                driver.findElement(By.xpath("//span[text()='"+LastModule+"']/..//button[@title='Add']")).click();
                                Thread.sleep(1000);
                                driver.findElement(By.xpath("//button[text()='Add Manual Test Case']")).click();
                                Thread.sleep(1000);
                                driver.findElement(By.id("scriptName")).sendKeys("TC002");
                                driver.findElement(By.xpath("//div[text()='Select script type']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//li[text()='Web']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//button[text()='Create']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.id("Requirement Id")).sendKeys("requirementId");
                                driver.findElement(By.id("Status")).click();
                                Thread.sleep(200);
                                driver.findElement(By.xpath("//li[text()='"+Status+"']")).click();

                               // Add TestCase to Template
                                driver.findElement(By.xpath("(//TABLE/THEAD/TR/TH[normalize-space(.)='SLNo']/../../.././descendant::td[contains(.,'')])[2]")).sendKeys("1");  //Sl no
                                driver.findElement(By.xpath("//tbody/tr/td[3]")).sendKeys("Test Description");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[4]")).sendKeys("Priority");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[5]")).sendKeys("Severity");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[6]")).sendKeys("Pre-Conditions");  //Add Test Description
                                 //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[8]")).sendKeys("Username");  //Add Test Description
                                driver.findElement(By.xpath("//tbody/tr/td[9]")).sendKeys("NA");  //Add Test Description
                                List<WebElement> testSteps = driver.findElements(By.xpath("//tbody/tr/td[7]"));
                                for (WebElement steps: testSteps
                                     ) {
                                    steps.sendKeys("Hello");
                                }

                                driver.findElement(By.xpath("//button[text()='Save']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//span[text()='Test Development']")).click();



                            }
                        }
                    }
                }


            }catch (Exception last) {
last.printStackTrace();
            }

        }
    }
}
