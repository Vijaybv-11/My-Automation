package Default;

public class StringSplitExample {
    public static void main(String[] args) {
        String input = "LOGIN/REGISTER";

        String[] parts = input.split("/");


        if (parts.length == 2) {
            String beforeSlash = parts[0];
            String afterSlash = parts[1];

            System.out.println("Before Slash: " + beforeSlash);
            System.out.println("After Slash: " + afterSlash);
        } else {
            System.out.println("The input string does not contain a slash.");
        }
    }
}


