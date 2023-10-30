package TestYantraPE;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location implements Nlp {

    public static void main(String[] args) throws NlpException {

        Location t1 = new Location();
        t1.execute(null);
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
            DesiredCapabilities cap = new DesiredCapabilities();
            Map<String, Object> deviceMetrics = new HashMap<>();
            deviceMetrics.put("width", 1920);
            deviceMetrics.put("height", 1080);
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
            cap.setAcceptInsecureCerts(true);
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            chromeOptions.merge(cap);
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.get("https://wordpress-205471-3653890.cloudwaysapps.com");
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            WebElement ele = driver.findElement(By.xpath("//a[text()='Courses & Certifications'l]"));
            actions.moveToElement(ele).build().perform();
        } catch (Throwable e) {
            nlpResponseModel.setStatus("FAIL");
            nlpResponseModel.setMessage("Failed to Open");
        }

        return nlpResponseModel;
    }
}
