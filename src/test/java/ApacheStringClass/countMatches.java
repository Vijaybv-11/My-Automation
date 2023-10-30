package ApacheStringClass;

import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.assertEquals;

public class countMatches {

    public static void main(String[] args) {

        String string = "welcome to www.baeldung.com";
        int charNum = StringUtils.countMatches(string, 'w');
        int stringNum = StringUtils.countMatches(string, "com");


        assertEquals(4, charNum);
        assertEquals(2, stringNum);
    }
}
