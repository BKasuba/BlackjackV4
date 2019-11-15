package com.example.blackjackv4;

public class Deck {

    static String[] suits = { "Diamond", "Heart", "Spades", "Club"};
    static String[] value = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10" ,"Jack", "Queen", "King"};
    static String[][] deck = new String[52][2];

    public static void initialiseDeck(){
        int suitcntr = 0;
        int valuecntr = 0;
        for(int i = 0; i < 52; i++){
            if(valuecntr != 0){
                if(valuecntr % 13 == 0){
                    suitcntr++;
                    valuecntr = 0;
                }
            }

            deck[i][0] = value[valuecntr];
            deck[i][1] = suits[suitcntr];
            valuecntr++;
        }
    }
}