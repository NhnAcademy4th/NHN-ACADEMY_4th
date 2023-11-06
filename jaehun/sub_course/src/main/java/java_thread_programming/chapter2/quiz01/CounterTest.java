package java_thread_programming.chapter2.quiz01;

import java_thread_programming.common.Counter;

public class CounterTest {
    public static void main(String[] args) {
        String name = "counter";
        int maxCounter = 10;

        Counter counter = new Counter(name, maxCounter);
        counter.run();
    }
}
