package Default;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        String str = "Vijay,Ajay,Sanjay,Jay";
        String[] strArray = str.split(","); // Split by space
        List<String> strList1 = Arrays.asList(strArray);
        System.out.println("Using Arrays.asList(): " + strList1);
        Collections.sort(strList1);
        System.out.println("Using Arrays.asList(): " + strList1);
        Collections.reverse(strList1);
        System.out.println("Using Arrays.asList(): " + strList1);

       /* // Method 2: Iterating and adding to a List
        String str2 = "Hello";
        char[] charArray = str2.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char c : charArray) {
            charList.add(c);
        }
        System.out.println("Using iteration: " + charList);*/
    }
}
