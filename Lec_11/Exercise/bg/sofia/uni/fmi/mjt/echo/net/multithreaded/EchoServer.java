package bg.sofia.uni.fmi.mjt.echo.net.multithreaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    // server will listen to port 4444
    private static final int SERVER_PORT = 4444;

    // at most the server can accept 10 worker threads
    private static final int WORKER_THREADS = 10;

    public static void main(String[] args) {

        Thread.currentThread().setName("ServerThread");

        // creating the server that will listen to the port 4444
        // creating the executorService that at most it can communicate with 10 clinets
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            ExecutorService executorService = Executors.newFixedThreadPool(WORKER_THREADS)) {

            Socket clientSocket;
            while(true) {

                // here the server will freeze to wait for an upcoming connection with a client
                // it will continue to work after the server has accepted a clinet
                clientSocket = serverSocket.accept();

                // the client will be given a thread to communicate with
                // this is done to keep the current thread free to accept() request from clients
                ClientHandler clientHandler = new ClientHandler(clientSocket);

                // the connection with the thread will be created on a different thread
                executorService.execute(clientHandler);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
