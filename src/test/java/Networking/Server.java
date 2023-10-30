package Networking;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 9090;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create input and output streams for communication with the client
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                // Read data from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String clientMessage = reader.readLine();
                System.out.println("Received from client: " + clientMessage);

                // Send a response to the client
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("Hello, client!");

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
