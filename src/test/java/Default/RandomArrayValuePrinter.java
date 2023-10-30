package Default;

import java.util.Random;

public class RandomArrayValuePrinter {
    public static void main(String[] args) {
        // Create an array of strings
        String[] stringArray = {
                "Apple", "Banana", "Cherry", "Orange", "Grapes", "Mango"
        };

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Generate a random index to access a random element from the array
        int randomIndex = random.nextInt(stringArray.length);

        // Print the random element
        System.out.println("Random value from the array: " + stringArray[randomIndex]);
    }
}
