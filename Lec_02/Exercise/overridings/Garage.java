public class Garage {

    public Garage() {
        System.out.println("Garage constructed");
    }

    protected Car repair(Car c) {
        return new Car();
    }

    public Car repair(Car c, String customerName) {


        //This is a overloaded method, the signature (name and parameter list) shall be the same
        //for the modifier and for the return type it doesnt matter 
        return this.repair(C); // you dont even need this here 
    }

}