package com.nhnacademy.Chapter5.Blackjack;

public class Card {
    // 카드는 52장
    // A 2,3,4,5,6,7,8,9,10,J,Q,K
    // 카드 무늬, 번호를 지정
    private Denomination denomination;
    private Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public int getDenominationValue() {
        return denomination.getValue();
    }

    @Override
    public String toString() {
        return " Card {" +
                "denomination=" + denomination +
                ", suit=" + suit +
                "} ";
    }

}
