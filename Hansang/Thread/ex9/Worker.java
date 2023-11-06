package com.nhnacademy.ex9;

import com.nhnacademy.ex8.RunnableCounter;

public class Worker extends RunnableCounter {
    RunnableCounter runnableCounter;

    public Worker(String name, int maxCount) {
        super(name, maxCount);
        runnableCounter = new RunnableCounter("internal worker", maxCount);
        runnableCounter.setDaemon(true);
    }

    @Override
    public void run() {
        runnableCounter.start();
        super.run();
    }
}
