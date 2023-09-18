package com.nhnacademy.Chapter5.Blackjack;

import com.nhnacademy.Chapter5.Inputshell;

public class Table {

    private final Deck deck = new Deck();

    private final User player = new User();

    private final User dealer = new User();


    //게임의 준비단계
    public void prepareGame() {
        reloadDeck();
        distrubutTurn();
    }

    //덱을 초기화
    private void reloadDeck() {
        Denomination[] denomination = Denomination.values();
        Suit[] suit = Suit.values();

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                deck.add(new Card(denomination[i], suit[j]));
            }
        }
    }

    //플레이어 딜러 2장씩 카드를 받는 단계
    private void distrubutTurn() {
        for (int i = 0; i < 2; i++) {
            distrubutCard(player);
            distrubutCard(dealer);
        }
        playPase(player, dealer);
        hitTurn();
    }

    //플레이어는 자식의 패를 확인하고, 딜러의 패 첫번째 장을 확인 하기 위한 메서드
    private void playPase(User player, User dealer) {
        System.out.println(player);
        System.out.println("-------------------------------");
        System.out.println("dealer's Hand");
        System.out.println(dealer.getCard(0));
    }


    //카드를 분배하는 메서드
    private void distrubutCard(User player) {
        Card card = drowCard();
        player.add(card);
    }

    //덱에서 카드를 한장 드로우하고, 드로우한 카드를 덱에서 삭제 및 리턴해주는 메서드
    private Card drowCard() {
        int randomNumber = (int) (Math.random() * deck.getSize());
        Card card = deck.getCard(randomNumber);
        deck.delete(card);

        return card;
    }

    //카드를 더 받을지 말지 결정하는 메서드
    private boolean reciveExtraCard() {
        System.out.println("3턴이 지나고 딜러와 플레이어가 카드를 확인합니다.");
        System.out.println("카드를 받을지 결정해주세요: 1. 한장을 더 받는다 2. 결과를 확인한다.");

        int choice;
        try {
            choice = Integer.parseInt(Inputshell.inputFromshell());
        } catch (Exception e) {
            throw new IllegalArgumentException("Input error!");
        }
        boolean isValidChoice = (choice == 1 || choice == 2);
        if (!isValidChoice) {
            throw new IllegalArgumentException("선택지 안에서 골라주세요!");
        }

        return choice == 1;
    }

    //hit or stand
    private void hitTurn() {
        int count = 0;

        while (count < 4) {
            if (reciveExtraCard()) {
                distrubutCard(player);
                System.out.println(player);
            } else {
                break;
            }

            if (isvalidRange(TotalScore(player))) {
                resultPrinter("dealer");
                return;
            }

            if (TotalScore(player) == 21) {
                resultPrinter("player");
                return;
            }

            count++;
        }
        endPase();
    }

    private boolean isvalidRange(int number) {
        return number > 21;
    }

    //결과 확인 메서드
    private void endPase() {
        dealerHit();

        boolean isDrow = (TotalScore(player) == TotalScore(dealer));
        boolean isWin = (TotalScore(player) > TotalScore(dealer));

        if (isWin) {
            resultPrinter("player");
            return;
        } else if (isDrow) {
            resultPrinter("both ");
            return;
        }
        resultPrinter("dealer");
    }

    private void resultPrinter(String str) {
        System.out.println(str + " win!");
        System.out.println("dealer's" + dealer);
    }

    //총 점수를 받아오는 메서드
    private int TotalScore(User player) {
        int score = 0;
        boolean isAce;
        for (int i = 0; i < player.getSize(); i++) {
            score += player.getCardDenomination(i);

            isAce = (isvalidRange(score) && player.getCardDenomination(i) == 11);
            if (isAce) {
                score -= 10;
            }
        }
        return score;
    }

    //딜러 카드 추가 메서드
    private void dealerHit() {
        while (TotalScore(dealer) < 17 && !isvalidRange(TotalScore(dealer))) {
            distrubutCard(dealer);
        }
    }


}

