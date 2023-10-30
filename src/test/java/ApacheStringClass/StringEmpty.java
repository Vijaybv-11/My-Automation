package ApacheStringClass;

import org.apache.commons.lang3.StringUtils;

public class StringEmpty {

    public static void main(String[] args) {

        String str = "   Hello, World!   ";

        boolean isEmpty = StringUtils.isEmpty(str);
        System.out.println("Is empty: " + isEmpty);
    }
}
