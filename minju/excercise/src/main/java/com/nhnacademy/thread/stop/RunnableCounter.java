package com.nhnacademy.thread.stop;

import java.util.Objects;

public class RunnableCounter implements Runnable {

    int maxCount;
    int count = 0;
    Thread thread;

    public RunnableCounter(String name, int maxCount) {
        if (Objects.isNull(name)) {
            throw new NullPointerException("name cannot be null");
        }
        this.maxCount = maxCount;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public Thread getThread() {
        return thread;
    }

    public void interrupt() {
        thread.interrupt();
    }

    public void setDaemon(boolean on) {
        thread.setDaemon(on);
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException ignore) {

        }
    }

    @Override
    public void run() {
        while (count < maxCount) {
            System.out.println(thread.getName() + " : " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
