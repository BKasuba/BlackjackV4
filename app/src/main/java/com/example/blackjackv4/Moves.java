package com.example.blackjackv4;

public class Moves {
    public static void hitToPlayer(){
        Dealer.drawCard();
        Player.setHand(Player.getHand() + ", " + Dealer.getCard());
        Player.setHandValue(Player.getHandValue() + Dealer.getCardValue());

    }
    public static void hitToDealer(){
        Dealer.drawCard();
        Dealer.setHand(Dealer.getHand() + ", " + Dealer.getCard());
        Dealer.setHandValue(Dealer.getHandValue() + Dealer.getCardValue());
    }
}
