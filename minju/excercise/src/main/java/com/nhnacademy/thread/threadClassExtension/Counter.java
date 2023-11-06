package com.nhnacademy.thread.threadClassExtension;

import java.util.Objects;

public class Counter {

    private String name;
    private int count;
    private int maxCount;

    public Counter(String name, int maxCount) {
        if (Objects.isNull(name)) {
            throw new NullPointerException("name cannot be null");
        }
        this.name = name;
        count = 0;
        this.maxCount = maxCount;
    }

    public void run() {
        while (count < maxCount) {
            System.out.print(name + " : ");
            System.out.println(++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
