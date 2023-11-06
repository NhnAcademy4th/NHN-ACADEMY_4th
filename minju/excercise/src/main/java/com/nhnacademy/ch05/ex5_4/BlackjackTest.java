package com.nhnacademy.ch05.ex5_4;

import java.util.Scanner;

public class BlackjackTest {

    private static Deck deck = new Deck();

    private BlackjackTest() {
    }

    public static void startBlackjack() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            deck.shuffle();
            BlackjackHand hand = new BlackjackHand();

            int cardNumber = (int) (Math.random() * 5) + 2;

            System.out.println("현재 카드 목록 : ");

            for (int i = 0; i < cardNumber; i++) {
                Card card = deck.dealCard();
                System.out.println(card);
                hand.addCard(card);
            }

            System.out.println("결과 : " + hand.getBlackjackValue());

            boolean checkContinue;
            while (true) {
                System.out.print("계속하시겠습니까? (Y/N) : ");
                String answer = scanner.next();

                switch (answer) {
                    case "Y":
                    case "y":
                        checkContinue = true;
                        break;
                    case "N":
                    case "n":
                        checkContinue = false;
                        break;
                    default:
                        System.out.println("잘못 입력되었습니다. 다시 입력해주세요.");
                        continue;
                }
                break;
            }

            if (!checkContinue) {
                System.out.println("게임을 종료합니다.");
                scanner.close();
                break;
            }

        }

    }
}
