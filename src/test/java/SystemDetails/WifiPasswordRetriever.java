package SystemDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WifiPasswordRetriever {
    public static void main(String[] args) {
        String ssid = "Tyss-Alfa"; // Replace with your WiFi SSID

        try {
            Process process = Runtime.getRuntime().exec("netsh wlan show profile name=\"" + ssid + "\" key=clear");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Key Content")) {
                    String password = line.split(":")[1].trim();
                    System.out.println("WiFi Password: " + password);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error retrieving WiFi password: " + e.getMessage());
        }
    }
}
