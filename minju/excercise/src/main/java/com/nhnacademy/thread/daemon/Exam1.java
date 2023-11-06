package com.nhnacademy.thread.daemon;

import com.nhnacademy.thread.stop.RunnableCounter;

public class Exam1 {

    public static void main(String[] args) throws InterruptedException {
        RunnableCounter counter1 = new RunnableCounter("counter1", 100);
        RunnableCounter counter2 = new RunnableCounter("counter2", 100);

        counter2.setDaemon(true);

        counter1.start();
        counter2.start();

        Thread.sleep(5000);
        counter1.stop();

        System.out.println("Main Thread terminated");
    }

}