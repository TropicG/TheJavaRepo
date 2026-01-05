package threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

    // the number of "workers" that will be working at the same time
    private static final int MAX_THREADS = 3;
    // the number of tasks that needs to be completed with the help of the "workers"
    private static final int MAX_JOBS = 15;

    // A fixed thread pool contains a specified number of threads, if all the threads are busy and additional tasks are submitted
    // they will wain in the quee until a thread is available

    public static void main(String[] args) {

        // creating the ThreadPool only with the number of the "workers", only currently 3 workers could be working at the same time
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        // The thread pool makes a thread to not die after executing a block of code but to stay alive and pick up another job
        // This prevents creation of a new Thread that will be resource consuming for the OS
        for (int i = 0; i < MAX_JOBS; i++) {
            // here a task is created to be executed by one of the threads in the thread pool
            Runnable r = new Task("" + i);
            // giving the task to the executor
            executorService.execute(r);

            // Note: This all thread pool given to a queue is Thread-Safe, it means that no two thread will check the task with id #4
        }

        // stopping the executors so it won't take any more tasks, it won't stop immediately but in a short time
        // Upon shutting down the executor it will complete any existing ones
        executorService.shutdown();
    }

}
