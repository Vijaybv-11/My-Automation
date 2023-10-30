package Default;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHexExtractor {
    public static void main(String[] args) {

        try {
            File imageFile = new File("C:\\Users\\Vijay\\AppData\\Local\\Temp\\screenshot100004461539183977.png");
            BufferedImage image = ImageIO.read(imageFile);
            Thread.sleep(3000);
            int height = image.getHeight();
            int width = image.getWidth();
            String hexColor = "";
            String hexcode = "";
            StringBuilder hexCodeBuilder = new StringBuilder();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = image.getRGB(x, y);
                    hexColor = String.format("#%06X", (0xFFFFFF & rgb));
                    hexCodeBuilder.append(hexColor);

                }
            }
            hexcode = hexCodeBuilder.toString();
            if (hexcode.contains("#00A23B")) {
                System.out.println("Color is Green ");
            } else if (hexcode.contains("#FBB02E")) {

                System.out.println("Orange Color");
            } else {
                System.out.println("Fail");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
