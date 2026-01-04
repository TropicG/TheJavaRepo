// Note: We assign not so much important tasks to those threads, and they do work in the background
// Note: Typically we can change a thread by set it to daemon using a method
// Note: A thread typically inherits the daemon status from the thread that created it
// Note: Virtual threads are always and remain daemon
// Note: When the last non-daemon thread was completed JVM stops executing all daemon threads
// Note: One daemon thread doesn't depend on the thread that created it, it depends on the life of the whole JVM
// (if no non demon threads are executing, it will stop executing the daemons


public class DaemonThreads {

    public static void main(String[] args) throws InterruptedException {
        BackgroundThread backgroundThread = new BackgroundThread();
        backgroundThread.start();

        System.out.println("Main thread stopped terminating");
    }

}

class BackgroundThread extends Thread {

    public BackgroundThread() {
        // if you comment next line, thread will
        // be non-daemon and will always reach to the end and exit normally
        setDaemon(true);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000; i++) {
            System.out.println(i);
        }
        System.out.printf("%s thread terminates", (isDaemon() ? "Daemon" : "Non-daemon"));
    }

}