package com.nhnacademy.thread.synchronization.exam5;

public class Data {

    String packet;
    boolean transmittable = true;

    public synchronized String receive() {
        while (transmittable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        transmittable = true;
        String message = packet;
        notifyAll();
        return message;
    }

    public synchronized void send(String message) {
        while (!transmittable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        transmittable = false;
        this.packet = message;
        notifyAll();
    }
}
