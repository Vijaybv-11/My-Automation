package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class FirefoxMobileEmulationExample {
    public static void main(String[] args) {
        // Set the path to the GeckoDriver executable.

        // Enable mobile emulation in Firefox.
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("moz:firefoxOptions", Map.of("prefs", Map.of("devtools.responsiveUI.currentPreset", "iPhone 6")));

        // Create a new instance of the FirefoxDriver.
        WebDriver driver = new FirefoxDriver(options);

        // Start mobile emulation by setting device metrics.
        DevTools devTools = ((FirefoxDriver) driver).getDevTools();
        devTools.createSession();
      /*  devTools.send(Emulation.setDeviceMetricsOverride(builder()
                .setWidth(375)
                .setHeight(667)
                .setDeviceScaleFactor(2)
                .setMobile(true)
                .build()));*/


        driver.get("https://app.fireflink.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser.
        driver.quit();
    }
}
