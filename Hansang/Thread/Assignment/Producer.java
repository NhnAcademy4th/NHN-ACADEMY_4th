package com.nhnacademy.Assignment;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {
    private static Randomizer random = new Randomizer();
    private PopUp popUp;
    Thread thread;
    private static List<Item> itemList = new ArrayList<>();

    public Producer(PopUp popUp) {
        prepareItem();
        thread = new Thread(this);
        this.popUp = popUp;
    }

    public void prepareItem() {
        itemList.add(new Item("연필", 1000));
        itemList.add(new Item("가방", 50000));
        itemList.add(new Item("지갑", 5000));
        itemList.add(new Item("샤프", 1500));
        itemList.add(new Item("만년필", 10000));
        itemList.add(new Item("공책", 3000));
        itemList.add(new Item("사인펜", 2000));
        itemList.add(new Item("딱지", 200));
        itemList.add(new Item("축구공", 7000));
        itemList.add(new Item("사탕", 300));
        itemList.add(new Item("물감", 700));
    }

    public static Item getItem() {
        return itemList.get(random.getRandomBound(0, 9));
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("produce!");
            int randomValidRange = random.getRandomBound(0, popUp.popUpSize() - 1);
            popUp.sell(randomValidRange);
            try {
                Thread.sleep(random.getRandomBound(1000, 3000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
