package ApacheStringClass;

import org.apache.commons.lang3.StringUtils;

public class StringEquals {

    public static void main(String[] args) {

        String value1 ="Jay";
        String value2="jay";
        boolean isEquals= StringUtils.equalsAnyIgnoreCase(value1,value2);

        System.out.println("isEquals :"+isEquals);

    }
}
