class Parent {

    void display() {
        System.out.println("Non-static method in Parent");
    }

    static void staticDisplay() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {

    @Override 
    void display() {
        System.out.println("Non-static method in Child");
    }

    static void staticDisplay() {
        System.out.println("Static method in Child (Hiden)");
    }
}


public class MethodHiddingExample {

    public static void main(String... args) {

        Parent parent = new Parent();
        Parent childAsParent = new Child();
        Child child = new Child();

        parent.display(); // The output is: "Non-static method in Parent"
        childAsParent.display(); // The output is: "Non-static method in Child"
        
        parent.staticDisplay(); // The output is: "Static method in Parent"
        childAsParent.staticDisplay(); // The output is: "Static method in Parent", because the reference type is Parent
        child.staticDisplay(); // The output is: "Static method in Child", because the reference type is Child

        //IMPORTANT: Static methods belong to the class and no overriding is possible
        //It is possible to redefine the same method in Child, but this is not overriding

    }

}