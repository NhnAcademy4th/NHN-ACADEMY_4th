package com.nhnacademy.ex5;

public class CounterThread extends Thread {
    String name;
    int count;

    public CounterThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        count = 1;
        while (!Thread.interrupted()) {
            System.out.println(name + " : " + count);
            if (count == 20) {
                return;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        CounterThread counterThread1 = new CounterThread("CounterThread1");
        CounterThread counterThread2 = new CounterThread("CounterThread2");

        counterThread1.start();
        counterThread2.start();
    }
}

