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
    }

    //플레이어는 자식의 패를 확인하고, 딜러의 패 첫번째 장을 확인 하기 위한 메서드
    private void playPase(User player, User dealer) {
        System.out.println(player);
        System.out.println("-------------------------------");
        System.out.println("dealer's Hand");
        System.out.println(dealer.getCardDenomination(0));
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
        //해당 문장을 나중에 밖으로 빼주기..

        int choice;
        try {
            choice = Integer.parseInt(Inputshell.inputFromshell());
        } catch (Exception e) {
            throw new IllegalArgumentException("Please enter 1 or 2");
        }
        boolean isOneOrTwo = (choice == 1 || choice == 2);
        if (!isOneOrTwo) {
            throw new IllegalArgumentException("선택지 안에서 골라주세요!");
        }

        return choice == 1;
    }

    //todo 승리 판별 메서드
    //todo 본게임 시작 메서드
    //딜러 카드 추가 결정 메서드
//    private boolean dealerWinRate(User dealer){
//        int currentValue =  dealer.getCardDenomination(0)
//
//        for(int i = 0; i < deck.getSize(); i++;
//
//        }
//
//        return false;
//    }
}

