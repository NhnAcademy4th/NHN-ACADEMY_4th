package com.nhnacademy.thread.runnableInterfaceImplement;

import java.util.Objects;

public class RunnableCounter implements Runnable {

    private String name;
    private int maxCount;
    private int count = 0;

    public RunnableCounter(String name, int maxCount) {
        if (Objects.isNull(name)) {
            throw new NullPointerException("name cannot be null");
        }
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            System.out.println(name + " : " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
