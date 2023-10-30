package Default;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageHexExtractor2 {
    public static void main(String[] args) {
        try {
            File imageFile = new File("C:\\Users\\Vijay\\Pictures\\Screenshots\\imagecheck.png");
            BufferedImage image = ImageIO.read(imageFile);

            int width = image.getWidth();
            int height = image.getHeight();

            File outputTextFile = new File("pixel_colors2.txt");
            FileWriter fileWriter = new FileWriter(outputTextFile);
            String hexColor = "";
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = image.getRGB(x, y);
                    hexColor = String.format("#%06X", (0xFFFFFF & rgb));
                    String pixelInfo = "Pixel at (" + x + ", " + y + "): " + hexColor + "\n";
                    fileWriter.write(pixelInfo);
                }

            }

            fileWriter.close();
            System.out.println("Pixel colors written to pixel_colors.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
