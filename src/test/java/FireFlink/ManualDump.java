package FireFlink;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class ManualDump {
    static String mail = "patientxpress@leadbix.site";


    static String psw = "PatientXpress@123";
    static String PROJECT = "PatientXpress";
    static String SCRIPTNAME = "";
    static String createdBY = "Tejashwini";
    static String ReviwedBy = "Aparna";
    static String POCURL = "NA";

    public static void main(String[] args) throws Exception {
        List lissttt = new ArrayList<>();
        lissttt.add("HO002_Verify user is able to Message");
        lissttt.add("HO003_Verify user is able to know about Online appointment");
        lissttt.add("HO004_Verify user is able to see all the reminders");
       /* lissttt.add("TC098_Check Wether It Keeps The Count Of Questions");
        lissttt.add("TC099_Verify If We Could Ask More Question Than Its Limits");
        lissttt.add("TC101_Verify If User Could Jump To Very First News");
        lissttt.add("TC102_Verify If User Could Jump To Very Last News");*/

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        // option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://app.fireflink.com/");
        WebElement email = driver.findElement(By.xpath("//input[@name='emailId']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement signin = driver.findElement(By.xpath("//button[text()='Sign in']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(mail);
        password.sendKeys(psw);
        signin.click();
        Thread.sleep(2000);

        wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Projects List']"))));
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",
                driver.findElement(By.xpath("//span[text()='" + PROJECT + "']/..")));
        Thread.sleep(5000);

        for (int stipt = 0; stipt < lissttt.size(); stipt++) {
            SCRIPTNAME = lissttt.get(stipt).toString();
            // Login to fireflink


            jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@title='Expand All']")));
            Thread.sleep(5000);
            jse.executeScript("arguments[0].scrollIntoView(true)",
                    driver.findElement(By.xpath("(//span[@title='" + SCRIPTNAME + "'])[1]")));
            Thread.sleep(5000);
            jse.executeScript("arguments[0].click();",
                    driver.findElement(By.xpath("(//span[@title='" + SCRIPTNAME + "'])[1]")));
            Thread.sleep(5000);

            ArrayList grouplist = new ArrayList();

            List<WebElement> groups = driver
                    .findElements(By.xpath("//input[contains(@name,\"root\")]/following-sibling::b"));
            for (WebElement group : groups) {
                grouplist.add(group.getText());
            }

            ArrayList list1 = new ArrayList();

            // if depends on scripts
            if (grouplist.contains("Depends On Scripts")) {
                jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(
                        "//*[text()='Depends On Scripts']/./..//button[@class='cursor-pointer arrow-class ']/img")));
                Thread.sleep(1000);
                jse.executeScript("arguments[0].click();",
                        driver.findElement(By.xpath("//tr[contains(@id,'dependscript')]/td/div/span[text()]")));
                Thread.sleep(5000);
                ArrayList dependList = new ArrayList();
                List<WebElement> dependSteps = driver
                        .findElements(By.xpath("//li[contains(@class,'fontPoppinsRegularMd')]"));
                for (WebElement st : dependSteps) {
                    String s = st.getText();
                    s = s.replace(".", "   ");
                    String[] s1 = s.split("   ");
                    dependList.add(s1[1].trim());
                }
                driver.findElement(By.xpath("//button[text()='Cancel']")).click();
                Thread.sleep(1000);
                list1.addAll(dependList);
            }
            // if precondition
            if (grouplist.contains("Pre Condition")) {
                jse.executeScript("arguments[0].click();", driver.findElement(By
                        .xpath("//*[text()='Pre Condition']/./..//button[@class='cursor-pointer arrow-class ']/img")));
                Thread.sleep(1000);
                jse.executeScript("arguments[0].click();",
                        driver.findElement(By.xpath("//tr[contains(@id,'precondition')]/td/div/span[text()]")));
                Thread.sleep(1000);
                driver.findElement(By.xpath("//span[text()='Steps']/*[@class]")).click();
                Thread.sleep(2000);
                List<WebElement> prestep = driver
                        .findElements(By.xpath("//span//div/div/div[@class]/div[@class and @style]"));
                ArrayList prelist = new ArrayList();
                for (WebElement st : prestep) {
                    String s = st.getText();
                    s = s.replace(".", "   ");
                    String[] s1 = s.split("   ");
                    prelist.add(s1[1].trim());
                }
                driver.findElement(By.xpath("//button[text()='Cancel']")).click();
                Thread.sleep(1000);
                list1.addAll(prelist);
            }
            Thread.sleep(5000);
            driver.findElement(By.xpath("//span[@title='Clear Result']")).click();
            List<WebElement> steps = driver.findElements(By.xpath("//span[@id='step-break']"));
            ArrayList steplist = new ArrayList();
            for (WebElement stps : steps) {
                String st = stps.getText();
                steplist.add(st);
            }
            System.out.println(steplist);

            ArrayList temp = new ArrayList();
            temp = (ArrayList) steplist.clone();
            System.out.println(temp);

            int g = -1;
            Iterator ir = steplist.iterator();
            while (ir.hasNext()) {
                String st2 = ir.next().toString();
                System.out.println(st2);
                String st1 = st2.toLowerCase();
                System.out.println(st1);

                if ((st1.contains("- step group")) && (!st1.contains("wait for page"))
                        && ((st1.contains("navigate")) || ((!st1.contains("open")) && (!st1.contains("browser")))
                        || ((!st1.contains("close")) && (!st1.contains("browser"))))) {
                    System.out.println("sdfghb");
                    g = temp.indexOf(st2);
                    System.out.println(g);
                    String sss = st2.replace("- Step Group", "").trim();
                    System.out.println(sss);
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//span[contains(text(),'" + sss + "')]")).click();
                    // jse.executeScript("arguments[0].click();", stepgroupsss);
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//span[text()='Steps']/*[@class]")).click();

                    ArrayList stepgrouplist = new ArrayList();
                    List<WebElement> stepgroup = driver.findElements(By.xpath("//span//div[@class]/p[@class]"));

                    for (WebElement stp : stepgroup) {
                        String s = stp.getText();
                        s = s.replace(".", "   ");
                        String[] s1 = s.split("   ");
                        stepgrouplist.add(s1[1].trim());

                    }
                    System.out.println(stepgrouplist);

                    driver.findElement(By.xpath("//button[text()='Cancel']")).click();
                    Thread.sleep(1000);

                    temp.remove(g);
                    System.out.println(temp);
                    temp.addAll(g, stepgrouplist);
                    System.out.println(temp);
                }

            }
            System.out.println(steplist);
            list1.addAll(temp);

            if (grouplist.contains("Post Condition")) {
                ArrayList postlist = new ArrayList();
                WebElement post = driver.findElement(By
                        .xpath("//*[text()='Post Condition']/./..//button[@class='cursor-pointer arrow-class ']/img"));
                jse.executeScript("arguments[0].scrollIntoView(true);", post); // element will move top of the screen
                Thread.sleep(1000);
                jse.executeScript("arguments[0].click();", post);
                Thread.sleep(1000);
                String ppp = driver.findElement(By.xpath("//tr[contains(@id,'postcondition')]/td/div/span[text()]"))
                        .getText();
                System.out.println(ppp);
                if (ppp.contains("Close")) {
                    String a = ppp.replace(".", " ").replaceAll("[0-9]", "").trim();
                    System.out.println("Post condi" + a);
                    postlist.add(a);
                } else {
                    jse.executeScript("arguments[0].click();",
                            driver.findElement(By.xpath("//tr[contains(@id,'postcondition')]/td/div/span[text()]")));
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//span[text()='Steps']/*[@class]")).click();
                    Thread.sleep(2000);
                    List<WebElement> poststep = driver
                            .findElements(By.xpath("//span//div/div/div[@class]/div[@class and @style]"));
                    for (WebElement st : poststep) {
                        String s1 = st.getText();
                        s1 = s1.replace(".", "   ");
                        String[] s2 = s1.split("   ");
                        postlist.add(s2[1].trim());
                    }
                    driver.findElement(By.xpath("//button[text()='Cancel']")).click();
                    Thread.sleep(1000);

                }
                list1.addAll(postlist);
            }
            Iterator itr1 = list1.iterator();
            while (itr1.hasNext()) {
                String sss = itr1.next().toString();
                if (sss.contains("Wait") || sss.contains("Switch") || sss.contains("Frame") || sss.contains("Get text")
                        || sss.contains("Generate") || sss.contains("Concatenate") || sss.contains("Start iteration")
                        || sss.contains("End iteration") || sss.contains("Print Value")
                        || sss.contains("Browser window get url") || sss.contains("DesiredCapability")
                        || sss.contains("Start If") || sss.contains("Clear") || sss.contains("SSL")
                        || sss.contains("Execute") || sss.contains("Launch") || sss.contains("Connect")
                        || sss.contains("Verification") || sss.contains("Press") || sss.contains("MOB")
                        || sss.contains("Swipe") || sss.contains("Fetching OTP") || sss.contains("Get ")
                        || sss.contains("Clear notification")) {
                    itr1.remove();
                }
            }
            int l = 0;
            Iterator it1 = list1.iterator();
            while (it1.hasNext()) {
                String ss = it1.next().toString();
                if (ss.contains("using javascript executor")) {
                    list1.set(l, ss.replace("using javascript executor", "").trim());
                }
                if (ss.contains("by JavascriptExecutor")) {
                    list1.set(l, ss.replace("by JavascriptExecutor", "").trim());
                }
                l++;
            }

            Thread.sleep(2000);
            Map<String, String> keyValues = new HashMap<>();

            driver.findElement(By.xpath("//span[text()='Variables']")).click();

            // local variables
            Thread.sleep(5000);
            String locsizee = driver.findElement(By.xpath("//label[text()='Local Variables']/span")).getText();
            System.out.println(locsizee);
            int locsize = Integer.parseInt(locsizee);
            if (locsize > 0) {
                System.out.println(locsize);
                for (int j = 1; j <= locsize; j++) {
                    String kkk = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[1]/span")).getText();
                    System.out.println(kkk);
                    String bvvv = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]/span")).getText();
                    System.out.println(bvvv);
                    keyValues.put(kkk, bvvv);
                }
            }
            System.out.println(keyValues);

            driver.findElement(By.xpath("//span[text()='Open options']/following-sibling::img")).click();
            driver.findElement(By.xpath("//label[text()='Global Variables']")).click();
            Thread.sleep(2000);
            String globsizee = driver.findElement(By.xpath("//label[text()='Global Variables']/span")).getText();
            System.out.println(globsizee);
            int globsize = Integer.parseInt(globsizee);
            if (globsize > 0) {
                System.out.println(globsize);
                for (int j = 1; j <= globsize; j++) {
                    String kkk = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[1]/span")).getText();
                    System.out.println(kkk);
                    String bvvv = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]/span")).getText();
                    System.out.println(bvvv);
                    keyValues.put(kkk, bvvv);
                }

            }
            System.out.println(keyValues);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[text()='Automation Steps']")).click();

            Thread.sleep(7000);
            String button = driver.findElement(By.xpath("//*[contains(text(),'Manual Test Case')]")).getText();
            driver.findElement(By.xpath("//*[contains(text(),'Manual Test Case')]")).click();
            Thread.sleep(1000);
            if (!button.contains("+")) {
                driver.findElement(
                        By.xpath("//button[@type=\"button\"]/span/*[contains(@class,'individual-user-edit')]")).click();
                Thread.sleep(1000);
            }
            Thread.sleep(500);
            String TestCase = driver
                    .findElement(By.xpath("//label[@class='label-overflow testCase fontPoppinsRegularMd']")).getText();
            String RequirementId = TestCase.substring(0, 5);

            List<WebElement> Basic = driver.findElements(By.xpath("//input[@name]"));
            for (WebElement bs : Basic) {
                String required = bs.getAttribute("name");
                System.out.println(required);
                if (required.toLowerCase().contains("requirement id")) {
                    driver.findElement(By.xpath("//input[@name='" + required + "']")).sendKeys(RequirementId);
                    Thread.sleep(500);
                } else if (required.toLowerCase().contains("created by")) {
                    driver.findElement(By.xpath("//input[@name='" + required + "']")).sendKeys(createdBY);
                    Thread.sleep(500);
                } else if (required.toLowerCase().contains("created on")) {
                    driver.findElement(By.xpath("//input[@name='" + required + "']")).click();
                    driver.findElement(By.xpath("//div[contains(@aria-label,'Choose ')][@tabindex='0']")).click();
                    Thread.sleep(500);
                } else if (required.toLowerCase().contains("reviewed by")) {
                    driver.findElement(By.xpath("//input[@name='" + required + "']")).sendKeys(ReviwedBy);
                    Thread.sleep(500);
                } else if (required.toLowerCase().contains("reviewed on")) {
                    driver.findElement(By.xpath("//input[@name='" + required + "']")).click();
                    driver.findElement(By.xpath("//div[contains(@aria-label,'Choose ')][@tabindex='0']")).click();
                    Thread.sleep(500);
                }
            }
            Actions action = new Actions(driver);
            Thread.sleep(2000);
            for (int i = 0; i < list1.size() - 3; i++) {
                // jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//tbody/tr[1]/td[1]/button/*")));
                action.moveToElement(driver.findElement(By.xpath("//tbody/tr[1]/td[1]/button/*"))).click().build()
                        .perform();
                // driver.findElement(By.xpath("//tbody/tr[1]/td[1]/button/*")).click();
                driver.findElement(By.xpath("//span[text()='Insert row below']")).click();
            }

            ArrayList headerNames = new ArrayList();
            List<WebElement> tableHeader = driver
                    .findElements(By.xpath("//table/thead/tr/th[contains(@class,'testStepTable common-label-text')]"));
            for (WebElement tb : tableHeader) {
                headerNames.add(tb.getText().toString().toLowerCase());
            }
            System.out.println(headerNames);

            int Testcaseid = 0;
            int testdescription = 0;
            int testdata = 0;
            int teststep = 0;
            int expectedresult = 0;
            for (int i = 1; i < headerNames.size(); i++) {
                System.out.println(headerNames.get(i).toString() + i);
                if (headerNames.get(i).toString().contains("test case id")) {
                    Testcaseid = i + 2;
                }
                if (headerNames.get(i).toString().contains("test description")) {
                    testdescription = i + 2;
                }
                if (headerNames.get(i).toString().contains("test data")) {
                    testdata = i + 2;
                }
                if (headerNames.get(i).toString().contains("test steps")) {
                    teststep = i + 2;
                }
                if (headerNames.get(i).toString().contains("expected result")) {
                    expectedresult = i + 2;
                }
            }
            System.out.println(Testcaseid);
            System.out.println(testdescription);
            System.out.println(testdata);
            System.out.println(expectedresult);

            Thread.sleep(500);
            String TestDescription = TestCase.substring(6);
            driver.findElement(By.xpath("//tbody//tr[1]/td[contains(@class,'testStepTable')][" + testdescription + "]"))
                    .sendKeys(TestDescription);
            Thread.sleep(500);

            List<WebElement> sis = driver.findElements(By.xpath("//tbody//tr"));
            for (int i = 1; i <= sis.size(); i++) {
                driver.findElement(By.xpath("//tbody//tr[" + i + "]/td[contains(@class,'testStepTable')][2]"))
                        .sendKeys("" + i + "");
                Thread.sleep(100);
            }

            for (int i = 1; i <= sis.size(); i++) {
                driver.findElement(
                                By.xpath("//tbody//tr[" + i + "]/td[contains(@class,'testStepTable')][" + testdata + "]"))
                        .sendKeys("N/A");
                Thread.sleep(100);
            }
            for (int i = 0; i < list1.size(); i++) {

                if (list1.get(i).toString().contains("Open") && list1.get(i).toString().contains("Browser")) {
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + teststep + "]"))
                            .sendKeys("Open Browser Window");
                } else if (list1.get(i).toString().contains("Navigate to URL")) {
                    String ur = list1.get(i).toString();
                    // driver.findElement(By.xpath("//tbody//tr[" + (i + 1) +
                    // "]/td[contains(@class,'testStepTable')][5]")).sendKeys(ur.replace(ur.split("Navigate
                    // to URL")[1].toString().trim() , ""));
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + teststep + "]"))
                            .sendKeys("Navigate to URL");
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + testdata + "]"))
                            .clear();
                    Thread.sleep(100);
                    // driver.findElement(By.xpath("//tbody//tr[" + (i + 1) +
                    // "]/td[contains(@class,'testStepTable')]["+testdata+"]")).sendKeys(""+ur.split("Navigate
                    // to URL")[1].toString().trim()+"");
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + testdata + "]"))
                            .sendKeys(POCURL);

                } else if (list1.get(i).toString().contains("Close") && list1.get(i).toString().contains("Browser")) {
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + teststep + "]"))
                            .sendKeys("Close Browser Window");
                } else if (list1.get(i).toString().contains("Verify if")
                        && list1.get(i).toString().contains("displayed")) {
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + teststep + "]"))
                            .sendKeys("Verify " + list1.get(i).toString().split("Verify if")[1]);
                } else if (list1.get(i).toString().contains("Enter") && list1.get(i).toString().contains("into")) {
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + teststep + "]"))
                            .sendKeys(list1.get(i).toString());
                    String sss = list1.get(i).toString();
                    String ser = sss.substring(0, sss.indexOf("into")).split("Enter")[1].trim();
                    String kkk = keyValues.get(ser);
                    System.out.println(kkk);
                    if (kkk != null) {
                        driver.findElement(By.xpath(
                                        "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + testdata + "]"))
                                .clear();
                        driver.findElement(By.xpath(
                                        "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + testdata + "]"))
                                .sendKeys(kkk);

                    }
                } else {
                    driver.findElement(By.xpath(
                                    "//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')][" + teststep + "]"))
                            .sendKeys(list1.get(i).toString());
                    Thread.sleep(100);
                }
            }
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).toString().contains("Open") && list1.get(i).toString().contains("Browser")) {
                    driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')]["
                            + expectedresult + "]")).sendKeys("Browser Window Should be Opened");
                } else if (list1.get(i).toString().contains("Maximize")
                        && list1.get(i).toString().contains("browser")) {
                    driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')]["
                            + expectedresult + "]")).sendKeys("Browser Window Should be Maximized");
                } else if (list1.get(i).toString().contains("Navigate to URL")) {
                    driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')]["
                            + expectedresult + "]")).sendKeys("User should be able to Navigate to URL");
                } else if (list1.get(i).toString().contains("Close") && list1.get(i).toString().contains("Browser")) {
                    driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')]["
                            + expectedresult + "]")).sendKeys("Browser Window Should be Closed");
                } else if (list1.get(i).toString().contains("Verify if")
                        && list1.get(i).toString().contains("displayed")) {
                    driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')]["
                                    + expectedresult + "]"))
                            .sendKeys((list1.get(i).toString().split("Verify if ")[1]).replace(" is ", " should be "));
                } else if (list1.get(i).toString().contains("Browser window scroll")) {

                    driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')]["
                                    + expectedresult + "]"))
                            .sendKeys("User should be able to scroll browser window "
                                    + list1.get(i).toString().split("Browser window scroll ")[1]);
                } else {

                    driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]/td[contains(@class,'testStepTable')]["
                            + expectedresult + "]")).sendKeys("User should be able to " + list1.get(i).toString());
                    Thread.sleep(100);
                }
            }

            driver.findElement(By.xpath("//button[text()='Save']")).click();
            wait.until(ExpectedConditions
                    .visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'saved successfully')]"))));
            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()='Test Development']")).click();
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
