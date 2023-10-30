package AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SimCardNumberTest {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
        //caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
       // caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "");
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

        String simCardNumber = getSimCardNumber(driver);

        System.out.println("SIM Card Number: " + simCardNumber);

        driver.quit();
    }

    private static String getSimCardNumber(AndroidDriver driver) {
        try {
            Object telephonyManager = driver.executeScript("return context.getSystemService('phone')");
            if (telephonyManager != null) {
                Object simNumber = telephonyManager.getClass().getMethod("getLine1Number").invoke(telephonyManager);
                if (simNumber != null) {
                    return simNumber.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SIM Card Number not found";
    }
}
