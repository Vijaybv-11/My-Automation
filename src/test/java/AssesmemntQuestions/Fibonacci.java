package AssesmemntQuestions;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Range of numbers");
        int range =sc.nextInt();
        int first =0;
        int second =1;
        int finalResult=0;
        for(int i=0;i<range;i++){
            finalResult = first+second;
            first=second;
            second=finalResult;
        }
        System.out.println("Finonacci for given range is "+finalResult);
    }
}
