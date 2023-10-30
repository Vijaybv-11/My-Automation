package GUIApplications;
import javax.swing.*;

public class SimpleGUI {
    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("My Small Window");

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel (a text label)
        JLabel label = new JLabel("Hey, It's Vijay here!");

        // Add the label to the content pane of the frame
        frame.getContentPane().add(label);

        // Set the size of the window
        frame.setSize(300, 200);

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Make the window visible
        frame.setVisible(true);
    }
}
