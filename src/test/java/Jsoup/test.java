package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
    public static void main(String[] args) {

        //https://generator.email/femme-cougar.club/levongroup/9fb75896ed0183a2f706b707f2f76f12
        String url = "https://generator.email/aparnaun@vtqreplaced.com"; // Remove the "#" symbol

        int a =10;
        int A =10;
        try {
            Document doc = Jsoup.connect(url).get();
            Thread.sleep(2000);
            Elements verificationurl = doc.select("h2[style='text-align: center']");
            Element Header = verificationurl.get(0);
            String Exact_link = Header.text();
            System.out.println("Exact link ---> " + Exact_link);


        } catch (Throwable e) {

            e.printStackTrace();
        }
    }
}
