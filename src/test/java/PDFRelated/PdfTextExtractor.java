package PDFRelated;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

@Slf4j
public class PdfTextExtractor {

    public static void main(String[] args) {
        String pdfFilePath = "C:\\Users\\Vijay\\Downloads\\pdf_1691647050227.pdf"; // Replace with the actual path to your PDF file

        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            if (!document.isEncrypted()) {
                PDFTextStripper textStripper = new PDFTextStripper();
                String pdfText = textStripper.getText(document);
                System.out.println(pdfText);
            } else {
                System.err.println("Cannot process encrypted PDFs.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
