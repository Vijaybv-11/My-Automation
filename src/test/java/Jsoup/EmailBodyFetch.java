package Jsoup;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@Slf4j
public class EmailBodyFetch {
    public static void main(String[] args) {

        String emailid = "/inbox/cuvox.de/lonsind1969"; // Replace with your hex code

        try {
            String emailId = getColorName(emailid);
            System.out.println("Email Link: " + emailId);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getColorName(String emailid) throws IOException, InterruptedException {
        String url = "https://generator.email/magoo6@monsterhom.com"; // Remove the "#" symbol

        Document doc = Jsoup.connect(url).get();
        Thread.sleep(2000);
        Elements verificationurl = doc.select("td[valign='top'] h2");
        Element Header = verificationurl.get(0);
        return Header.text();

    }
}
