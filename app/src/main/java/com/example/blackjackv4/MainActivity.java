package com.example.blackjackv4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView deckStatus;
    static TextView houseTotal;
    static TextView playerCash;
    static TextView dealerHandValue;
    static TextView playerHandValue;
    static TextView dealerHandDisplay;
    static TextView playerHandDisplay;
    static TextView mainText;
    static TextView playerHand;
    static EditText betInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Deck.initialiseDeck();
        Dealer.shuffle();
        deckStatus = this.findViewById(R.id.deckStatus);
        houseTotal = this.findViewById(R.id.houseTotal);
        playerCash = this.findViewById(R.id.playerCash);
        dealerHandValue = this.findViewById(R.id.dealerHandValue);
        playerHandValue = this.findViewById(R.id.playerValue);
        dealerHandDisplay = this.findViewById(R.id.dealerHandDisplay);
        playerHandDisplay = this.findViewById(R.id.playerHandDIsplay);
        mainText = this.findViewById(R.id.mainText);
        //playerHand = this.findViewById(R.id.playerHandDIsplay);
        betInput = this.findViewById(R.id.betInput);
    }

    public void onCLickBet(View view) {
        MainActivity.mainText.setText("");
        if(Player.isBetPlaced() == false) {
            Player.playerBet();
            if (Player.isBetPlaced() == true) {
                Dealer.dealToPlayer();
                Dealer.dealToDealer();
                updateDisplays();

            }
        }else{
            MainActivity.mainText.setText("You already placed a bet");
        }

    }
    public void onClickHit(View view){
        MainActivity.mainText.setText("");

        if(Player.isBust()== false) {
            Moves.hitToPlayer();
            updateDisplays();
            bustCheck();
        }




    }
    public void onClickStand(View view){
        if(Player.isStand() == false) {
            MainActivity.mainText.setText("");
            Player.setStand(true);
            Dealer.dealerChoice();
            updateDisplays();
            handCompare();
        }

    }
    public void updatePlayer(){
        playerHandDisplay.setText(Player.getHand());
        playerHandValue.setText(String.valueOf(Player.getHandValue()));
        playerCash.setText(String.valueOf(Player.getCash()));
    }
    public void updateDealer(){
        dealerHandDisplay.setText(Dealer.getHand());
        dealerHandValue.setText(String.valueOf(Dealer.getHandValue()));
        houseTotal.setText(String.valueOf(Dealer.getHouseTotal()));
    }
    public static void updateDisplays(){
        dealerHandDisplay.setText(Dealer.getHand());
        dealerHandValue.setText(String.valueOf(Dealer.getHandValue()));
        deckStatus.setText(String.valueOf(Dealer.getCardsInDeck()));
        houseTotal.setText(String.valueOf(Dealer.getHouseTotal()));

        playerHandDisplay.setText(Player.getHand());
        playerHandValue.setText(String.valueOf(Player.getHandValue()));

    }
    public static void updateCash(){
        playerCash.setText(String.valueOf(Player.getCash()));
    }
    public static void updateHouseTotal(){
        houseTotal.setText(String.valueOf(Dealer.getHouseTotal()));
    }
    public void bustCheck(){
        if(Player.getHandValue() > 21){
            Player.setBust(true);
            Player.playerLoss();

        }
    }
    public static void softReset(){
        Dealer.setHand("");
        Dealer.setHandValue(0);
        Dealer.setBust(false);



        Player.setHand("");
        Player.setHandValue(0);
        Player.setStand(false);
        Player.setBust(false);
        Player.setBetPlaced(false);
        Player.setBet(0);





    }
    public void handCompare(){
        if(Dealer.getHandValue() > Player.getHandValue()){
            Player.playerLoss();
        }else if(Dealer.getHandValue() < Player.getHandValue()){
            Dealer.dealerLoss();
        }else if(Dealer.getHandValue() == Player.getHandValue()){
            mainText.setText("Equal hands! Your bet is returned.");
            softReset();
        }
    }




}
