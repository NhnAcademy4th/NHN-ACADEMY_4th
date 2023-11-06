package com.nhnacademy.thread.연습문제;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private Store store;
    private List<String> products;

    private int interval = 10;

    public Producer(Store store) {
        this.store = store;
        products = new ArrayList<>();
    }

    public void make(String product) {
        products.add(product);
    }

    @Override
    public void run() {
        for (String product : products) {
            store.sell(product);
            System.out.println("sell " + product);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(interval));
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }

}
