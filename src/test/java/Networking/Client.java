package Networking;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int SERVER_PORT = 9090;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Send a message to the server
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Hey , It's Vijay here Trying to Contact you !");

            // Read the server's response
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String serverMessage = reader.readLine();
            System.out.println("Received from server: " + serverMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
