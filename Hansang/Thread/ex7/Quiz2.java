package com.nhnacademy.ex7;

import com.nhnacademy.ex5.CounterRunnable;

public class Quiz2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CounterRunnable("counter1", 10));
        Thread thread2 = new Thread(new CounterRunnable("counter2", 10));

        thread1.start();
        thread2.start();

        while (true) {
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException ignore) {
            }
            if (thread1.getState() == Thread.State.TERMINATED) {
                System.out.println("counter1 stopped");
            }
            if (thread2.getState() == Thread.State.TERMINATED) {
                System.out.println("counter2 stopped");
            }
            if (thread1.getState() == Thread.State.TERMINATED && thread2.getState() == Thread.State.TERMINATED) {
                System.out.println("ALL threads stopped!");
                return;
            }
        }

    }
}
