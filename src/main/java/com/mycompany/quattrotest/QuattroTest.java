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
    
    //Highlight the current card for clear visibility on the console
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static ArrayList<String> drawPile = new ArrayList<>();
    
    //Read what card is on top of the draw pile
    public static String getCurrentDraw() {
        return drawPile.get(0);
    } 
    
    //Distribute three random cards to each user
    public static ArrayList<String> threeRandomCards(ArrayList<String> mainDeck){
       
       ArrayList<String> threeCards = new ArrayList<>();
       Collections.shuffle(mainDeck);
       for(int i=0; i<3; i++){
           threeCards.add(mainDeck.get(i));
           mainDeck.remove(mainDeck.get(i));
       } 
        return threeCards;
     }
        //Initialize the first card to be played upon, first automated draw card
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
              String playedCard = player.realPlayerPlayCard(currentPlayerCard.toUpperCase(), drawPile);
               System.out.println("Played card " + playedCard);
              if(playedCard.equals("NO_CARD") || playedCard.equals("PASS")) {
                  //Pick a card from main deck and add it to the users card deck
                  String mainDeckCard = mainDeck.get(0);
                  player.getPlayerDeck().add(mainDeckCard);
                  mainDeck.remove(mainDeckCard);
                  
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
        
        //Initialize the main deck here
        ArrayList<String> mainDeck = initialisedCardDeck.initialiseCardDeck();
        
        System.out.println("Cards in deck: " + mainDeck.size());
        
        //Assign players 3 cards each
        Player p1 = new Player(player);
        p1.setPlayerDeck(threeRandomCards(mainDeck));
        
        Player p2 = new Player("Adrian");
        p2.setPlayerDeck(threeRandomCards(mainDeck));
        
        Player p3 = new Player("Rebecca");
        p3.setPlayerDeck(threeRandomCards(mainDeck));
        
        Player p4 = new Player("James");
        p4.setPlayerDeck(threeRandomCards(mainDeck));
        
        addCardToDrawPile(mainDeck, drawPile);
        
        boolean gameCheck = true;
        
        //Continue the loop of the game till gameCheck becomes false
        while (gameCheck) {
        
        
        if(mainDeck.isEmpty()){
        mainDeck = initialisedCardDeck.initialiseCardDeck();
        
        }
        String player2 = p2.getName();
        String player3 = p3.getName();
        String player4 = p4.getName();
        
        ArrayList<String> player1Deck = p1.getPlayerDeck();
        ArrayList<String> player2Deck = p2.getPlayerDeck();
        ArrayList<String> player3Deck = p3.getPlayerDeck();
        ArrayList<String> player4Deck = p4.getPlayerDeck();
        
        System.out.println("Cards in your deck :" + player1Deck);
        
        if(player2Deck.isEmpty()) {
            System.out.println(player2 + " has won the game");
        } else {
            System.out.println(player2 + "'s cards : " + player2Deck);
        }
        
        if(player3Deck.isEmpty()) {
            System.out.println(player3 + " has won the game");
        } else {
            System.out.println(player3 + "'s cards : " + player3Deck);
        }
        
        if(player4Deck.isEmpty()) {
            System.out.println(player4 + " has won the game");
        } else {
            System.out.println(player4 + "' cards : " + player4Deck);
        }
        
        
        System.out.println(ANSI_YELLOW_BACKGROUND + "Current card on draw pile: " + getCurrentDraw());
        
        if(!p1.getPlayerDeck().isEmpty()){
            
            getandPlayCardForRealPlayer(p1, mainDeck);
            
         } else {
            System.out.println("You have won the game");
            return;
        }
        
        if(!p2.getPlayerDeck().isEmpty()){
           
            p2.playCard(drawPile.get(0), drawPile, mainDeck);
           
           } else {
            System.out.println("Player 2 has won the game");
        }
         
         if(!p3.getPlayerDeck().isEmpty()){
            
            p3.playCard(drawPile.get(0), drawPile, mainDeck);
            
            } else {
            System.out.println("Player 3 has won the game");
        }
          
        if(!p4.getPlayerDeck().isEmpty()){
            
            p4.playCard(drawPile.get(0), drawPile, mainDeck);
            
           } else {
            System.out.println("Player 4 has won the game");
        }
        if(player2Deck.isEmpty() && player3Deck.isEmpty() && player4Deck.isEmpty()) {
        System.out.println("You lost the game");
        gameCheck = false;
        }
        }
        
        
    }
}
