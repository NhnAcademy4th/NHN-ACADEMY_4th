package com.nhnacademy.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Store {

    private List<Item> stall = new ArrayList<>();
    private int restrictions;
    private int peopleNum;
    private Semaphore semaphore;

    public Store() {
        peopleNum = 0;
        semaphore = new Semaphore(5);
        this.restrictions = 0;
    }

    public void enter() throws InterruptedException {
        peopleNum++;
        semaphore.acquire();
        System.out.println("customer entered!");
    }

    public void exit() {
        peopleNum--;
        semaphore.release();
        System.out.println("customer exit");
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public synchronized void buy() {
        while (restrictions == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        Randomizer random = new Randomizer();
        int index = (random.getRandomBound(0, 9));
        Item buyItem = stall.get(index);
        System.out.println(buyItem.getItemName() + "sold");
        stall.remove(index);
        notifyAll();
    }

    public synchronized void sell() {
        while (restrictions == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        if (restrictions != 0) {
            return;
        }

        stall.add(Producer.getItem());
        notifyAll();
    }

}
