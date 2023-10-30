package AndroidDriver;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BatteryInfo {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Samsung");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
        AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
        System.out.println("Battery Information : " + batteryInfo);
        System.out.println("Battery level : " + (batteryInfo.getLevel()) * 100);
        System.out.println("Battery State : " + batteryInfo.getState());

        driver.longPressKey(new KeyEvent(AndroidKey.HOME));


    }
}
