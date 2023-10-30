package AssesmemntQuestions;
public class DivisibilityCheck {
    public static void main(String[] args) {

        int[] numbers = {11, 15, 20, 25, 30, 36, 45, 60, 72, 90};
        int count = 0;
        for (int num : numbers) {
            if (num % 4 == 0 || num % 3 == 0 || num % 5 == 0) {
                count++;
            }
        }
        System.out.println("The number of numbers divisible by 4, 3, and 5 is: " + count);
    }
}
