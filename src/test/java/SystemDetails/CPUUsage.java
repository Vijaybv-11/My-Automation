package SystemDetails;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class CPUUsage {
    public static void main(String[] args) {

        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double cpuUsage = osBean.getProcessCpuLoad() * 100;
        System.out.println("CPU Usage: " + cpuUsage + "%");

    }
}
