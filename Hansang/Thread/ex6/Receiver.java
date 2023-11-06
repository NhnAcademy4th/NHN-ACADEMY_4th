package com.nhnacademy.ex6;

public class Receiver extends Thread {
    final Data data;

    public Receiver(String name, Data data) {
        setName(name);
        this.data = data;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        synchronized (data) {
            data.receive();
        }
    }

}
