package threadpools;

public class Task implements Runnable {

    private String id;

    public Task(String id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Starting thread #" + id + " and the thread's name is " + Thread.currentThread().getName());

        try{
            Thread.sleep(3_000); // 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
