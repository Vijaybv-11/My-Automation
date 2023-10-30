package SystemDetails;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class WifiDetails {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                if (networkInterface.isUp() && networkInterface.getHardwareAddress() != null && isWifiInterface(networkInterface)) {
                    System.out.println("Interface Name: " + networkInterface.getDisplayName());
                    System.out.println("MAC Address: " + formatMacAddress(networkInterface.getHardwareAddress()));
                    System.out.println("IP Address: " + getIpAddress(networkInterface));
                }
            }
        } catch (SocketException e) {
            System.err.println("Error retrieving WiFi details: " + e.getMessage());
        }
    }

    private static boolean isWifiInterface(NetworkInterface networkInterface) {
        String name = networkInterface.getName();
        return name.startsWith("wlan") || name.startsWith("eth");
    }

    private static String formatMacAddress(byte[] macAddress) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < macAddress.length; i++) {
            stringBuilder.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
        }

        return stringBuilder.toString();
    }

    private static String getIpAddress(NetworkInterface networkInterface) {
        Enumeration<java.net.InetAddress> inetAddresses = networkInterface.getInetAddresses();

        while (inetAddresses.hasMoreElements()) {
            java.net.InetAddress inetAddress = inetAddresses.nextElement();

            if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().contains(":")) {
                return inetAddress.getHostAddress();
            }
        }

        return "";
    }
}
