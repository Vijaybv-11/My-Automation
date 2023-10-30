package SystemDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatteryHealthDetails {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("WMIC PATH Win32_Battery Get EstimatedChargeRemaining");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches("[0-9]+")) {
                    int estimatedChargeRemaining = Integer.parseInt(line);
                    System.out.println("Estimated Charge Remaining: " + estimatedChargeRemaining + "%");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
