package Default;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelColor {
    public static void main(String[] args) throws IOException {

        int xCoordinate = 507;
        int yCoordinate = 1170;

        File screenshotFile = new File("C:\\Users\\Vijay\\Pictures\\Screenshots\\imagecheck.png");
        BufferedImage screenshotImage = ImageIO.read(screenshotFile);


        Color pixelColor = new Color(screenshotImage.getRGB(xCoordinate, yCoordinate));

        // Convert pixel color to hex code
        String hexColor = String.format("#%02X%02X%02X", pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue());

        System.out.println("Hex color at (" + xCoordinate + ", " + yCoordinate + "): " + hexColor);

    }
}
