package OpenCV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ColorNameFinder {
    public static void main(String[] args) {
        String hexCode = "#E74C3C"; // Replace with your hex code

        try {
            String colorName = getColorName(hexCode);
            System.out.println("Color Name: " + colorName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getColorName(String hexCode) throws IOException {
        String url = "https://www.color-name.com/hex/" + hexCode.substring(1);

        Document doc = Jsoup.connect(url).get();
        Elements colorNameElement = doc.select(".color-code");

        if (colorNameElement.size() > 0) {
            Element colorNameHeader = colorNameElement.get(0);
            return colorNameHeader.text();
        }

        return null;
    }
}
