package bg.sofia.uni.fmi.mjt.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WrittingToAndReadingFromFile {

    public static void main(String... args) {
        Path filePath = Path.of("writingAndReadingFromFile.txt");
        String text = "Write this string to my file" + System.lineSeparator();

        writeToFile(filePath, text);
        readFromFile(filePath);
    }

    private static void writeToFile(Path filePath, String text) {

        try(var bufferedWritter = Files.newBufferedWriter(filePath)) {
            bufferedWritter.write(text);
            bufferedWritter.flush();
        }
        catch (IOException e) {
            System.out.println("The error is " + e.getMessage());
        }

    }

    private static void readFromFile(Path filePath) {
        try (var bufferedReader = Files.newBufferedReader(filePath)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new UncheckedIOException("A problem occurred while reading from a file", e);
        }
    }

}
