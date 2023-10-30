package Tesseract;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract1;

import java.io.File;

public class GetTextFromImage {

    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\Vijay\\Downloads\\pdf.png";
        // String actest="CHAPTER: NUTRITION IN ANIMALS";
        ITesseract image = new Tesseract1();
        image.setDatapath("C:\\tessdata");
        //image.setTessVariable("user_defined_dpi", "100");
        String str = image.doOCR(new File(path));
        Thread.sleep(1000);
        //System.out.println(" Image OCR done ");
        System.out.println(str);

    }
}
