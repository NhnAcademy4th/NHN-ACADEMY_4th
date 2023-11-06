package com.nhnacademy.thread.과제;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    private Store[] stores;
    private Thread thread;

    private static int interval = 10000;

    public Consumer(String name, Store... stores) {
        this.stores = stores;
        this.thread = new Thread(this, name);

    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 100) {
            try {
                int visit = ThreadLocalRandom.current().nextInt(stores.length);
                stores[visit].buy();
                int time = ThreadLocalRandom.current().nextInt(100, interval);
                thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            count++;
        }
    }
}
