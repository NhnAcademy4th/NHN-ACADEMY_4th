package java_thread_programming.chapter2.quiz02;

import java_thread_programming.common.ThreadCounter;

public class CounterTest {
    public static void main(String[] args) {
        String name = "threadCounter";
        int maxCount = 10;

        ThreadCounter threadCounter = new ThreadCounter(name, maxCount);
        threadCounter.start();
    }
}
