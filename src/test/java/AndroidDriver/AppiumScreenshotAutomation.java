package AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AppiumScreenshotAutomation {
    public static void main(String[] args) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
        //capabilities.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        // Identify the location using UI element locators
        WebElement locationElement = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.mosl.thunder.uat:id/imageView']"));

        // Capture the whole screen
        File screenshotFile = driver.getScreenshotAs(OutputType.FILE);

        // Crop the screenshot to the desired location
        BufferedImage fullImage = ImageIO.read(screenshotFile);
        Rectangle locationRect = locationElement.getRect();
        BufferedImage locationScreenshot = fullImage.getSubimage(locationRect.getX(), locationRect.getY(), locationRect.getWidth(), locationRect.getHeight());

        // Save the cropped screenshot
        File outputLocation = new File("C:\\Users\\Vijay\\Pictures\\Screenshots\\imagecheck.png");
        ImageIO.write(locationScreenshot, "png", outputLocation);

        driver.quit();
    }
}
