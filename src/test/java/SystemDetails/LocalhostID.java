package SystemDetails;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalhostID {
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            String localhostID = localhost.getHostAddress();
            System.out.println("Localhost ID: " + localhostID);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

