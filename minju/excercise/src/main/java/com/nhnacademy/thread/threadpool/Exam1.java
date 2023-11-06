package com.nhnacademy.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam1 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Worker("Worker" + i));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            
        }
    }

}
