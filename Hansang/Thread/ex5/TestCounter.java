package com.nhnacademy.ex5;

public class TestCounter {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new CounterRunnable("runnableCounter1", 10));
        Thread thread2 = new Thread(new CounterRunnable("runnableCounter2", 10));

        thread1.start();
        thread2.start();
        thread1.interrupt();

    }
}
