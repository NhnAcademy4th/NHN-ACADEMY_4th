package com.nhnacademy.Assignment;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PopUp popUp = new PopUp(10);
        Thread producer = new Thread(new Producer(popUp));

        producer.start();

        while (true) {
            Customer customer = new Customer(popUp);
            customer.start();
            Thread.sleep(2000);
        }
    }
}
