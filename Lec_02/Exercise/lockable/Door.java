
public class Door implements Lockable, OldLockable {

    @Override
    public void lock() {
        System.out.println("Door locked.");
    }


    //Lockable and OldLocable interfaces have the same method locked, it is mandatory to redefine the metod here you can continue
    //with the implementation from Lockable or OldLockable
    @Override
    public boolean isLocked() {
        return true;
    }
}