package com.nhnacademy.thread.synchronization;

public class Exam {

    public static void main(String[] args) {
        exam1();
    }

    public static void exam1() {
        SharedCount count = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 10000, count);
        SharedCounter counter2 = new SharedCounter("counter2", 10000, count);

        counter1.start();
        counter2.start();

        counter1.join();
        counter2.join();

        System.out.println("sharedCount : " + count.getCount());
    }

}
