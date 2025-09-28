public class DefaultInterfaceExample {
    public static void main(String... args) {
        Door door = new Door();
        Lockable anotherDoor = new Door();
        Lockable safe = new Safe();

        anotherDorr.lock() // The output is "Door is locked", calls the Door method implemented because of the interface
        System.out.println(safe.isLocked()); // calls the isLocked method and the output is false 
        System.out.println(door.isLocked()); // checks the overriden method and returns true 


        Obj obj = new Safe();
        Lockable lockable = Lockable.getInstance(true); // wil return new Door

        //classic instanceof: explicit cast is needed in the if body
        if(obj instanceof Lockable) {
            ((Lockable) obj).lock();
        }

        //Since java 17 we have pattern matching for instanceof
        if(lockable instanceof Door d) {
            d.lock();
        }
    }
}