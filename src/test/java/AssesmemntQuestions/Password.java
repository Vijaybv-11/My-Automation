package AssesmemntQuestions;
public class Password {
    public static void main(String[] args) {
        String password = "Raj@55.551b2%a3(t";

        int digitSum = 0;
        StringBuilder alphabets = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitSum += Character.getNumericValue(c);
                numbers.append(c);
            } else if (Character.isLetter(c)) {
                alphabets.append(c);
            } else {
                specialChars.append(c);
            }
        }

        System.out.println("Sum of digits in the password: " + digitSum);
        System.out.println("Alphabets in the password: " + alphabets.toString());
        System.out.println("Numbers in the password: " + numbers.toString());
        System.out.println("Special characters in the password: " + specialChars.toString());
    }
}
