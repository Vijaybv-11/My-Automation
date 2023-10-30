package QRCODEStuff;

import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QrCodeReader {

    private static int[] getPixels(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);
        return pixels;
    }

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Vijay\\Downloads\\processed-847004d6-b1c5-480e-82fc-52789e83d3f3_Z0MNbYRh.jpeg";

        try {
            File qrCodeImage = new File(filePath);
            BufferedImage bufferedImage = ImageIO.read(qrCodeImage);

            LuminanceSource luminanceSource = new RGBLuminanceSource(bufferedImage.getWidth(), bufferedImage.getHeight(),
                    getPixels(bufferedImage));
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

            MultiFormatReader reader = new MultiFormatReader();

            Result result = reader.decode(binaryBitmap);

            System.out.println("QR Code text: " + result.getText());
        } catch (IOException e) {
            System.err.println("Error reading the QR code image: " + e);
        } catch (NotFoundException e) {
            System.err.println("QR code not found: " + e);
        }
    }


}
