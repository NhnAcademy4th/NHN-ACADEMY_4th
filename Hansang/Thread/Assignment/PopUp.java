package com.nhnacademy.Assignment;

import java.util.ArrayList;
import java.util.List;

public class PopUp {
    private List<Store> popUp;

    public PopUp(int PopUpNum) {
        popUp = new ArrayList<>();
        for (int i = 0; i <= PopUpNum; i++) {
            popUp.add(new Store());
        }
    }

    public void enter(int index) {
        try {
            popUp.get(index).enter();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void exit(int index) {
        popUp.get(index).exit();
    }

    public void buy(int index) {
        popUp.get(index).buy();
    }

    public void sell(int index) {
        popUp.get(index).sell();
    }

    public int popUpSize() {
        return popUp.size();
    }

    public int getPeopleHead(int index) {
        return popUp.get(index).getPeopleNum();
    }

}
