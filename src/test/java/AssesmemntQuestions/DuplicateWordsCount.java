package AssesmemntQuestions;

import java.util.LinkedHashMap;

public class DuplicateWordsCount {
    public static void main(String[] args) {
        String text = "I felt happy because I saw the others were happy and because I knew I should feel happy , but I wasn’t really happy .";
        String[] arr = text.split(" ");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (String ch : map.keySet()) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (ch.equals(arr[i])) {
                    count++;
                }
            }
            if (count>1) {
                System.out.println("Occurance of "+ch+" is: "+count);
            }
        }
    }

}
