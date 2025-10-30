package bg.sofia.uni.fmi.mjt.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

record Student(String name, int age) implements Serializable {

    private static final long serialVersionUID = -4620197539457134073L;

}

public class ObjectStreamExample {

    public static void main(String[] args) {

        Path filePath = Path.of("students.bin");
        Student firstStudent = new Student("Gosho", 20);
        Student secondStdeunt = new Student("Stamat", 80);

        writeStudentsToFile(filePath, firstStudent, secondStdeunt);
        readStudentFromFile(filePath);
    }


    private static void writeStudentsToFile(Path file, Student... students) {

        //writing to the file
        try(var objectOutputStream = new ObjectOutputStream(Files.newOutputStream(file))) {
            for(Student student : students) {

                //for every student we are writting to the file
                objectOutputStream.writeObject(student);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            throw new UncheckedIOException("A problem occured while writing to a file", e);
        }
    }

    private static void readStudentFromFile(Path file) {

        try(var objectInputStream = new ObjectInputStream(Files.newInputStream(file))) {

            Object studentObject;
            while( (studentObject = objectInputStream.readObject()) != null) {

                //we need to cast in order to read properly
                Student student = (Student) studentObject;
                System.out.println("Name " + student.name());
            }
        }
        catch(Exception e) {
            System.out.println("The current error is " + e.getMessage());
        }
    }
}
