
public class AudiGarage extends Garage {

    public AudiGarage() {

        //The compiler is going to invoke the default constructor for Garage prior to this one
        // Calliing it explicitly with super() here will have the same effect

        System.out.println("Audi garage constructed");
    }

    //Overriding the method from Garage
    // Access modifier is changed from protected to public, if it was set to private here it wont compile
    // Covariant return type: the overriden method returns Car
    // The signature remains the same, otherwise this wont compile wit the annotation @Override

    @Override 
    public Audi repair(Car c){
        return new Audi();
    }

}