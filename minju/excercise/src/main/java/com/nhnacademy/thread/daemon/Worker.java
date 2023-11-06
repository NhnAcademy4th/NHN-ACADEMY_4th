package com.nhnacademy.thread.daemon;

import com.nhnacademy.thread.stop.RunnableCounter;

public class Worker implements Runnable {

    Thread thread;

    RunnableCounter counter;
    RunnableCounter internal;
    int maxCount;

    public Worker(String name, int maxCount) {
        counter = new RunnableCounter(name, maxCount);
        internal = new RunnableCounter("Internal Worker", maxCount);
        internal.setDaemon(true);
        thread = new Thread(this, "worker");
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        counter.interrupt();
    }


    @Override
    public void run() {
        counter.start();
        internal.start();
    }

}
