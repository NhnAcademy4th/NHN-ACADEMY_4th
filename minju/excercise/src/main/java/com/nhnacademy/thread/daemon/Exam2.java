package com.nhnacademy.thread.daemon;

public class Exam2 {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker("worker1", 100);

        worker.start();

        Thread.sleep(5000);
        worker.stop();

        System.out.println("Main Thread terminated");
    }
}
