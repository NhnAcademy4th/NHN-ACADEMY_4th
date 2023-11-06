package com.nhnacademy.thread.state;

import com.nhnacademy.thread.stop.RunnableCounter;

public class WaitingCounter implements Runnable {

    RunnableCounter counter;
    Thread thread;

    public WaitingCounter(RunnableCounter counter) {
        this.counter = counter;
        thread = new Thread(this);
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

    @Override
    public void run() {
        counter.join();
    }

}
