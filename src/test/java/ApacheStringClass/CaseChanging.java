package ApacheStringClass;

import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.assertEquals;

public class CaseChanging {
    public static void main(String[] args) {

        String originalString = "baeldung.COM";
        String swappedString = StringUtils.swapCase(originalString);
        assertEquals("BAELDUNG.com", swappedString);
        System.out.println("UpperCaseString is :"+swappedString);
        String capitalizedString = StringUtils.capitalize(originalString);
        assertEquals("Baeldung", capitalizedString);
        System.out.println("Capitalized String is :"+capitalizedString);

    }
}

