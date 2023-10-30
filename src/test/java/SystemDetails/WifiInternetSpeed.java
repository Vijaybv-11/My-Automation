package SystemDetails;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class WifiInternetSpeed {

    public static void main(String[] args) {
        String fileUrl = "https://google.com"; // Replace with a large file URL for more accurate results
        int fileSizeInBytes = 1024 * 1024; // 1MB file size for demonstration

        try {
            long startTime = System.currentTimeMillis();
            URL url = new URL(fileUrl);
            URLConnection connection = url.openConnection();
            BufferedInputStream inStream = new BufferedInputStream(connection.getInputStream());

            byte[] data = new byte[fileSizeInBytes];
            int bytesRead;
            while ((bytesRead = inStream.read(data, 0, fileSizeInBytes)) != -1) {
                // Downloading the file, but not storing the content
            }
            inStream.close();

            long endTime = System.currentTimeMillis();
            long downloadTime = endTime - startTime;

            // Calculate internet speed
            double speedKbps = (fileSizeInBytes / 1024.0) / (downloadTime / 1000.0);
            double speedMbps = speedKbps / 1024.0;

            System.out.println("Internet Speed: " + String.format("%.2f", speedMbps) + " Mbps");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
