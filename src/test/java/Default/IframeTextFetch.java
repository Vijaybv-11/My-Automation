package Default;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class IframeTextFetch {
    public static void main(String[] args) {
        try {


            Document mainPage = Jsoup.connect("https://www.fakemailgenerator.com/inbox/armyspy.com/evid1944/").get();

            Element iframeElement = mainPage.select("iframe").first();


            if (iframeElement != null) {

                String iframeSrc = iframeElement.attr("src");
                Document iframeContent = Jsoup.connect(iframeSrc).get();

                Element targetElement = iframeContent.select("tbody tr td p strong").first();

                if (targetElement != null) {

                    String elementText = targetElement.text();
                    System.out.println("Text from element inside iframe: " + elementText);
                } else {
                    System.out.println("Target element not found inside iframe");
                }
            } else {
                System.out.println("No iframe found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
