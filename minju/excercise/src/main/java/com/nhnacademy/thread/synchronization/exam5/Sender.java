package com.nhnacademy.thread.synchronization.exam5;

public class Sender implements Runnable {

    Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] messages = {"apple", "grape", "banana", "End"};
        for (String message : messages) {
            data.send(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
