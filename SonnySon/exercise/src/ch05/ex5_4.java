package ch05;

import ch05.resource.poker.BlackjackHand;
import ch05.resource.poker.Deck;
import java.util.Scanner;

public class ex5_4 {

    public static void main(String[] args) {
        BlackjackHand blackjackHand = new BlackjackHand();

        Deck deck = new Deck(false);

        deck.shuffle();

        Scanner sc = new Scanner(System.in);

        int playerInput;

        // 0인경우 종료
        do{
            System.out.println("받고자 하는 카드 수를 입력하세요.");

            playerInput = sc.nextInt();

            for(int i =0; i<playerInput;i++){
                blackjackHand.addCard(deck.dealCard());
            }
            System.out.println("카드합 : "+blackjackHand.getBlackjackValue());
        }while(playerInput != 0);

    }
}
