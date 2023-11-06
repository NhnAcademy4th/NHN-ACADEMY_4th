package com.nhnacademy.ex8;

public class Worker implements Runnable {
    String message;

    public Worker(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message + " activate!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(message + " deactivate!");
    }
}
