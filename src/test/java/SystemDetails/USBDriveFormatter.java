package SystemDetails;

import java.io.IOException;

public class USBDriveFormatter {

    public static void main(String[] args) {

        String driveLetter = "D:\\";

        try {
            // Execute the format command
            Process process = Runtime.getRuntime().exec("format " + driveLetter + " /FS:FAT32 /Q");

            // Wait for the process to complete
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("USB drive formatted successfully.");
            } else {
                System.out.println("Failed to format USB drive.");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error formatting USB drive: " + e.getMessage());
        }
    }
}
