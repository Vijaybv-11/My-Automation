import java.util.HashMap;
import java.util.Map;

class PrintDuplicates{

        public static void main(String[] args) {
            String text = "I felt happy because I saw the others were happy and because I knew I should feel happy, but I wasn’t really happy.";

            // Split the string into words
            String[] words = text.split("\\s+");

            // Create a map to store word counts
            Map<String, Integer> wordCounts = new HashMap<>();

            // Count the occurrences of each word
            for (String word : words) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }

            // Print duplicate words with their counts
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println("'" + entry.getKey() + "' appears " + entry.getValue() + " times.");
                }
            }
        }
    }


