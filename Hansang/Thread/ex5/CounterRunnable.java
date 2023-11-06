package com.nhnacademy.ex5;

public class CounterRunnable implements Runnable {
    Thread thread;
    int count;
    int maxNum;

    public CounterRunnable(String name, int maxNum) {
        thread = new Thread(this, name);
        this.maxNum = maxNum;
    }

    @Override
    public void run() {
        count = 0;
        while (count < maxNum) {
            try {
                ++count;
                System.out.println(thread.getName() + " : " + count);
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    public void start() {
        thread.start();
    }
}
