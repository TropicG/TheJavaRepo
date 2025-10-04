interface Drivable {

    //this is public static final
    int MAX_SPEED = 200;

    //methods that are only declared
    void startEngine();
    void accelerate(int amount);
    void brake();
}

class Car implements Drivable {

    private int currentSpeed = 0;


    //defining the methods from the interface, it is mandatory to do that when implementing
    @Override
    public void startEngine(){
        System.out.println("Engine is starting");
    }

    @Override
    public void accelerate(int amount){
        this.currentSpeed += amount;
        System.out.println("Accelerating, current speed: " + this.currentSpeed);
    }

    @Override
    public void brake(){
        this.currentSpeed = 0;
        System.out.println("Braking");
    }

}