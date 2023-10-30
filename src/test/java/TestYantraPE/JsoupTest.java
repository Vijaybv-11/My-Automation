package TestYantraPE;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.HttpURLConnection;
import java.util.List;

public class JsoupTest implements Nlp {
    public static void main(String[] args) throws NlpException {

        JsoupTest jt = new JsoupTest();
        jt.execute(null);
    }

    @Override
    public List<String> getTestParameters() throws NlpException {
        return null;
    }

    @Override
    public StringBuilder getTestCode() throws NlpException {
        return null;
    }

    @Override
    public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        NlpResponseModel nlpResponseModel = new NlpResponseModel();
        try {

            Connection connection = Jsoup.connect("https://www.fakemailgenerator.com/inbox/armyspy.com/evid1944");

            //  Document mainPage = Jsoup.connect("https://www.fakemailgenerator.com/inbox/armyspy.com/evid1944/").get();
            Document mainPage = connection.get();
            Element iframeElement = mainPage.select("iframe").first();
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection.response().url().openConnection();

            if (iframeElement != null) {

                String iframeSrc = iframeElement.attr("src");
                httpURLConnection.disconnect();
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
        } catch (Throwable e) {
            System.out.println("Exception is " + e);
            nlpResponseModel.setStatus("FAIL");
            nlpResponseModel.setMessage("Failed to Verify Jsoup" + e);
        }
        return nlpResponseModel;
    }

}
