package bg.sofia.uni.fmi.mjt.echo.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

// This whole server will try to communicate in a non-blocking way with all the clients
// The idea is to use only one thread that will communicate with a large amount of clients
// The server will have a selector that will have registered channels with selectorKeys that will inform the selector that they are ready for operation

public class EchoServer {
    // the server will listen to port 7777
    public static final int SERVER_PORT = 7777;

    // the server will listen to the localhost of the machine it is started on
    private static final String SERVER_HOST = "localhost";

    // the size of the buffer that is going to be used for communication between the channels and the server
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        // Starting up the server
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            // the server will be set up on this ip and this host
            serverSocketChannel.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
            // this is important it converts the server into nonblocking mode, this means that methods such as accept will not freeze
            serverSocketChannel.configureBlocking(false);

            // Get the local IP address of the server
            InetAddress serverAddress = InetAddress.getLocalHost();
            System.out.println("NIO server started on " + serverAddress.getHostAddress() +
                    " and listening for connection requests on port " + SERVER_PORT);

            // the selector is created, it will listen to the clients are there ready with their operation
            Selector selector = Selector.open();
            // registering the selector to the server socket channel
            // The selector will inform the channel when an event of type OP_ACCEPT happens
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            // creating the buffer, this buffer could be used at the same time with many clients
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

            while (true) {
                // .select() will return the number of all events that happened and were informed to the selector
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    // select() is blocking but may still return with 0, check javadoc
                    continue;
                }

                // gets all the events that happened and they will be iterated one by one
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    // checks if the event is "is there any data to be read"
                    if (key.isReadable()) {
                        // gets the SocketChannel of the client who sent the data
                        SocketChannel sc = (SocketChannel) key.channel();

                        // clears the buffer (remember position=0 and limit=capacity) so that the server can write data
                        buffer.clear();
                        // reading the data from the network and putting it into the buffer
                        int r = sc.read(buffer);
                        if (r < 0) {
                            System.out.println("Client has closed the connection");
                            sc.close();
                            keyIterator.remove();
                            continue;
                        }
                        // it converst the buffer from writing to reading
                        // Note: This is mandatory since the position index will be changed from, this will set it to 0 and the limit
                        // to the last position place
                        buffer.flip();
                        // returning the data again to the client
                        sc.write(buffer);

                    } else if (key.isAcceptable()) { // if a new client wants to connect
                        System.out.println("New client has been connected");
                        // getting the server socket channel
                        ServerSocketChannel sockChannel = (ServerSocketChannel) key.channel();
                        // accepting the new connection with the client
                        SocketChannel remoteClientChannel = sockChannel.accept();
                        // setting the connection to not block, to be controlled by the selector
                        remoteClientChannel.configureBlocking(false);
                        // registering the selector with the new client, the server will be informed when the client has data ready
                        remoteClientChannel.register(selector, SelectionKey.OP_READ);
                    }

                    // we need to remove the event that was iterated over and reacted to it
                    keyIterator.remove();
                }

            }

        } catch (IOException e) {
            throw new RuntimeException("There is a problem with the server socket", e);
        }
    }
}
