public class Project {

    private static final String PROJECT_PREFIX = "proj-";
    private static int totalProjectInstances;

    private String name;

    public Project() {

        //Using the static vairable to cound the total number of instance of this object
        //All of these instances of Project will share the same copy of this static value 

        name = PROJECT_PREFIX + totalProjectInstances++;
    }

    public String getName() {
        return name;
    }

    public static int getTotalProjectInstances() {
        return this.totalProjectInstances;
    }

    // This will not compile because we are trying to access an instance's personal informacion inside a static method
    // Static methods are not bound to any instance, but rather to the class itself
    // The compiler error is going to be "non-static variable name cannot be reference from a static context "

    //public static void printName() {
    //  System.out.println(name);
    //}

}


public static void Main(String... s) {
    System.out.println(new Project().getName());
    System.out.println(new Project().getName());
    System.out.println(enw Project().getName());
}