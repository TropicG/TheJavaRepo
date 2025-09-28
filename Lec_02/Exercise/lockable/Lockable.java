public interface Lockable {

    void lock();

    default boolean isLocked() {
        return false;
    }


    //Interface's static methods belongs to the interface in general, not to the class that implemented it
    static Lockable getInstance(boolean isDoor) {

        if(isDoor) {
            return new Door();
        }
        else {
            return new Safe();
        }

    }
}