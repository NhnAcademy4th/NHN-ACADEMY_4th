package java_thread_programming.mart;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    Mart mart;
    Thread thread;

    public Consumer(String name, Mart mart) {
        thread = new Thread(this, name);
        this.mart = mart;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        int randomInterval = ThreadLocalRandom.current().nextInt(1, 11);
        int storeIndex = ThreadLocalRandom.current().nextInt(0, mart.storesNum());
        try {
            mart.enterStore(storeIndex);
            mart.sellInSelectedStore(storeIndex);
            mart.exitStore(storeIndex);
            Thread.sleep(randomInterval * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}