package com.nhnacademy.thread.runnableInterfaceImplement;

public class SelfRunnableCounter implements Runnable {
    int count = 0;
    int maxCount;
    Thread thread;

    public SelfRunnableCounter(String name, int maxCount) {
        this.maxCount = maxCount;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (count < maxCount) {
            System.out.println(thread.getName() + " : " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
