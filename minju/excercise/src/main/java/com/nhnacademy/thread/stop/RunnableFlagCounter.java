package com.nhnacademy.thread.stop;

import java.util.Objects;

public class RunnableFlagCounter implements Runnable {

    private Thread thread;
    private int maxCount;
    private int count = 0;
    private boolean running = true;

    public RunnableFlagCounter(String name, int maxCount) {
        if (Objects.isNull(name)) {
            throw new NullPointerException("name cannot be null");
        }
        this.maxCount = maxCount;
        this.thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running && count < maxCount) {
            System.out.println(thread.getName() + " : " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
