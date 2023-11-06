package java_thread_programming.chapter3.quiz01;

import java_thread_programming.common.RunnableCounter;

public class CounterTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableCounter("runnableCounter",10));
        thread.start();
    }
}
