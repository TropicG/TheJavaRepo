public class ExampleClassWithMethod {

    public static double sumRec(int n) {

        if(n == 0) return 1.0;

        return 1.0 / Math.pow(2,n) + sumRec(n - 1);

    }
}