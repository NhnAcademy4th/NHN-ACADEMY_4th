package com.nhnacademy.thread.threadClassExtension;

public class ThreadCounter extends Thread {

    private int count;
    private int maxCount;

    public ThreadCounter(String name, int maxCount) {
        setName(name);
        this.count = 0;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            System.out.println(getName() + " : " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
