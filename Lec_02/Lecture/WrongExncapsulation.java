class Human {

    //this is public so outside classes can touch it
    public String name;

    public Human(String name) {
        this.name = name;
    }
}


public class WrongEncapsulation{

    public static void main(String[] args) {
        Human ivan = new Human("ivan");

        //direct data member modification, this is not allowed
        ivan.name = "peter";
    }

}