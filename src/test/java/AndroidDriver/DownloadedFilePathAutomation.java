package AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DownloadedFilePathAutomation {
    public static void main(String[] args) throws MalformedURLException {
        // Set desired capabilities for the Appium driver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
        // capabilities.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk"); // Replace with your app's APK path
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // Initialize the AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Implicit wait to allow time for elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Perform actions to download a file in your app

        // Now, retrieve the downloaded file's path
        String downloadedFilePath = (String) driver.getSettings().get("Downloads");
        System.out.println("Downloaded file path: " + downloadedFilePath);

        // Close the driver
        driver.quit();
    }
}
