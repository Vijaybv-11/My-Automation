package AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class PressKeys {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Samsung");
        cap.setCapability("appPackage", "com.unify.luluandsky");
        cap.setCapability("appActivity", "com.unify.luluandsky.Splash");
        cap.setCapability("autoGrantPermissions", true);

        cap.setCapability("noReset",false);
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}
