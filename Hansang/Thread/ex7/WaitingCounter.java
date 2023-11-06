package com.nhnacademy.ex7;

import com.nhnacademy.ex5.CounterRunnable;

public class WaitingCounter implements Runnable {
    Thread thread;
    CounterRunnable counter;

    public WaitingCounter(CounterRunnable counter) {
        this.thread = new Thread(this);
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            counter.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Thread getThread() {
        return thread;
    }

    public void start() {
        thread.start();
    }

    public boolean isAlive() {
        return thread.isAlive();
    }
}
