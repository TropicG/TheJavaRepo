public class JoinExample {

    public static void main(String[] args) {

        // starting the Bomb timer
        TimerBomb timerBomb = new TimerBomb();
        timerBomb.start();

        try {
            // this line of code tells the Main thread to stop execution until timerBomb thread finishes its working
            timerBomb.join();
        } catch (InterruptedException e) {
             throw new RuntimeException(e);
        }

        System.out.println("BOOOOOOOM!!!!");

    }

}

class TimerBomb extends Thread {

    // the thread will loop through all the words and print them out in between 1 second
    private final String[] count = {"five", "four", "three", "two", "one"};

    @Override
    public void run() {
        for (String c : count) {

            System.out.println(c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw  new RuntimeException(e);
            }
        }
    }


}
