package com.nhnacademy.Chapter5.Blackjack;

import java.util.ArrayList;

public class User {

    private final ArrayList<Card> hand = new ArrayList<>();

    public void add(Card card) {
        hand.add(card);
    }


    public int getCardDenomination(int index) {
        Card c = hand.get(index);
        return c.getDenominationValue();
    }
    

    @Override
    public String toString() {
        return " {" +
                "hand=" + hand +
                '}';
    }
}
