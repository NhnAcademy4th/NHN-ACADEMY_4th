package java_thread_programming.chapter3.exam01;

import java_thread_programming.common.RunnableCounter;

public class ThreadExitTest {
    public static void main(String[] args) {
        RunnableCounter counter = new RunnableCounter("counter",5);
        Thread thread = new Thread(counter);
        thread.start();
    }
}
