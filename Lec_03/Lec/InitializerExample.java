public class InitializerExample{

    private int a;
    private static int b;

    static {

        //static initializer block
        b = 10;
    }

    {

        // initiazer block 
        a = 5;

    }


}