package TestYantraPE;


import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;
import java.util.Map;

public class FirefoxMobileEmulationExample implements Nlp {

    // Set the path to the GeckoDriver executable.

    // Enable mobile emulation in Firefox.


    public static void main(String[] args) throws NlpException {
        FirefoxMobileEmulationExample f1 = new FirefoxMobileEmulationExample();
        f1.execute(null);


    }

    @Override
    public StringBuilder getTestCode() throws NlpException {
        return null;
    }

    @Override
    public List<String> getTestParameters() throws NlpException {


        return null;
    }

    @Override
    public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        NlpResponseModel nlpResponseModel = new NlpResponseModel();
        try {
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("moz:firefoxOptions", Map.of("prefs", Map.of("devtools.responsiveUI.currentPreset", "iPhone 6")));
            FirefoxDriver driver = new FirefoxDriver(options);
            DevTools devTools = ((FirefoxDriver) driver).getDevTools();
            devTools.createSession();

            driver.get("https://app.fireflink.com");

            // driver.quit();

        } catch (Throwable e) {
            System.out.println(e);
        }
        return nlpResponseModel;
    }
}
