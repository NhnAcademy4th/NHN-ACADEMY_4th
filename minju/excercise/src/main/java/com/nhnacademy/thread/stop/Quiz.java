package com.nhnacademy.thread.stop;

public class Quiz {
    public static void main(String[] args) {
        quiz2();
    }

    public static void quiz1() {
        RunnableFlagCounter counter = new RunnableFlagCounter("Counter", 100);
        counter.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        counter.stop();
    }

    public static void quiz2() {
        RunnableCounter counter = new RunnableCounter("Counter", 100);
        counter.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        counter.stop();
    }

}
