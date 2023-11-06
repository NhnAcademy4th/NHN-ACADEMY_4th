package Thread.ex01.ex1_5;

import Thread.ex01.common.Counter;
import Thread.ex01.common.CounterThread;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter("Counter");
        CounterThread counterThread = new CounterThread("CounterThread");

        counterThread.start();
        counter.run();
    }
}
