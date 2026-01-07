package bg.sofia.uni.fmi.mjt.echo.net.multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    // Everytime a client connects to the server a thread will be created in order to work with the client
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        Thread.currentThread().setName("Client request for " + clientSocket.getRemoteSocketAddress());

        try(PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            clientSocket) {

            String line;
            while((line = in.readLine()) != null) {
                System.out.println("Received by client " + clientSocket.getRemoteSocketAddress() + " messaage: " + line);
                out.println("Echo " + line);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
