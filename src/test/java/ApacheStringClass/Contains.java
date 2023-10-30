package ApacheStringClass;

import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Contains {
    public static void main(String[] args) {

        String string = "www.facebook.com";
        boolean contained1 = StringUtils.containsAny(string, 'a', 'b', 'c');
        boolean contained2 = StringUtils.containsAny(string, 'x', 'y', 'z');
        boolean contained3 = StringUtils.containsAny(string, "abc");
        boolean contained4 = StringUtils.containsAny(string, "xyz");
        boolean contained = StringUtils.containsIgnoreCase(string, "BAELDUNG");

        assertFalse(contained);
        assertTrue(contained1);
        assertFalse(contained2);
        assertTrue(contained3);
        assertFalse(contained4);
    }
}
