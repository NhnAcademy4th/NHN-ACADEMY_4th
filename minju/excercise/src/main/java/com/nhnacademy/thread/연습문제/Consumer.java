package com.nhnacademy.thread.연습문제;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private Store store;
    private String product = "";
    String name;
    private int max = 10;
    private int interval = 10;

    public Consumer(String name, Store store) {
        this.store = store;
        this.name = name;
    }

    public void buy(String product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < max; i++) {
            store.buy(product);
            System.out.println(name + " buy " + product);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(interval));
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
