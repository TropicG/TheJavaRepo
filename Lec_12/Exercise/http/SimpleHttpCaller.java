package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleHttpCaller {

    // the address that we are connecting to
    private static final String HOST = "google.com";
    // 80 is the standart port for HTTP communication
    private static final int PORT = 80;

    // Command sent to google.server it means Get me the resource found at loc / using HTTP/1.1
    // Adding line seperator at the end since HTTP require us to do that
    private static final String HTTP_REQUEST = "GET / HTTP/1.1 " + System.lineSeparator();

    public static void main(String[] args) {

        try(Socket socket = new Socket(HOST, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {


            out.println(HTTP_REQUEST);

            String line;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("There was a problem with the server");
        }


    }

}
