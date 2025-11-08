// The longer variant
public void doSomeWork() {
    synchronized(this) {
        // Only one thread can execute the code in this critical section, the key is the current instance of the object
    }
}

// Option 2: The shorted variant
public synchronized void doSomeWork() {
    // this is the critical section it executes the code and the current lock is this
}