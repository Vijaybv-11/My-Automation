package ApacheStringClass;

import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.assertEquals;

public class AppendingandPrepending {
    public static void main(String[] args) {

        String string = "baeldung";
        String stringWithSuffix = StringUtils.appendIfMissing(string, ".com");
        String stringWithPrefix = StringUtils.prependIfMissing(string, "www.");

        System.out.println("Appended String :"+stringWithSuffix);
        System.out.println("Prepend String :"+stringWithPrefix);

        assertEquals("baeldung.com", stringWithSuffix);
        assertEquals("www.baeldung", stringWithPrefix);
    }
}
