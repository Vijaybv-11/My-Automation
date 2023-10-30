package OpenCV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HexColorExtractor {

    public static void main(String[] args) {
        try {
            // Fetch the webpage content using Jsoup
            String url = "https://arrkaplatform.in/arr-test/product_governance.php"; // Replace this with the URL of the webpage you want to inspect
            Document doc = Jsoup.connect(url).get();

            // Find the example element by its ID
            String elementId = "v(//span[text()='Client']/..)[2]"; // Replace this with the ID of the element you want to inspect
            // Elements exampleElement = doc.selectXpath(elementId);

            // Get the background-color property of the example element
            // String backgroundColor = exampleElement.attr("style");

            // Extract the HEX color value from the style attribute
            //String hexColor = extractHexColor(backgroundColor);
            // System.out.println("Background Color (HEX): " + hexColor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String extractHexColor(String style) {
        // Extract the HEX color value from the style attribute (assuming it is in the format "background-color: #XXXXXX;")
        String hexColor = style.replace("background-color:", "").replaceAll("[^#A-Fa-f0-9]", "").trim();
        return hexColor;
    }
}
