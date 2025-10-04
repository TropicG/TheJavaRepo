class Human {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}


public class WrongEncapsulation{

    public static void main(String[] args) {

        Human ivan = new Human("ivan");

        //Using this line will result in an error since it is private: ivan.name = "Peter"

        //the only way to access the name is through the getter
        System.out.println(ivan.getName());
    }

}