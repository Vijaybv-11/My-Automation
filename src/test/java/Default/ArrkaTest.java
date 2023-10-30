package Default;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Random;

@Slf4j
public class ArrkaTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        String[] domain = {"bestlifep.com", "uapemail.com", "sessionintel.com", "howe-balm.com", "jarumpoker1.com",
                "5kratom.com", "cliol.com", "myhaberdashe.com", "hobbymanagement.com", "obibike.net",
                "rabihtech.xyz", "muzhskaiatema.com", "apluson.xyz", "affogatgaroth.com", "dadosa.xyz",
                "btlatamcolombiasa.com", "namesloz.com", "thumbpaste.com", "medan4d.top", "pahrulirfan.net",
                "garena.biz", "youredoewlive.com", "weinzed.org", "fridaypzy.com", "njhdes.xyz", "traslex.com",
                "vmailrfngon.xyz", "igniter200.com", "germemembranlar.com", "beben.xyz", "10-minute-mail.de",
                "pianoxltd.com", "wen3xt.xyz", "eqsaucege.com", "astraeusairlines.xyz", "cloudbst.com",
                "domiaaan2.online", "herbalsumbersehat.com", "mailant.xyz", "ntadalafil.com", "skillion.org",
                "meleni.xyz", "dwellingmedicine.com", "akanshabhatia.com", "phdsearchandselection.com",
                "rrasianp.com", "petsday.org", "bryanlgx.com", "capzone.io", "ldbassist.com", "comohacer.club",
                "fhvxkg2t.xyz", "anayelizavalacitycouncil.com"};
        Random random = new Random();
        int randomDomain = random.nextInt(domain.length);
        String emailid = "chethan" + "@" + domain[randomDomain];
        String Expected_Url = null;
        String url = "https://generator.email/" + emailid;
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://arrkaplatform.in/arr-test/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn-outline-orange")).click();
        driver.findElement(By.xpath("//strong[.='Sign Up Now!']")).click();
        driver.findElement(By.name("companyname")).sendKeys("TY");
        driver.findElement(By.name("firstname")).sendKeys("Vijay");
        driver.findElement(By.name("lastname")).sendKeys("V");
        driver.findElement(By.name("email")).sendKeys(emailid);
        Select select = new Select(driver.findElement(By.xpath("//select[@name='productid_alt']")));
        select.selectByIndex(2);
        driver.findElement(By.name("tncconfirm")).click();
        driver.findElement(By.name("tncprivacy")).click();
        driver.findElement(By.name("captcha_code")).sendKeys("3455");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(1000);

        Document doc = Jsoup.connect(url).get();
        Thread.sleep(2000);
        Document do2 = Jsoup.connect(url).get();
        Elements emailbody = do2.select(".mess_bodiyy > a:nth-of-type(1)");
        if (!emailbody.isEmpty()) {
            log.info("Entered if Block");
            Element link = emailbody.get(0);
            Expected_Url = link.attr("abs:href");
        }

        driver.get(Expected_Url);


    }
}
