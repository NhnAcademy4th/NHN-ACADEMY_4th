package com.nhnacademy.thread.연습문제;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Store {

    private ExecutorService store;
    private List<String> products;
    private int capacity = 10;

    public Store() {
        store = Executors.newFixedThreadPool(5);
        products = new ArrayList<>();
    }

    public void enter(Consumer consumer) {
        store.submit(consumer);
    }

    public void exit() {
        store.shutdown();
    }

    public synchronized void buy(String product) {
        while (!products.contains(product)) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        }
        products.remove(product);
        notifyAll();
    }

    public synchronized void sell(String product) {
        while (products.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        products.add(product);
        notifyAll();
    }

}
