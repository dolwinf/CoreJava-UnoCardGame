/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.quattrotest;
import java.util.ArrayList;
import java.util.Scanner;  
import java.util.Collections;

/**
 *
 * @author dolwi
 */
public class QuattroTest {
    
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static ArrayList<String> drawPile = new ArrayList<>();
    
    public static String getCurrentDraw() {
        return drawPile.get(0);
    } 
    
    public static ArrayList<String> threeRandomCards(ArrayList<String> mainDeck){
       
       ArrayList<String> threeCards = new ArrayList<>();
       Collections.shuffle(mainDeck);
       for(int i=0; i<3; i++){
           threeCards.add(mainDeck.get(i));
           mainDeck.remove(mainDeck.get(i));
       } 
        return threeCards;
     }
    
        public static void addCardToDrawPile(ArrayList<String> mainDeck,  ArrayList<String> drawPile){
            Collections.shuffle(mainDeck);
            String firstCard = mainDeck.get(0);
            drawPile.add(firstCard);
            mainDeck.remove(firstCard);
      }
       
         public static void getandPlayCardForRealPlayer(Player player, ArrayList<String> mainDeck){
              Scanner myObj = new Scanner(System.in);
              System.out.println("Choose/Type one of the cards from your deck OR press ENTER to pass");
              String currentPlayerCard = myObj.nextLine();
              String playedCard = player.realPlayerPlayCard(currentPlayerCard, drawPile);
               System.out.println("Played card " + playedCard);
              if(playedCard.equals("NO_CARD") || playedCard.equals("PASS")) {
                  //Pick a card from main deck and add it to the users card deck
                  player.getPlayerDeck().add(mainDeck.get(0));
                  System.out.println("Passed");
                } else {
                  //Else remove the card from the player deck and place it in the draw pile
                  player.getPlayerDeck().remove(playedCard);
                  drawPile.add(0, playedCard);
               }
         }
         
       public static StandardColourCard initialisedCardDeck = new StandardColourCard();
       
       
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your player name");
        String player = myObj.nextLine();
        
        ArrayList<String> mainDeck = initialisedCardDeck.initialiseCardDeck();
        
        System.out.println("Cards in deck: " + mainDeck.size());
        
        Player p1 = new Player(player);
        p1.setPlayerDeck(threeRandomCards(mainDeck));
        
        Player p2 = new Player("Adrian");
        p2.setPlayerDeck(threeRandomCards(mainDeck));
        
        Player p3 = new Player("Rebecca");
        p3.setPlayerDeck(threeRandomCards(mainDeck));
        
        Player p4 = new Player("James");
        p4.setPlayerDeck(threeRandomCards(mainDeck));
        
        addCardToDrawPile(mainDeck, drawPile);
        
        while (true) {
        
        String player1 = p1.getName();
        String player2 = p2.getName();
        String player3 = p3.getName();
        String player4 = p4.getName();
        
        ArrayList<String> player1Deck = p1.getPlayerDeck();
        ArrayList<String> player2Deck = p2.getPlayerDeck();
        ArrayList<String> player3Deck = p3.getPlayerDeck();
        ArrayList<String> player4Deck = p4.getPlayerDeck();
        
       
           
        System.out.println(" Player 1 is: " + player1);
        System.out.println(" You have the cards in your deck : " + player1Deck);
        
        System.out.println(" Player 2 is: " + player2);
        System.out.println(" Player 2 cards : " + player2Deck);
        
        System.out.println(" Player 3 is: " +  player3);
        System.out.println(" Player 3 cards : " + player3Deck);
        
        System.out.println(" Player 4 is: " + player4);
        System.out.println(" Player 4 cards : " + player4Deck);
        
        
        System.out.println(ANSI_YELLOW_BACKGROUND + "Current card on draw pile: " + getCurrentDraw());
        
        System.out.println("Cards remaining in deck: " + mainDeck.size());
        
        if(!p1.getPlayerDeck().isEmpty()){
            ArrayList<String> player1CardsRemaining = p1.getPlayerDeck();
            getandPlayCardForRealPlayer(p1, mainDeck);
            System.out.println("Player 1 has " +player1CardsRemaining.size()+" cards remaining");
         } else {
            System.out.println("You have won the game");
            return;
        }
        
        if(!p2.getPlayerDeck().isEmpty()){
            ArrayList<String> player2CardsRemaining = p2.getPlayerDeck();
            p2.playCard(drawPile.get(0), drawPile, mainDeck);
            System.out.println("Player 2 has " +player2CardsRemaining.size()+" cards remaining");
           } else {
            System.out.println("Player 2 has won the game");
        }
         
         if(!p3.getPlayerDeck().isEmpty()){
            ArrayList<String> player3CardsRemaining = p3.getPlayerDeck();
            p3.playCard(drawPile.get(0), drawPile, mainDeck);
            System.out.println("Player 3 has " +player3CardsRemaining.size()+" cards remaining");
            } else {
            System.out.println("Player 3 has won the game");
        }
          
        if(!p4.getPlayerDeck().isEmpty()){
            ArrayList<String> player4CardsRemaining = p4.getPlayerDeck();
            p4.playCard(drawPile.get(0), drawPile, mainDeck);
            System.out.println("Player 4 has " +player4CardsRemaining.size()+" cards remaining");
           } else {
            System.out.println("Player 4 has won the game");
        }
        }
    }
}
