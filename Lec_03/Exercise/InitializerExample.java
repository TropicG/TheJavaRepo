class InitializerDemoBase {

    private int x;
    private static int y;

    // this is called even before the constructor when we initialize an object
    { // this cannot be static since it is accesing the object's data member
        this.x = 1;
        System.out.println("Parent static initializer executed");
    }

    //this is the static initializer that is called the first time we USE this class, dont confuse it with creating an object
    static {
        InitializerDemoBase.y = 1;
        System.out.println("Parent static initializer executed")
    }

    //this is called after the non-static initializer
    public InitializersDemoBase() {
        System.out.println("Parent constructor executed");
    }
}

public class InitialzerDemo extends InitializersDemoBase {

    private int a;
    private static int b;

    // this initializer will be called before the Child constuctor, after the non-static inializer and constructor in the parent
    {
        a = 5;
        System.out.println("Child initilzer 1 executed");
    }

    //the static initializer will be called when the parent's static initializer has been initialized
    static {
        b = 7;
        System.out.println("Child static initializer executed");
    }

    public InitilizerDemo() {
        a = 10;
        b = 10;
    }

    // since this is the second non-static initializer this is going to be called afther the first one in this class
    // the order of their calls depends on the order of their declaration starting from the top to bottom
    {
        a = 16;
        System.out.println("Child non-static initializer executed")
    }
}