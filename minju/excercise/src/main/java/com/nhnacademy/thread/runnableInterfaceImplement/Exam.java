package com.nhnacademy.thread.runnableInterfaceImplement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exam {
    public static void main(String[] args) {
        try {
            exam2();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void exam1() {
        SelfRunnableCounter counter = new SelfRunnableCounter("counter", 5);

        counter.start();
    }

    public static void exam2() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);

        pool.execute(new RunnableCounter("counter1", 5));
        pool.execute(new RunnableCounter("counter2", 5));

        pool.shutdown();
        System.out.println("Shutdown called");
        while (!pool.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("Not yet finished");
        }
        System.out.println("All service finished");
    }

}
