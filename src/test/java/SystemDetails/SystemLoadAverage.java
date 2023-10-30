package SystemDetails;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class SystemLoadAverage {

    public static void main(String[] args) {

        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double systemLoadAverage = osBean.getSystemLoadAverage();
        System.out.println("System Load Average: " + systemLoadAverage);
    }
}
