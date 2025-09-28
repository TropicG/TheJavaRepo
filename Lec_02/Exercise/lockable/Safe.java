public class Safe implements Lockable, OldLockable {

    @Override
    public void lock() {
        System.out.println("Safe locked.");
    }

    @Override
    public boolean isLocked() {

        //Again, here we will have a compiler-error if we dont override the isLocked() method with
        // "Safe inherits unrelated defaults for isLocked() from types Lockable and OldLockable"
        return Lockable.super.isLocked();
    }
}