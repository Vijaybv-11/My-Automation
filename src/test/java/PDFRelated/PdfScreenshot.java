package PDFRelated;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfScreenshot {

    public static void main(String[] args) {
        String pdfFilePath = "C:\\Users\\Vijay\\Downloads\\ExecutionReport_EXEC1681.pdf";
        int pageNumber = 1;
        String outputImagePath = "C:\\Users\\Vijay\\Pictures\\Screenshots\\screenshot.png";
        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage image = pdfRenderer.renderImageWithDPI(pageNumber, 300);
            ImageIO.write(image, "png", new File(outputImagePath));
            System.out.println("Screenshot saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
