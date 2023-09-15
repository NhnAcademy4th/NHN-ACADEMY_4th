package ch05;

import ch05.resource.poker.BlackjackHand;
import ch05.resource.poker.Deck;
import java.util.Scanner;

public class Casino {



    public boolean playBlackJack() {
        Scanner sc = new Scanner(System.in);

        Deck deck = new Deck();

        String playerInput;

        BlackjackHand player = new BlackjackHand();
        BlackjackHand dealer = new BlackjackHand();


        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());


        while (player.getBlackjackValue() < 21 && dealer.getBlackjackValue() < 21) {
            boolean playerIsHit = true;
            boolean dealerIsHit = dealer.getBlackjackValue() < 16;

            while (true) {
                System.out.println("HIT or STAY");
                playerInput = sc.next();
                if (playerInput.equals("HIT"))
                    break;
                else if (playerInput.equals("STAY"))
                    playerIsHit = false;
                else
                    System.out.println("\n잘못된 입력, 다시 입력하십시오, \n");
            }

            if (playerIsHit) {
                player.addCard(deck.dealCard());
            }
            if (dealerIsHit) {
                dealer.addCard(deck.dealCard());
            }

        }

        int playerValue = player.getBlackjackValue();
        int dealerValue = dealer.getBlackjackValue();

        if (playerValue == 21)
            return false;
        if (dealerValue == 21)
            return true;

        return playerValue > dealerValue ? false : true;


    }


}
