package com.nhnacademy.ex7;

import com.nhnacademy.ex5.CounterRunnable;

public class Ex4 {
    public static void main(String[] args) {
        CounterRunnable counter = new CounterRunnable("counter", 10);

        WaitingCounter waitingCounter = new WaitingCounter(counter);

        counter.start();
        waitingCounter.start();

        Thread.State state = waitingCounter.getThread().getState();
        System.out.println(state);

        while (waitingCounter.isAlive()) {
            if (state != waitingCounter.getThread().getState()) {
                state = waitingCounter.getThread().getState();
                System.out.println(state);
            }
        }


    }
}
