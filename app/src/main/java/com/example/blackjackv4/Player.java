package com.example.blackjackv4;

public class Player {
    private static int handValue = 0;
    private static int cash = 5000;
    private static int bet = 0;
    private static boolean bust = false;
    private static boolean stand = false;
    private static String hand = "";
    private static boolean betPlaced = false;


    public static void playerWin() {
        //main.mainMessage.setText("You've won, congrats");
        Player.setCash(Player.getCash() + Player.getBet());
        //main.playerCash.setText(Player.getCash());
    }
    public static void playerLoss(){
        Dealer.setHouseTotal(Dealer.getHouseTotal() + getBet());
        Player.setCash(Player.getCash() - Player.getBet());
        if(isBust() == true) {
            MainActivity.mainText.setText("You've bust");
        }else {
            MainActivity.mainText.setText("You had the weaker hand");
        }
        MainActivity.softReset();
    }

    public static void playerBet() {
        if (MainActivity.betInput.getText().toString().matches("^$")) {
            MainActivity.playerHand.setText("Place bet first");
        } else if (MainActivity.betInput.getText().toString().matches("^[0-9]*")) {
            setBet(Integer.valueOf(MainActivity.betInput.getText().toString()));
           //MainActivity.playerHand.setText("You placed a bet of " + getBet());
            setBetPlaced(true);
        }

    }


    public static boolean isBetPlaced() {
        return betPlaced;
    }

    public static void setBetPlaced(boolean betPlaced) {
        Player.betPlaced = betPlaced;
    }

    public static int getHandValue() {
        return handValue;
    }

    public static void setHandValue(int handValue) {
        Player.handValue = handValue;
    }

    public static int getCash() {
        return cash;
    }

    public static void setCash(int cash) {
        Player.cash = cash;
    }

    public static int getBet() {
        return bet;
    }

    public static void setBet(int bet) {
        Player.bet = bet;
    }

    public static boolean isBust() {
        return bust;
    }

    public static void setBust(boolean bust) {
        Player.bust = bust;
    }

    public static boolean isStand() {
        return stand;
    }

    public static void setStand(boolean stand) {
        Player.stand = stand;
    }

    public static String getHand() {
        return hand;
    }

    public static void setHand(String hand) {
        Player.hand = hand;
    }


}
