package QRCODEStuff;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QrCodeGenerator {

    public static void main(String[] args) {

        String text = "upi://pay?pa=paytmqr28100505010117577jv9gh6u@paytm&pn=Paytm%20Merchant&paytmqr=28100505010117577JV9GH6U";
        int width = 500;
        int height = 500;
        String format = "png";
        String filePath = "C:\\Users\\Vijay\\Downloads\\QR Codes to Test\\NewQr.png";

        try {
            // Set QR code parameters
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, getEncodeHints());

            // Create QR code image
            BufferedImage qrCodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgbColor = bitMatrix.get(x, y) ?0x62E308 :  0x000000; // black and white colors
                    qrCodeImage.setRGB(x, y, rgbColor);
                }
            }

            // Save QR code image to a file
            File outputFile = new File(filePath);
            ImageIO.write(qrCodeImage, format, outputFile);

            System.out.println("QR code image created successfully.");
        } catch (WriterException e) {
            System.err.println("Error generating QR code: " + e);
        } catch (IOException e) {
            System.err.println("Error saving QR code image: " + e);
        }
    }

    private static java.util.Map<EncodeHintType, Object> getEncodeHints() {
        java.util.Map<EncodeHintType, Object> hints = new java.util.HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        return hints;
    }

}
