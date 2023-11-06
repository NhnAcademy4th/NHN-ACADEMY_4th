package com.nhnacademy.thread.과제;

import java.util.concurrent.Semaphore;

public class Store {

    private static int MAX_CONSUMER = 5;
    private static int CAPACITY = 10;

    private Semaphore semaphore;
    private String name;
    private int stock;

    public Store(String name) {
        stock = 0;
        semaphore = new Semaphore(MAX_CONSUMER, true);
        this.name = name;
    }

    public void enter() throws InterruptedException {
        semaphore.acquire();
    }

    public void exit() {
        semaphore.release();
    }

    public void buy() throws InterruptedException {
        enter();
        if (stock > 0) {
            System.out.println(Thread.currentThread().getName() + "이(가) " + name + "을 구매하였습니다.");
            stock--;
            System.out.println("남은 수량 : " + stock);
            System.out.println();
        }
        exit();
    }

    public void sell() throws InterruptedException {
        enter();
        if (stock < CAPACITY) {
            System.out.println(name + " : 상품이 입고되었습니다.");
            stock++;
            System.out.println("남은 수량 : " + stock);
            System.out.println();
        }
        exit();
    }

}