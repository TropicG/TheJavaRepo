class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

class BoxOfInt extends Box<Integer> {
    private Integer value;

    @Override
    public void setValue(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}

public class BridgeMethods {

    public static void main(String... args) {
        Box<Integer> boxOfInt = new BoxOfInt();
        boxOfInt.setValue(1);
        System.out.println(boxOfInt.getValue());
    }
}
