## Задачи за упражнение върху Java I/O

---

### Задача 1: Четене и писане в текстов файл

**Цел:** Да се имплементират методи за запис на текст във файл и четене на съдържанието му ред по ред, използвайки `java.nio.file.Files`.

**Изисквания:**

1.  **Метод `writeToFile(Path filePath, String text)`:**
    * Трябва да приема `Path` (път до файла) и `String` (текст за запис).
    * Да използва `Files.newBufferedWriter` в `try-with-resources` блок за ефективно писане.
    * Да запише предоставения `text` във файла.
    * Да извика `flush()` след записа.
    * Да обработи евентуален `IOException`, като отпечата съобщение за грешка.

2.  **Метод `readFromFile(Path filePath)`:**
    * Трябва да приема `Path`.
    * Да използва `Files.newBufferedReader` в `try-with-resources` блок.
    * Да чете файла ред по ред (например с `while ((line = bufferedReader.readLine()) != null)`).
    * Да отпечатва всеки прочетен ред на конзолата.
    * Да обработи `IOException`, като хвърли `UncheckedIOException`.

3.  **`main` метод:**
    * Дефинирайте `Path` (напр. `myTextFile.txt`).
    * Дефинирайте `String` с примерен текст, който включва и символ за нов ред (`System.lineSeparator()`).
    * Извикайте `writeToFile` и след това `readFromFile` със създадения `Path` и текст.

---

### Задача 2: Работа с Data Streams за примитивни типове

**Цел:** Да се използват `DataOutputStream` и `DataInputStream` за запис и четене на примитивни Java типове (int, float, String) в двоичен файл.

**Изисквания:**

1.  **Метод `writeWithDataStream()`:**
    * Да създаде `DataOutputStream`, "обвиващ" `FileOutputStream` (напр. `primitives.dat`) в `try-with-resources` блок.
    * Да запише последователно в потока:
        * `int` (напр. `42`)
        * `float` (напр. `3.14f`)
        * `String` (напр. "Hello MJT!") чрез `writeUTF()`.
    * Да извика `flush()` след записите.
    * Да обработи `IOException` чрез отпечатване на съобщение за грешка.

2.  **Метод `readDataStream()`:**
    * Да създаде `DataInputStream`, "обвиващ" `FileInputStream` (за същия `primitives.dat` файл) в `try-with-resources` блок.
    * Да прочете данните **в същия ред**, в който са записани (`readInt()`, `readFloat()`, `readUTF()`).
    * Да отпечата прочетените стойности на конзолата, като посочи типа им (напр. "int: 42").
    * Да обработи `IOException` чрез отпечатване на съобщение за грешка.

3.  **`main` метод:**
    * Извикайте `writeWithDataStream` и след това `readDataStream`.

---

### Задача 3: Сериализация и Десериализация на обекти

**Цел:** Да се запишат Java обекти във файл (сериализация) и след това да се прочетат обратно (десериализация) с помощта на `ObjectOutputStream` и `ObjectInputStream`.

**Изисквания:**

1.  **`Student` клас/record:**
    * Дефинирайте `record` или `class` `Student`.
    * Той трябва да имплементира интерфейса `java.io.Serializable`.
    * Трябва да има поне две полета (напр. `String name`, `int age`).
    * **Важно:** Дефинирайте `private static final long serialVersionUID`.

2.  **Метод `writeStudentsToFile(Path file, Student... students)`:**
    * Да приема `Path` и променлив брой `Student` обекти.
    * Да използва `ObjectOutputStream`, "обвиващ" `Files.newOutputStream(file)` в `try-with-resources` блок.
    * Да итерира през масива `students`.
    * За всеки `student` да извика `objectOutputStream.writeObject(student)` и `flush()`.
    * Да обработи `IOException`, като хвърли `UncheckedIOException`.

3.  **Метод `readStudentFromFile(Path file)`:**
    * Да приема `Path`.
    * Да използва `ObjectInputStream`, "обвиващ" `Files.newInputStream(file)` в `try-with-resources` блок.
    * Да чете обекти в `while(true)` цикъл.
    * Във `while` цикъла:
        * Да прочете обект с `objectInputStream.readObject()`.
        * Да кастне (преобразува) прочетения `Object` към `Student`.
        * Да отпечата информация за студента (напр. името му).
    * Да обработи `Exception`. В `catch` блока проверете дали изключението е `EOFException` (End Of File Exception). Ако е, това е нормалният край на четенето и можете да спрете цикъла (или просто да не правите нищо). Ако е друга грешка, отпечатайте я.

