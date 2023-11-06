package com.nhnacademy.ex6;

public class SharedCount {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increaseCount() throws InterruptedException {
        setCount(getCount() + 1);
        Thread.sleep(100);
    }
}
