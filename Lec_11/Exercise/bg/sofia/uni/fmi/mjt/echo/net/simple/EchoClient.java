package bg.sofia.uni.fmi.mjt.echo.net.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    // this port shall be the same one with the one that the server has set up
    private static final int SERVER_PORT = 6666;

    public static void main(String[] args) {

        // new Socket("localhost", SERVER_PORT) initializes the connection to the server, localhost means this computer
        try (Socket socket = new Socket("localhost", SERVER_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine(); // read a line from the console

                if ("quit".equals(message)) {
                    break;
                }

                System.out.println("Sending message <" + message + "> to the server...");

                writer.println(message); // send the message to the server

                // here the main thread for the client will freeze until the server has sent a response
                String reply = reader.readLine(); // read the response from the server
                System.out.println("The server replied <" + reply + ">");
            }

        } catch (IOException e) {
            throw new RuntimeException("There is a problem with the network communication", e);
        }

    }
}