4.  **`main` метод:**
    * Дефинирайте `Path` (напр. `students.bin`).
    * Създайте два или повече `Student` обекта.
    * Извикайте `writeStudentsToFile` с тях.
    * Извикайте `readStudentFromFile`.

---

### Задача 4: Шифриране и Дешифриране на данни

**Цел:** Да се имплементира пълен цикъл на симетрично (AES) шифриране на данни във файл и последващото им дешифриране, включително генериране, запис и четене на таен ключ.

**Изисквания:**

1.  **Константи:**
    * Дефинирайте константи: `ENCRYPTION_ALGORITHM = "AES"`, `KEY_SIZE_IN_BITS = 128` и `KEY_FILE_PATH = "secret.key"`.

2.  **Метод `generateSecretKey()`:**
    * Трябва да връща `SecretKey`.
    * Да вземе инстанция на `KeyGenerator` за `AES`.
    * Да я инициализира с `KEY_SIZE_IN_BITS`.
    * Да генерира и върне `SecretKey`.
    * (По желание) Да отпечата Base64-кодирания ключ (`Base64.getEncoder().encodeToString(secretKey.getEncoded())`) за проверка.

3.  **Метод `persistSecretKey(SecretKey secretKey)`:**
    * Да приеме `SecretKey`.
    * Да вземе суровите байтове на ключа (`secretKey.getEncoded()`).
    * Да запише тези байтове във файла `KEY_FILE_PATH` (използвайки `Files.write` с `StandardOpenOption.CREATE` и `StandardOpenOption.TRUNCATE_EXISTING`).

4.  **Метод `loadSecretKey()`:**
    * Трябва да връща `SecretKey`.
    * Да прочете всички байтове от `KEY_FILE_PATH` (`Files.readAllBytes`).
    * Да конструира и върне `SecretKey` обект, използвайки `new SecretKeySpec(keyBytes, ENCRYPTION_ALGORITHM)`.

5.  **Метод `encryptedData(SecretKey secretKey)`:**
    * Да приеме `SecretKey`.
    * Да вземе инстанция на `Cipher` за `AES`.
    * Да инициализира `Cipher`-а в режим `Cipher.ENCRYPT_MODE` с предоставения `secretKey`.
    * Да използва `CipherOutputStream`, "обвиващ" `FileOutputStream` (напр. `encrypted.txt`) в `try-with-resources` блок.
    * Да дефинира `List<String>` с данни (напр. "my-", "secret-", "data").
    * Да итерира през списъка и да запише байтовете на всеки `String` в `CipherOutputStream`.

6.  **Метод `decryptData(SecretKey secretKey)`:**
    * Да приеме `SecretKey`.
    * Да вземе инстанция на `Cipher` за `AES`.
    * Да инициализира `Cipher`-а в режим `Cipher.DECRYPT_MODE` с `secretKey`.
    * Да използва `InputStream` (напр. `FileInputStream` за `encrypted.txt`) и `OutputStream` (напр. `FileOutputStream` за `decrypted.txt`).
    * Да "обвие" `OutputStream`-а с `new CipherOutputStream(outputStream, cipher)`.
    * Да чете байтове от `InputStream`-а и да ги пише в `CipherOutputStream`-а (напр. с буфер `byte[]` и цикъл), за да дешифрира данните и да ги запише в `decrypted.txt`.

7.  **`main` метод:**
    * Извикайте `generateSecretKey()` и `persistSecretKey()` (за да създадете и запазите ключа).
    * Извикайте `loadSecretKey()` (за да симулирате зареждане на ключа в отделно изпълнение).
    * Извикайте `encryptedData()` с заредения ключ.
    * Извикайте `decryptData()` със същия ключ.
    * **Проверка:** Прочетете файла `decrypted.txt` (например с метода от Задача 1) и отпечатайте съдържанието му, за да се уверите, че дешифрирането е успешно.