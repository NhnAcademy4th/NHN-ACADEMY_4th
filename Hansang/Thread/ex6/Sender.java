package com.nhnacademy.ex6;

import java.util.concurrent.ThreadLocalRandom;

public class Sender extends Thread {
    Data data;
    String[] stringData;


    public Sender(String name, Data data, String[] stringData) {
        setName(name);
        this.data = data;
        this.stringData = stringData;
    }

    @Override
    public void run() {
        data.send(stringData);


        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            System.out.println("waiting!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("close!");

    }
}
