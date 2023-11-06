package com.nhnacademy.Assignment;

public class Customer implements Runnable {
    private PopUp popUp;
    private Thread thread;

    public Customer(PopUp popUp) {
        thread = new Thread(this);
        this.popUp = popUp;
    }

    @Override
    public void run() {
        Randomizer random = new Randomizer();
        int randomPopUpNum = random.getRandomBound(0, popUp.popUpSize());

        if (popUp.getPeopleHead(randomPopUpNum) >= 5) {
            try {
                popUp.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        popUp.enter(randomPopUpNum);

        System.out.println(
                (randomPopUpNum + 1) + " popup store have " + popUp.getPeopleHead(randomPopUpNum) + " people");
        popUp.buy(randomPopUpNum);


        try {
            Thread.sleep(random.getRandomBound(1000, 5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        popUp.exit(randomPopUpNum);
    }

    public void start() {
        thread.start();
    }
}
