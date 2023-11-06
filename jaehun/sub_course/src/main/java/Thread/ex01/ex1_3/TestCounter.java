package Thread.ex01.ex1_3;

import Thread.ex01.common.CounterThread;

public class TestCounter {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread("CounterThread");

        counterThread.start();
    }
}
