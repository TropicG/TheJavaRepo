package bg.sofia.uni.fmi.mjt.io;

import java.io.*;

public class DataStreamExample {

    public static void main(String[] args) {

        writeWithDataStream();
        readDataStream();

    }

    private static void writeWithDataStream() {

        //it will create a file if it is not found
        try(var dataOutputStream = new DataOutputStream(new FileOutputStream("test.dat"))) {
            dataOutputStream.writeInt(16);
            dataOutputStream.writeFloat(15.0f);
            dataOutputStream.writeUTF("deniemnogohubava");

            // rememeber writing directly to a file is an expensive operation
            // instead we are writting to a buffer and when the writting operations have completed after that we are writting the buffer to the file
            dataOutputStream.flush();

            //it is physically expensive, because we are not working with RAM but with HDD or SSD
        } catch (IOException e) {
            System.out.println("A problem has occured " + e.getMessage());
        }
    }


    private static void readDataStream() {

        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("test.dat"))) {
            System.out.println("int: " + dataInputStream.readInt());
            System.out.println("float: " + dataInputStream.readFloat());
            System.out.println("string: " + dataInputStream.readUTF());

        } catch (IOException e) {
            System.out.println("A problem has occured " + e.getMessage());
        }

    }
}
