package Default;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCropper {
    public static void main(String[] args) throws IOException {

        String imagePath = "C:\\Users\\Vijay\\Pictures\\Screenshots\\imagecheck.png"; // Replace with the actual image path
        BufferedImage originalImage = ImageIO.read(new File(imagePath));
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int halfHeight = height / 2;
        BufferedImage lowerPart = originalImage.getSubimage(0, halfHeight, width, halfHeight);
        String lowerOutputPath = "C:\\Users\\Vijay\\Pictures\\Screenshots\\final.png";
        ImageIO.write(lowerPart, "png", new File(lowerOutputPath));
        System.out.println("Image divided into upper and lower parts and saved to " + lowerOutputPath);
    }
}
