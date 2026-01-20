package creational.singleton;

public class SingletonObject {
    private static final SingletonObject singletonObject = new SingletonObject();

    private SingletonObject() {}

    public static SingletonObject getInstance() {
        return singletonObject;
    }
}
