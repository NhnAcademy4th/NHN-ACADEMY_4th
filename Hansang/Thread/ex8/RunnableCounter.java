package com.nhnacademy.ex8;

public class RunnableCounter implements Runnable {

    int count;
    int MaxCount;
    Thread thread;

    public RunnableCounter(ThreadGroup group, String name, int maxCount) {
        this.thread = new Thread(group, this, name);
        MaxCount = maxCount;
    }

    public RunnableCounter(String name, int maxCount) {
        MaxCount = maxCount;
        this.thread = new Thread(this, name);
    }

    @Override
    public void run() {
        count = 0;
        while (count < MaxCount) {
            count++;
            System.out.println(thread.getName() + " : " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void start() {
        thread.start();
    }

    public void setDaemon(boolean val) {
        thread.setDaemon(val);
    }

    public void stop() {
        thread.interrupt();
    }
}
