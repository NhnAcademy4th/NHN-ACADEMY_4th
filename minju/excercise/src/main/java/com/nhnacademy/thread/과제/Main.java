package com.nhnacademy.thread.과제;

public class Main {
    public static void main(String[] args) {
        Store[] stores = {new Store("fruit"),
                new Store("meat"),
                new Store("food"),
                new Store("snack"),
                new Store("bread")
        };

        Producer producer = new Producer(stores);

        Consumer[] consumers = new Consumer[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer("손님" + (i + 1), stores);
        }

        producer.start();
        for (Consumer consumer : consumers) {
            consumer.start();
        }
    }
}
