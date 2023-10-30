package TestYantraPE;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import io.github.sukgu.Shadow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("LIC15109_PJT1003_PE_NLP8a2fe18c-a32e-4a55-a289-98070875c495")
public class TestShadow1 implements Nlp {

   /* @InputParams({@InputParam(name="xpath", type = "java.lang.String"),
            @InputParam(name="Input", type = "java.lang.String")})
*/
    @Override
    public List<String> getTestParameters() throws NlpException {
        List<String> params = new ArrayList<>();
        return params;
    }

    @Override
    public StringBuilder getTestCode() throws NlpException {
        StringBuilder sb = new StringBuilder();
        return sb;
    }

    @Override
    public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

        NlpResponseModel nlpResponseModel = new NlpResponseModel();



        try {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://careers.microsoft.com/");
            Thread.sleep(15000);

            Shadow S = new Shadow(driver);
            S.findElementByXPath("//textarea[@id='TextField0']").sendKeys("input");

            nlpResponseModel.setMessage("Successfully Entered the input into Shadow element");
            nlpResponseModel.setStatus(CommonConstants.pass);

        }catch(Throwable e) {
            nlpResponseModel.setStatus(CommonConstants.fail);
            nlpResponseModel.setMessage("Failed to handled Shadow element " + e);
        }

        return nlpResponseModel;
    }


    public static void main(String[] args) throws NlpException, InterruptedException {

        TestShadow1 t = new TestShadow1();
        t.execute(null);

    }




}
