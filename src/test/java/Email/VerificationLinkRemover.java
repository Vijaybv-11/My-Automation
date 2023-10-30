package Email;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VerificationLinkRemover {
    public static void main(String[] args) {
        // Replace with the actual URL of the web page where you receive the verification link.
        String url = "https://generator.email/levongroup@femme-cougar.club";

        try {
            Document document = Jsoup.connect(url).get();


            String verificationLinkText = "Forgot Password";


            Elements linkElements = document.selectXpath("//div[text()='Forgot Password']");

            if (!linkElements.isEmpty()) {
                Element verificationLink = linkElements.first();
                verificationLink.remove();


                System.out.println("Verification link removed.");
            } else {
                System.out.println("Verification link not found on the page.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
