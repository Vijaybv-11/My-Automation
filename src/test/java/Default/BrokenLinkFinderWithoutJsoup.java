package Default;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BrokenLinkFinderWithoutJsoup {
    public static void main(String[] args) {
        String websiteURL = "https://wordpress-205471-3653890.cloudwaysapps.com/"; // Replace with the website URL you want to check

        try {
            List<String> links = getLinksFromWebsite(websiteURL);

            ExecutorService executor = Executors.newFixedThreadPool(10); // Number of threads
            List<Future<String>> futures = new ArrayList<>();

            for (String link : links) {
                futures.add(executor.submit(() -> checkLink(link)));
            }

            for (Future<String> future : futures) {
                String result = future.get();
                if (result != null) {
                    System.out.println(result);
                }
            }

            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getLinksFromWebsite(String websiteURL) throws IOException {
        // Implement code to fetch links from the website here, e.g., using HttpURLConnection
        // Return a list of links
        return new ArrayList<>();
    }

    private static String checkLink(String url) {
        try {
            URL linkURL = new URL(url);

            // Skip URLs with unsupported protocols
            if (!linkURL.getProtocol().startsWith("http")) {
                return null;
            }

            HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                return "Broken Link: " + url + " (HTTP Status: " + responseCode + ")";
            }
        } catch (IOException e) {
            return "Error checking link: " + url;
        }
        return null;
    }
}
