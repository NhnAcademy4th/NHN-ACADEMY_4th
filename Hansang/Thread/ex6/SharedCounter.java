package com.nhnacademy.ex6;

public class SharedCounter extends Thread {
    SharedCount sharedCount;
    int count;
    int maxCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        setName(name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                count++;
                sharedCount.increaseCount();
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
