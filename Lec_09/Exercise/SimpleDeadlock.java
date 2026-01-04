//Note: trivial Deadlock example
public class SimpleDeadlock {

    public static void main(String[] args) {

        // Image two friends (threads) are in a restaurant, one first puts oil to his salad the other first put vinegar to it
        Object vinegar = new Object();
        Object oil = new Object();

        Thread oilFirstFriend = new Thread(new Runnable() {
            @Override
            public void run() {
                // image that in the restaurant the friend first grabs the oil bottle
                synchronized (oil) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    // after that he returns the bottle and takes the vinegar
                    synchronized (vinegar) {
                        System.out.println("The salad was done by the oil first frined ");
                    }

                }
            }
        });

        Thread vinegarFirstFriend = new Thread(new Runnable() {
            @Override
            public void run() {
                // image that in the restaurant the friend first grabs the vinegar bottle
                synchronized (vinegar) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    // after that he returns the bottle and takes the oil
                    synchronized (oil) {
                        System.out.println("The salad was done by the vinegar first friend");
                    }

                }
            }
        });

        // Deadlock will happen, since the oil friend takes the bottle and the vinegar friend takes the vinegar bottle
        // the oil friend soon will need the vinegar but it is already taken and it wont be returned since the vinegar friend waits for the oitl
        // So a deadlock situation will happen
        oilFirstFriend.start();
        vinegarFirstFriend.start();


    }

}
