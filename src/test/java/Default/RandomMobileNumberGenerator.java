package Default;

import java.util.Random;

public class RandomMobileNumberGenerator {
    public static void main(String[] args) {
        int numNumbers = 10; // Number of random mobile numbers to generate

        for (int i = 0; i < numNumbers; i++) {
            String mobileNumber = generateRandomMobileNumber();
            System.out.println(mobileNumber);
        }
    }

    // Generate a random 10-digit mobile number
    private static String generateRandomMobileNumber() {
        Random random = new Random();

        // Array of possible starting digits (9, 8, 7, 6)
        int[] startingDigits = {9, 8, 7, 6};

        // Select a random starting digit from the array
        int randomIndex = random.nextInt(startingDigits.length);
        int startingDigit = startingDigits[randomIndex];

        // Generate the remaining 9 digits randomly
        StringBuilder mobileNumber = new StringBuilder(String.valueOf(startingDigit));
        for (int i = 1; i < 10; i++) {
            int digit = random.nextInt(10); // Generate a random digit (0-9)
            mobileNumber.append(digit);
        }

        return mobileNumber.toString();
    }
}
