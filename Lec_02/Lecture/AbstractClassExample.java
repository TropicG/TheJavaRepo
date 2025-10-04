public abstract class Cat {

    public void move() {
        System.out.println("I am walking on 4 toes.");
    }

    public void communicate() {
        System.out.println("I am communicating");
    }

    public abstract void eat();
}


public class DomesticCat extends Cat {

    //take a good look here, since eat is an abstract method in Cat, it is mandatory
    //to be implemented in the class that is inheriting it 
    public void eat() {
        System.out.println("I am eating");
    }
}