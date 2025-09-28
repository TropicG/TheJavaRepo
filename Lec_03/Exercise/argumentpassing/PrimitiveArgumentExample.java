public class PrimitiveArgumentExample{

    public static void main(String... args) {
        int x = 10;
        System.out.println("Beofore modifyPrimitive " + x);

        modifyPrimitive(x);

        System.out.println("After modifyPrimitive " + x);
    }

    //the value of x is passed by value as an argument meaning that changes in this method are not going to be reflected
    public static void modifyPrimitive(int number) {
        number = 20;
        System.out.println("Inside method: " + number);
    }
}