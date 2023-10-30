package AndroidDriver;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeekBar {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
        //capabilities.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        WebElement seekbar = driver.findElement(By.className("android.widget.SeekBar"));
        int x = seekbar.getLocation().getX();
        int y = seekbar.getLocation().getY();
        Actions actions = new Actions(driver);
        TouchAction touchAction = new AndroidTouchAction(driver);
        WebElement Text = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='io.appium.android.apis:id/progress']"));
        for (int i = x; i <= 100; i++) {
            touchAction.press(PointOption.point(i, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(100, y)).perform();

            System.out.println("TimeLine of the Video is ------>" + Text.getText());
        }
    }
}