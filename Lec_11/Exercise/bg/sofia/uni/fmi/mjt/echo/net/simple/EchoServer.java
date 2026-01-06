package bg.sofia.uni.fmi.mjt.echo.net.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// this is a classic example of a TCP Echo server in Java
public class EchoServer {

    // defines on which port the server is going to listen to, ports below 1024 are well-known ports which needs administrative rights
    private static final int SERVER_PORT = 6666;

    public static void main(String[] args) {

        // setting up the server to listen on port 6666
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            // Get the local IP address of the server
            InetAddress serverAddress = InetAddress.getLocalHost();
            System.out.println("Server started on " + serverAddress.getHostAddress() +
                    " and listening for connection requests on port " + SERVER_PORT);

            // accept() is a blocking method, the main thread will freeze and will stay on this line waiting for a client to connect to the port
            // when a client is connected it will wake up and will return a socket which represents the connection with the clinet
            // Buffered reader adds the .readLine() method as well as buffering
            // InputStreamReader converts a byte stream into character stream
            // PrintWriter is similer to BufferedWriter it just adds a couple of feature, currently every time something is written is immediatelly flushed
            // when the client reaches .accept() the 3-way handshake is made for the TCP
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) { // autoflush on

                // .readline() is also a blocking method, the main thread for the server will freeze until the client has sent information
                // it will continue after we have received message
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Message received from client: " + inputLine);
                    out.println("Echo " + inputLine);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("There is a problem with the server socket", e);
        }
    }

}