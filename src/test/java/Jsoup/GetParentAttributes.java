package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetParentAttributes {

    public static void main(String[] args) {


        String url = "https://generator.email/levongroup@femme-cougar.club";
        String text = "Verification Email";
        String link = null;
        String exact_link;

        try {
            Document document = Jsoup.connect(url).get();
            Elements linkElements = document.getElementsMatchingText(text);
            for (Element element : linkElements) {
                if (element.text().equals(text)) {
                    Element parentElement = element.parent();
                    link = parentElement.attr("href");
                    System.out.println("Link of the tab is -----> " + link);

                }
            }
            Document document_two = Jsoup.connect(url + link).get();
            Elements activation_link = document_two.select("a[class='btn']");
            Element verify = activation_link.first();
            exact_link = verify.attr("href");

            System.out.println("Exact link  of the tab is -----> " + exact_link);


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
