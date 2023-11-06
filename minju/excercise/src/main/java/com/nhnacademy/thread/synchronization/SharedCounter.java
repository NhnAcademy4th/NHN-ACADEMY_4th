package com.nhnacademy.thread.synchronization;

public class SharedCounter implements Runnable {

    Thread thread;
    int maxCount;

    int count = 0;
    SharedCount sharedCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        thread = new Thread(this, name);
    }

    public void start() {
        System.out.println(thread.getName() + ": started");
        thread.start();
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            thread.currentThread().interrupt();
        }
    }

    public Thread getThread() {
        return this.thread;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            count++;
            sharedCount.increment();
        }
        System.out.println(thread.getName() + ": terminated");
    }
}
