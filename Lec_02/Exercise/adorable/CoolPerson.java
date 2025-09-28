public class CoolPerson implements Adorable{
    
    @Override
    public void like() {
        System.out.println("I am liked!");
    }

    @Override
    public void love() {
        System.out.println("I am loved!");
    }
}