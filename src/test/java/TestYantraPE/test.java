package TestYantraPE;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test implements Nlp {

    public static void main(String[] args) throws NlpException {

        test location1 = new test();
        location1.execute(null);
    }

    @Override
    public List<String> getTestParameters() throws NlpException {
        return null;
    }

    @Override
    public StringBuilder getTestCode() throws NlpException {
        return null;
    }

    @Override
    public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        NlpResponseModel nlpResponseModel = new NlpResponseModel();
        try {
            Map<String, Object> deviceMetrics = new HashMap<>();
            deviceMetrics.put("width", 1050);
            deviceMetrics.put("height", 700);
            deviceMetrics.put("pixelRatio", 3.0);
            Map<String, Object> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceMetrics", deviceMetrics);
            mobileEmulation.put("userAgent",
                    "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
            Map<String, Object> clientHints = new HashMap<>();
            clientHints.put("platform", "Android");
            clientHints.put("mobile", true);
            mobileEmulation.put("clientHints", clientHints);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setAcceptInsecureCerts(true);
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            driver.get("https://wordpress-205471-3653890.cloudwaysapps.com/");
            System.out.println("SIZESSSS" + driver.manage().window().getSize());
            WebElement element = driver.findElement(By.xpath("//a[@aria-label='whatsapp']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(3000);
            js.executeScript("arguments[0].scrollIntoView(true)", element);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//iframe[@src='about:blank']"))));
            WebElement frame = driver.findElement(By.xpath("//iframe[@src=\"about:blank\"]"));
            int whatsapp_x = element.getLocation().getX();
            int whatsapp_y = element.getLocation().getY();
            int frameX = frame.getLocation().getX();
            int framey = frame.getLocation().getY();
            System.out.println("X coordinate is ---> " + whatsapp_x);
            if (whatsapp_x != frameX && whatsapp_y != framey) {
                System.out.println("Element is not Overlapped");
            } else {

                System.out.println("Element is overlapped");
            }


        } catch (Throwable e) {
            nlpResponseModel.setStatus("FAIL");
            nlpResponseModel.setMessage("Failed to Open");
        }

        return nlpResponseModel;
    }
}
