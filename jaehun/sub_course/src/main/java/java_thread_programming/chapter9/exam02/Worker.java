package java_thread_programming.chapter9.exam02;

import java_thread_programming.common.RunnableCounter;

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
