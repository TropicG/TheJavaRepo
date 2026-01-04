import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    public static void main(String[] args) throws InterruptedException {

        // original atomic integer class from java.util.concurrent
        AtomicInteger atomicInt = new AtomicInteger();
        // custom created class that is not thread-safe
        NonAtomicInteger nonAtomicInteger = new NonAtomicInteger();

        // threads will execute this line of code
        Runnable r = () -> {
            for(int i = 0; i < 100_000; i++ ){
                // this is a special function that has a specific CPU instruction so that this value can be changed safely
                // regarding the race condition
                atomicInt.getAndIncrement();
                nonAtomicInteger.getAndIncrement();
            }
        };

        // creating the new threads
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);

        // starting the new threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // The Main thread will wait for all the threads to complete
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.printf("The atomic integer should be 400000, it is %d%n", atomicInt.get());
        System.out.printf("The non-atomic integer should be 400000, it is %d%n", nonAtomicInteger.get());

    }

    // since this is not thread safe the value of i will change significantly because of the race conditions
    public static class NonAtomicInteger {
        private int i;

        public NonAtomicInteger() {
            i = 0;
        }

        // multiple threads will execute this function in unpredictable way and the value of i will not be the same always
        // in order to fix this make this function synchronized: public synchronized int getAndIncrement()
        // this will ensure the function to track proper value of i
        public int getAndIncrement() {
            return i++;
        }

        public int get() {
            return i;
        }
    }
}

