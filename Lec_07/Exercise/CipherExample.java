package bg.sofia.uni.fmi.mjt.io;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Base64;
import java.util.List;

public class CipherExample {

    private static final int KILOBYTE = 1025;
    private static final String ENCRYPTION_ALGORITHM = "AES"; // Advance Encryption Standart
    private static final int KEY_SIZE_IN_BITS = 128;
    private static final String KEY_FILE_PATH = "secret.key";

    public static void main(String[] args) {

        try {

            // creating the secretKey used in the encryption
            SecretKey secretKey = generateSecretKey();

            // Storing the encriptionKey in the file
            persistSecretKey(secretKey);



        } catch(Exception e) {
            System.out.println("Exception caught during the execution " + e.getMessage());
        }

    }


    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException {

        // this class is used to generated criptic keys for cryptic algorithms
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ENCRYPTION_ALGORITHM);
        keyGenerator.init(KEY_SIZE_IN_BITS); // the size of the key in bits
        SecretKey secretKey = keyGenerator.generateKey(); // generateKey() generates a key and it is assigned to SecreteKey

        //secretKey is the key, which is not a plain text, but sequence of raw bytes [for example 42, -110]
        //Since those raw bytes cannot be read be a human and they cant be coppied since they are not in txt form
        //Base64 is a class that can converts binary data into txt and its encoder can convert from binary to txt
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Generated Secret Key (Base64-encoded): " + base64Key);

        return secretKey;
    }

    private static void persistSecretKey(SecretKey secretKey) throws IOException {

        byte[] keyBytes = secretKey.getEncoded();
        Path keyFilePath = Path.of(KEY_FILE_PATH);

        //write key bytes to the file
        //StandardOpenOption.Create craetes the file "secret.key" if it wasnt created
        //StandartOpenOption.TRANCATE_EXISTING if the file "secret.key" exists, delete its old content
        Files.write(keyFilePath, keyBytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        // Only the creator of this file can access it, otherwise no
        //Files.setPosixFilePermissions(keyFilePath, PosixFilePermissions.fromString("rm-------"));


    }

    private static SecretKey loadSecretKey() throws IOException {

        //reading all the bytes from the file
        byte[] keyBytes = Files.readAllBytes(Path.of(KEY_FILE_PATH));

        //SecretKeySpec allows us to construct SecretKey object from an array of raw bytes
        //Note: The secretKey was initially saved with raw bytes in the file and right now we are reading from it
        return new SecretKeySpec(keyBytes, ENCRYPTION_ALGORITHM);
    }

    private static void encryptedData(SecretKey secretKey) throws Exception {

        //Creates cipher instance in order to configurate it to use AES algorithm
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);

        //adding more configuration to cipher, turning him in ENCRYPT_MODE and the key to use must be secretKey
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        //the CipherOutputStream wil write encrypted data to encrypted.txt using cipher
        try(var outputStream = new CipherOutputStream(new FileOutputStream("encrypted.txt"), cipher)) {

            List<String> data = List.of("my-", "secret-", "pass-", "and-", "other-", "stuff");

            for(String str : data) {
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                outputStream.write(bytes);
            }

            System.out.println("Encryption completed");

        }
    }

    private static void decryptData(SecretKey secretKey) throws Exception {

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try(InputStream encryptedInputStream = new FileInputStream("encryptedText.txt");
        OutputStream decreptedOutPutStream = new CipherOutputStream(new FileOutputStream("decryptedText.txt"), cipher))
        {

            byte[] buffer = new byte[KILOBYTE];
            int bytesRead;

            while((bytesRead = encryptedInputStream.read(buffer)) != -1) {
                decreptedOutPutStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Decryption complete");
        }
    }
}
