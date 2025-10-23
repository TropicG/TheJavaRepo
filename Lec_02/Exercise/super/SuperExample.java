class Parent {

    private int parrentValue;

    public Parent(int parrentValue){
        this.parrentValue = parrentValue;
    }

    public void displayParrentValue() {
        System.out.println("The parent value is: " + this.parrentValue);
    }
}

class Child extend Parent {

    private int childValue;

    public Child(int childValue, int parrentValue) {

        //calling the public constructor of the parrent
        super(parrentValue);
        this.childValue = childValue;
    }

    public void displayChildAndParentValue() {
        
        //invoking a method from the parent
        super.displayParrentValue();
        System.out.println("The child value is: " + this.childValue);
    }
} 

public class SuperExample {

    public static void main(String[] args) {
        Child child = new Child(10, 34);
        child.displayChildAndParentValue();
    }

}


