package com.nhnacademy.thread.과제;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private Store[] stores;
    private Thread thread;

    private int interval = 10000;

    public Producer(Store... stores) {
        this.stores = stores;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10000) {
            int visit = ThreadLocalRandom.current().nextInt(stores.length);
            int time = ThreadLocalRandom.current().nextInt(100, interval);
            try {
                stores[visit].sell();
                thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            count++;
        }
    }
}


