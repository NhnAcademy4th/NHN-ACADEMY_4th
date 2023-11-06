package java_thread_programming.mart;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private Mart mart;
    private Thread thread;

    public Producer(Mart mart) {
        thread = new Thread(this);
        this.mart = mart;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            int randomInterval = ThreadLocalRandom.current().nextInt(1, 11);
            int storeIndex = ThreadLocalRandom.current().nextInt(0, mart.storesNum());
            try {
                Thread.sleep(randomInterval * 1000L);
                mart.buyInSelectedStore(storeIndex);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}