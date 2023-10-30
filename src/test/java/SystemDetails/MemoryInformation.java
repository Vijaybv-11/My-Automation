package SystemDetails;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryInformation {

    public static void main(String[] args) {

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

        long heapUsedMemory = heapMemoryUsage.getUsed();
        long heapMaxMemory = heapMemoryUsage.getMax();
        long nonHeapUsedMemory = nonHeapMemoryUsage.getUsed();
        long nonHeapMaxMemory = nonHeapMemoryUsage.getMax();

        System.out.println("Heap Memory Used: " + heapUsedMemory);
        System.out.println("Heap Memory Max: " + heapMaxMemory);
        System.out.println("Non-Heap Memory Used: " + nonHeapUsedMemory);
        System.out.println("Non-Heap Memory Max: " + nonHeapMaxMemory);

    }
}
