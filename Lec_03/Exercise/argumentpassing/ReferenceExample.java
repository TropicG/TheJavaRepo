public class ReferenceExample {

    public static void main(String... args) {

        Person person = new Person("Nicole");

        //after this function call the person reference is going to point to object Peter
        modifyReference(person);

        //after this function call the reference is going to point to the same object, but its data is going to be changed8
        modifyObject(person)

    }


    public staic void modifyReference(Person p) {
        p = new Person("Peter");
    }

    public static void modifyObject(Person p) {
        p.setName("Bob");
    }
}


class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
}