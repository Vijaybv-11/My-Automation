package TestYantraPE;

import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class OpeninIncognito implements Nlp {

    public static void main(String[] args) throws NlpException {

        OpeninIncognito incognito = new OpeninIncognito();
        incognito.execute(null);
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
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
        } catch (Throwable e) {
            nlpResponseModel.setStatus("FAIL");
            nlpResponseModel.setMessage("Failed to Open");
        }

        return nlpResponseModel;
    }
}


