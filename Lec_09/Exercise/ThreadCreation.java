import java.util.concurrent.ThreadFactory;
import java.util.random.RandomGenerator;

public class ThreadCreation {

    public static void main(String[] args) {
        startThreadsClassic();
        startThreadsJava21Style();
    }

    private static void startThreadsClassic() {

        // Method #1: Creating a class that inherits Thread and overwrites run method
        // Note: In order to execute the code in the Thread start() method shall be called
        // Note: If you just execute run method the code will execute in the same thread (there wont be created an aditional thread)
        CustomThread customThread = new CustomThread("Hello from Method #1 for creating a Thread");
        customThread.start();

        // Method #2: Creating a Thread object and passing to its constructor class that implements Runnable interface and the name of the Thread
        // Note: Again in order to create the thread and execute the code start() shall be called, not directly run() (it will execute in the same thread)
        Thread customThread2 = new Thread(new CustomRunnable(),"Custom Thread #2");
        customThread2.start();

        // Method #3: Creating a Thread object and creating an anonymous class to overwrite run method
        // Note: Again in order to create the thread and execute the code start() shall be called, not directly run() (it will execute in the same thread)
        Thread customThread3 = new Thread("Custom Thread #3") {
            @Override
            public void run() {
                System.out.println("Hello world from Custom Thread #3");
            }
        };
        customThread3.start();

        // Method #4: Creating a Thread object with a lambda function
        // Note: Again in order to create the thread and execute the code start() shall be called, not directly run() (it will execute in the same thread)
        Thread customThread4 = new Thread(() -> System.out.println("Hello world from custom thread #4"), "Custom Thread #4");
        customThread4.start();

        // Important Note: All of those created thread here as platforms
    }

    private static void startThreadsJava21Style() {
        // Using the static ofPlatform() method to create a platform thread an immidiately to run it
        Thread platformThread1 = Thread.ofPlatform().start(() -> System.out.println("Hello from ofPlatform() functiom"));
        // We can set different attributes to the thread
        platformThread1.setName("Thread ofPlatform");
        // Note: Good design won't require to set the priority levels to a thread
        // What a priority of a thread means is that the OS will just give more attention to it
        platformThread1.setPriority(7);

        // Creating VirtualThread #1, using the ofVirtual() static method to create it and immidiatelly to start it
        // Note: You can pass a class that implements Runnable
        Thread virtualThread1 = Thread.ofVirtual().start(new CustomRunnable());

        // Creating VirtualThread #1, using the startVirtualThread() static method to create it and immidiatelly to start it
        // Note: It is not needed to always pass a lambda function, it expects a parameter of type Runnable
        Thread virtualThread2 = Thread.startVirtualThread(() ->
                System.out.println("Hello World from the second created virtual thread"));
    }

}



// We can extends Thread class but is mandatory to overwrite run() since Thread implements Runnable
class CustomThread extends Thread {
    private String name;

    public CustomThread(String name) {
        this.name = name;
    }

    // This is the function that is going to be executed by the thread
    @Override
    public void run() {
        try{
            // There are multiple reason why one thread can be interrupted
            // 1. JVM 2. OS 3. Another thread can interrupt this one
            Thread.sleep(RandomGenerator.getDefault().nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello world from " + name);
    }
}

// We can also implement Runnable directly, this way is more flexible than extending Thread
class CustomRunnable implements Runnable {
    // Note: This function is going to be run by the thread
    // Note: If we want to execute this function, this class shall be given as an argument to Thread class
    @Override
    public void run() {
        System.out.println("Hello from a Runnable");
    }
}