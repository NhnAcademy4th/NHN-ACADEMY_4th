package com.nhnacademy.ex7;

public class Ticker implements Runnable {
    long tickNum;
    int tickIntNum;
    Thread thread;

    public Ticker(long tickNum, int tickIntNum) {
        thread = new Thread(this);
        this.tickNum = tickNum;
        this.tickIntNum = tickIntNum;
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        System.out.println("0ms tick");

        for (int i = 0; i < 10; i++) {
            long beforeTime = System.currentTimeMillis();
            try {
                if (tickIntNum == 0) {
                    Thread.sleep(tickNum);
                } else {
                    Thread.sleep(tickNum, tickIntNum);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime);
            System.out.println(secDiffTime + "ms tick");
        }
    }

    public boolean isAlive() {
        return thread.isAlive();
    }
}
