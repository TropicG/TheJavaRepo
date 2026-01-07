package bg.sofia.uni.fmi.mjt.echo.net.multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private static final int SERVER_PORT = 4444;

    public static void main(String[] args) {

        // connecting to the server who is listening to localhost and server port
        try(Socket serverSocket = new Socket("localhost", SERVER_PORT);
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            Scanner scanner = new Scanner(System.in)) {

            Thread.currentThread().setName("Echo client " + serverSocket.getLocalPort());

            System.out.println("Connected to the server");


            while(true) {

                System.out.print("Enter message: ");
                String message = scanner.nextLine(); // read a line from the console

                if ("quit".equals(message)) {
                    break;
                }

                System.out.println("Sending message <" + message + "> to the server...");

                out.println(message); // send the message to the server

                String reply = in.readLine(); // read the response from the server
                System.out.println("The server replied <" + reply + ">");


            }


        } catch (IOException e) {
            throw new RuntimeException("There is a problem with the network communication", e);
        }


    }


}
