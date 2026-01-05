package threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {


    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(10);

        // this thread will start after 5 seconds
        scheduledService.schedule(() -> System.out.println("Delayed task executed after 5 seconds"), 5, TimeUnit.SECONDS);

        // the given code for execution will be repeated at fixed rate
        // The interval is based on the scheduled start time of each execution, maintaining a strict execution schedule
        // which may lead to task overlap if execution time exceeds the scheduled rate.
        scheduledService.scheduleAtFixedRate(() -> {
            doSomeWork(2000);
            System.out.println("Some regular task executed at fixed rate by " + Thread.currentThread().getName());
            }, 0, 1, TimeUnit.SECONDS);

        // Schedule a task to repeat with a fixed delay based on the actual completion time of the previous execution,
        // providing buffer time if the task takes longer, preventing task overlap.
        scheduledService.scheduleWithFixedDelay(() -> {
            doSomeWork(2_000);
            System.out.println("Some regular task executed with fixed delay by " + Thread.currentThread().getName());
        }, 0, 1, TimeUnit.SECONDS);

        // Shut down the scheduler after some delay to allow time for tasks to execute.
        scheduledService.schedule(() -> scheduledService.shutdown(), 20, TimeUnit.SECONDS);

    }

    private static void doSomeWork(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
