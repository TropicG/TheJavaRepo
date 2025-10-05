import java.util.ArrayList;
import java.util.List;

public class GenericExample<T> {

    private List<T> storage;

    public GenericExample() {
        storage = new ArrayList<T>();
    }

    public boolean add(T elem) {
        return this.storage.add(elem);
    }

    public T peek() {
        return this.storage.getFirst();
    }

    public boolean pop(T elem) {
        return this.storage.remove(elem);
    }

    public int count() {
        return this.storage.size();
    }
}
