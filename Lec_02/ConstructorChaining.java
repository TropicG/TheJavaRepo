public class ConstructorChaining {

    private String name;

    public ConstructorChaining() {
        this("Unknown");
    }

    public ConstructorChaining(String name) {
        this.name = name;
    }
}