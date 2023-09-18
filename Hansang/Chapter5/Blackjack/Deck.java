package com.nhnacademy.Chapter5.Blackjack;

import java.util.ArrayList;

public class Deck {

    private final ArrayList<Card> trump = new ArrayList<Card>();

    public void add(Card card) {
        trump.add(card);
    }

    public void delete(Card card) {
        if (trump.isEmpty()) {
            throw new IllegalArgumentException("덱이 비어있습니다.");
        }
        if (!trump.contains(card)) {
            throw new IllegalArgumentException("삭제 할 카드가 덱에 없습니다.");
        }
        trump.remove(card);
    }

    public Card getCard(int index) {
        return trump.get(index);
    }

    public double getSize() {
        return trump.size();
    }
}
