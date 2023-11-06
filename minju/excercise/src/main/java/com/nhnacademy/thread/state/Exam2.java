package com.nhnacademy.thread.state;

import com.nhnacademy.thread.stop.RunnableCounter;

public class Exam2 {
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);
        runnableCounter.start();
        System.out.println(runnableCounter.getThread().getState());
    }
}
