package SystemDetails;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.atomic.AtomicReference;

public class LatestModifiedPath {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Vijay\\Downloads"; // Specify the directory path here

        try {
            Path directory = Paths.get(directoryPath);

            // Define a custom FileVisitor to track the latest modified path
            AtomicReference<Path> latestModifiedPath = new AtomicReference<>();
            AtomicReference<FileTime> latestModifiedTime = new AtomicReference<>(FileTime.fromMillis(0));

            FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileTime modifiedTime = attrs.lastModifiedTime();
                    if (modifiedTime.compareTo(latestModifiedTime.get()) > 0) {
                        latestModifiedTime.set(modifiedTime);
                        latestModifiedPath.set(file);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // Handle file access errors here
                    System.err.println("Failed to access file: " + file);
                    return FileVisitResult.CONTINUE;
                }
            };

            // Traverse the directory and its subdirectories
            Files.walkFileTree(directory, fileVisitor);

            // Get the latest modified path
            Path latestPath = latestModifiedPath.get();
            if (latestPath != null) {
                System.out.println("Latest Modified Path: " + latestPath);
            } else {
                System.out.println("No files found within the specified directory.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

