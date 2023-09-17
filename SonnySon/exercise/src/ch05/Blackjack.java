package ch05;

import ch05.resource.poker.BlackjackHand;
import ch05.resource.poker.Deck;
import java.util.Scanner;

public class Blackjack {
    private final Deck deck;
    BlackjackHand player;
    private final BlackjackHand dealer;
    Scanner sc;

    private boolean isPlayerHit;
    private boolean isDealerHit;

    public Blackjack(){

        this.player = new BlackjackHand();
        this.dealer = new BlackjackHand();

        sc = new Scanner(System.in);

        this.deck = new Deck();

        isPlayerHit = true;
        isDealerHit = true;
    }

    public boolean play() {

        dealCard(2);
        showInterFace();

        while (!isGameOver()) {
            isPlayerHit = askHit();
            dealCard(1);
            showInterFace();
        }

        sc.close();

        return isPlayerWin();
    }

    private void dealCard(int runningCount){
        for (int i = 0; i < runningCount; i++) {
            dealDealerCard();
            dealPlayerCard();
        }
    }

    private void dealPlayerCard(){
        if(isPlayerHit){
            player.addCard(deck.dealCard());
        }
    }

    private void dealDealerCard(){
        isDealerHit = dealer.getBlackjackValue() < 16;
        if(isDealerHit){
            dealer.addCard(deck.dealCard());
        }
    }

    private void showInterFace(){
        System.out.println("player's cardList   Sum : " + player.getBlackjackValue());
        System.out.println(player);
        System.out.println();

        System.out.println("Dealer's cardList   Sum : " + dealer.getBlackjackValue());
        showDealerCardList();
    }

    private void showDealerCardList(){
        for(int i = 1; i<dealer.getCardCount();i++){
            System.out.println(dealer.getHand().get(i).getSuitAsString() +" "+dealer.getHand().get(i).getValue());
        }
    }

    private boolean askHit(){

        if(!isPlayerHit){
            return false;
        }
        System.out.println("HIT or STAY");

        while(true){
            String playerInput = sc.next();
            switch (playerInput) {
                case "HIT" : return true;
                case "STAY" : return false;
                default :
                    System.out.println(playerInput + " is Wrong Input : HIT or STAY");
            }
        }

    }

    private boolean isOver21(){
        return player.getBlackjackValue() > 21 || dealer.getBlackjackValue() > 21;
    }

    private boolean isStayBothUser(){
        return !isPlayerHit && !isDealerHit;
    }

    private boolean isGameOver(){
        return isOver21() || isStayBothUser();
    }

    public boolean isPlayerWin(){
        if (dealer.getBlackjackValue() == 21)
            return false;
        if (player.getBlackjackValue() == 21)
            return true;

        if(isOver21()){
            return player.getBlackjackValue() < dealer.getBlackjackValue();
        }else{
            return player.getBlackjackValue() > dealer.getBlackjackValue();
        }

    }

    public static void main(String[] args) {
        Blackjack bj = new Blackjack();
        bj.play();
    }
}
