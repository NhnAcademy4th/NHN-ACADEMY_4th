package com.nhnacademy.thread.state.Quiz2;

import com.nhnacademy.thread.stop.RunnableCounter;

public class Quiz {

    public static void main(String[] args) {
        RunnableCounter counter1 = new RunnableCounter("counter1", 3);
        RunnableCounter counter2 = new RunnableCounter("counter2", 3);

        counter1.start();
        counter2.start();

        counter1.join();
        System.out.println("counter1 stopped");

        counter2.join();
        System.out.println("counter2 stopped");

        System.out.println("All threads stopped");
    }

}
