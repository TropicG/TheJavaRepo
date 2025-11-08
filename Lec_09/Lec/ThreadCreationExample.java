// Option 1: extending java.lang.Thread

// since it extends Thread class it means that CustomThread is a thread
public class CustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}

Thread CustomThread = new CustomThread();

// Option 2: implementing java.lang.Runnable

// This class is not a Thread since it only delives the task that can be executed by a thread
public class CustomRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello world, from a Runnable");
    }
}

//first we create an object CustomRunnable after that it is passed as an argument for Thread object
Thread customThread = new Thread(new CustomRunnable());


// Option 3: Anonymous class
Thread customThread3 = new Thread() {
    @Override
    public void run() {
        System.out.println("Hello World, from anonymous class");
    }
}


// Option 4: With lambda expression
Thread customThread4 = new Thread(() -> System.out.println("Hello World, from lambda");


// Option 5: With of static method
Runnable runnable = () -> {};
Thread platformThread1 = Thread.ofPlatform().start(runnable); // This tells Java create me a platform thread and runs the runnable 
Thread virtualThread2 = Thread.ofVirtual().start(runnable); // This tells Java create me a virtual thread and run the runnable

// Option 6: With static method and lambda
Thread virtualThread2 = Thread.startVirtualThread( () - > {}); // creates a virtual thread and starts it 
