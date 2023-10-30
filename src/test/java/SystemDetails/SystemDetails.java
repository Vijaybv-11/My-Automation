package SystemDetails;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemDetails {

    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        String osName = osBean.getName();
        String osArch = osBean.getArch();
        String osVersion = osBean.getVersion();
        int availableProcessors = osBean.getAvailableProcessors();

        // Retrieve system properties
        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String javaHome = System.getProperty("java.home");
        String osUser = System.getProperty("user.name");
        String osHome = System.getProperty("user.home");

        // Print system details
        System.out.println("Operating System: " + osName + " " + osArch + " " + osVersion);
        System.out.println("Available Processors: " + availableProcessors);
        System.out.println("Java Version: " + javaVersion);
        System.out.println("Java Vendor: " + javaVendor);
        System.out.println("Java Home: " + javaHome);
        System.out.println("User: " + osUser);
        System.out.println("User Home Directory: " + osHome);
    }
}
