package TestYantraPE;


import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks implements Nlp {

    public static void main(String[] args) throws NlpException {

        BrokenLinks Bl = new BrokenLinks();
        Bl.execute(null);
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
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            nlpResponseModel.setWebDriver(driver);
            driver.get("https://wordpress-205471-3653890.cloudwaysapps.com/");
            List<WebElement> links = driver.findElements(By.tagName("a"));
            int broken_links_count = 0;
            int workinglinks = 0;
            for (WebElement link : links) {
                String url = link.getAttribute("href");

                try {
                    URL check_url = new URL(url);
                    HttpURLConnection connect = (HttpURLConnection) check_url.openConnection();
                    connect.setRequestMethod("HEAD");
                    connect.connect();
                    int responsecode = connect.getResponseCode();
                    if (responsecode == 302) {
                        System.out.println("Broken Links are ----> " + url);
                        broken_links_count++;
                    } else {
                        System.out.println("Working Links are -----> " + url);
                        workinglinks++;
                    }
                } catch (MalformedURLException e) {
                    nlpResponseModel.setStatus("FAIL");
                    nlpResponseModel.setMessage("Failed to Verify Broken Links");
                }
            }
            System.out.println("Working link Count ----->" + workinglinks);
            System.out.println("Broken link count ------>" + broken_links_count);

        } catch (Throwable e) {
            nlpResponseModel.setStatus("FAIL");
            nlpResponseModel.setMessage("Failed to Verify Broken Links" + e);
        }
        return nlpResponseModel;
    }
}
