package com.nhnacademy.thread.synchronization.exam5;

public class Receiver implements Runnable {

    Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String message;
        while (!(message = data.receive()).equals("End")) {
            System.out.println(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
