package SystemDetails;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class GetRecentDownloadedFilePath {

    public static void main(String[] args) {
        String downloadsDirectoryPath = getDownloadsDirectoryPath();
        File downloadsDirectory = new File(downloadsDirectoryPath);

        if (downloadsDirectory.exists() && downloadsDirectory.isDirectory()) {
            File recentDownloadedFile = getMostRecentFile(downloadsDirectory);

            if (recentDownloadedFile != null) {
                System.out.println("Most Recent Downloaded File Path: " + recentDownloadedFile.getAbsolutePath());
            } else {
                System.out.println("No files found in the Downloads directory.");
            }
        } else {
            System.out.println("Downloads directory not found.");
        }
    }

    private static String getDownloadsDirectoryPath() {
        String userHome = System.getProperty("user.home");
        return userHome + File.separator + "Downloads";
    }

    private static File getMostRecentFile(File directory) {
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File mostRecentFile = files[0];
        long lastModifiedTime = mostRecentFile.lastModified();

        for (File file : files) {
            long fileLastModifiedTime = file.lastModified();
            if (fileLastModifiedTime > lastModifiedTime) {
                mostRecentFile = file;
                lastModifiedTime = fileLastModifiedTime;
            }
        }

        return mostRecentFile;
    }
}

