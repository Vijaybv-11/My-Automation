package Default;

public class SplitSpace {

    public static void main(String[] args) {

        String test ="1.Open the browser and navigate to URL\n" +
                " 2.Enter username into username textfield\n" +
                " 3.Enter password into password textfield\n" +
                " 4.click on Login button\n" +
                " 5.User should be able to verify landing page is Home page";

        String expected[] =test.split("\n");
        System.out.println(expected.length);


    }
}
