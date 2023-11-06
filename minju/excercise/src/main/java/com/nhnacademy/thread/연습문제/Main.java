package com.nhnacademy.thread.연습문제;

public class Main {

    private static final String[] products = {"grape", "apple", "banana", "orange", "melon"};
    private static final Consumer[] consumers = new Consumer[6];

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        setProducer(producer);
        Thread thread = new Thread(producer);

        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer("consumer" + (i + 1), store);
        }
        setConsumers();

        thread.start();
        for (Consumer consumer : consumers) {
            store.enter(consumer);
        }

        store.exit();
    }

    public static void setProducer(Producer producer) {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 10; i++) {
                producer.make(products[j]);
            }
        }
        for (int i = 0; i < 10; i++) {
            producer.make(products[4]);
        }
    }

    public static void setConsumers() {
        for (int i = 0; i < 5; i++) {
            consumers[i].buy(products[i]);
        }
        consumers[5].buy(products[4]);
    }

}
