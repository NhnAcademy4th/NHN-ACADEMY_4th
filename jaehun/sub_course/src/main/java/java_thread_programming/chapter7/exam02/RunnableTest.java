package java_thread_programming.chapter7.exam02;

import java_thread_programming.common.RunnableCounter;

public class RunnableTest {
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);
        runnableCounter.start();
        System.out.println(runnableCounter.getThread().getState());
    }
}
