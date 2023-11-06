package Thread.ex01.ex1_4;

import Thread.ex01.common.CounterThread;

public class TestCounter {
    public static void main(String[] args) {
        CounterThread counterThread1 = new CounterThread("CounterThread1");
        CounterThread counterThread2 = new CounterThread("CounterThread2");

        counterThread1.start();
        counterThread2.start();
    }
}
