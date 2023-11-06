package com.nhnacademy.ex7;

import com.nhnacademy.ex5.CounterRunnable;

public class Ex2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new CounterRunnable("counter1", 10));

        thread.start();
        System.out.println(thread.getState());
    }
}
