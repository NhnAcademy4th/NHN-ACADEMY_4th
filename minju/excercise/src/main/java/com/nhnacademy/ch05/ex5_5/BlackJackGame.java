package com.nhnacademy.ch05.ex5_5;

import com.nhnacademy.ch05.ex5_4.BlackjackHand;
import com.nhnacademy.ch05.ex5_4.Deck;

import java.util.Scanner;

public class BlackJackGame {

    private Deck deck;
    private BlackjackHand userHand;
    private BlackjackHand dealerHand;

    private boolean isUserWin;
    private boolean isDealerWin;

    public BlackJackGame() {

        this.deck = new Deck();
        this.userHand = new BlackjackHand();
        this.dealerHand = new BlackjackHand();

        this.isUserWin = false;
        this.isDealerWin = false;

    }

    public void start() {

        System.out.println("블랙잭 게임을 시작합니다.\n");

        deck.shuffle();
        setCards();

        if (isBlackJack()) {
            return;
        }

        userShell();

    }

    private void setCards() {
        userHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
    }

    private boolean isBlackJack() {
        System.out.printf("딜러 : %d   유저 : %d%n", dealerHand.getBlackjackValue(), userHand.getBlackjackValue());

        if (dealerHand.isBlackJack()) {
            System.out.println("딜러가 승리하였습니다.");
            return true;
        } else if (userHand.isBlackJack()) {
            System.out.println("유저가 승리하였습니다.");
            return true;
        }
        return false;
    }

    private void userShell() {
        if (isUserWin || isDealerWin) {
            printWinner();
            return;
        }

        printUserCards();
        userInputShell();
    }

    private void userInputShell() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hit or Stand : ");
        String answer = scanner.nextLine().toUpperCase();

        switch (answer) {
            case "HIT":
                hit();
                break;
            case "STAND":
                stand();
                break;
            default:
                System.out.println("잘못 입력되었습니다. 다시 입력해주세요.(Hit/Stand)");
                userInputShell();
        }
    }

    private void hit() {
        userHand.addCard(deck.dealCard());
        if (userHand.getBlackjackValue() > 21) {
            isDealerWin = true;
        }
        userShell();
    }

    private void stand() {
        if (dealerHand.getBlackjackValue() < 16) {
            dealerHand.addCard(deck.dealCard());
        }

        System.out.println("딜러 카드 목록 : ");
        for (int i = 0; i < dealerHand.getCardCount(); i++) {
            System.out.println(dealerHand.getCard(i));
        }

        int dealerValue = dealerHand.getBlackjackValue();
        int userValue = userHand.getBlackjackValue();
        if (dealerValue < 21 && dealerValue >= userValue) {
            isDealerWin = true;
        } else {
            isUserWin = true;
        }
        userShell();
    }

    private void printUserCards() {
        System.out.println("딜러 카드 중 무작위 한 장 :");
        System.out.println(dealerHand.getCard((int) (Math.random() * 2)));
        System.out.println("유저 카드 목록 : ");
        for (int i = 0; i < userHand.getCardCount(); i++) {
            System.out.println(userHand.getCard(i));
        }
        System.out.println();
    }

    private void printWinner() {
        System.out.printf("딜러 : %d   유저 : %d%n", dealerHand.getBlackjackValue(), userHand.getBlackjackValue());

        if (isUserWin) {
            System.out.println("유저가 이겼습니다.");
        } else if (isDealerWin) {
            System.out.println("딜러가 이겼습니다.");
        }
    }

    public boolean getWinner() {
        return isUserWin;
    }
}
