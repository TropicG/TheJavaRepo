package threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

    // A cached thread pool will reuse available threads, but if all threads are busy and more tasks are submitted
    // then will create new threads

    // Here there isn't a queue like in FixedThreadPool, if all the created threads are busy JVM will create even new threads to finish the job

    // If a thread is idle for 60s it will be decommissioned
    private static final int TOTAL_JOBS = 30;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < TOTAL_JOBS; i++) {
            Runnable job = new Task("" + i);
            executorService.execute(job);
        }

        // stopping the executors so it won't take any more tasks, it won't stop immediately but in a short time
        // Upon shutting down the executor it will complete any existing ones
        executorService.shutdown();
    }
}
