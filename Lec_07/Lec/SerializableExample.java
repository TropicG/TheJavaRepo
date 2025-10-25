import java.io.Serializable;

// implementing Serializable signals Java that objects from this class can be converted
// to an stream of bytes in order to be saved on a file or a network for example and converted to object from those bytes
public class Person implements Serializable {

    // When we are assembling the bytes into an object from Person, Java compares serialVersionUID from the file with serialVersionUID in the code
    // If those values match, the object is passed into the stream
    // otherwise InvalidClassException is thrown
    private static final long serialVersionUID = 1234L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}