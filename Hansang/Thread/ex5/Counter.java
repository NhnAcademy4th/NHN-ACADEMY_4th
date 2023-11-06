package com.nhnacademy.ex5;

public class Counter {
    String name;
    int count;

    public Counter(String name) {
        this.name = name;
    }

    public void run() {
        count = 1;
        while (!Thread.interrupted()) {
            System.out.println(name + ": " + count);
            if (count == 20) {
                return;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter("Counter1");
        Counter counter2 = new Counter("Counter2");

        counter1.run();
        counter2.run();
    }
}