/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quattrotest;
import java.util.ArrayList;
/**
 *
 * @author dolwi
 */
public class Player {
    private String name;
    private ArrayList<String> playerDeck = new ArrayList<>();
    
    public Player(String name){
        this.name = name;
   }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public ArrayList<String> getPlayerDeck() {
        return playerDeck;
    }
    
    public void setPlayerDeck(ArrayList<String> playerDeck){
        this.playerDeck = playerDeck;
    }
    
    public void playCard(String drawCard, ArrayList<String> drawPile, ArrayList<String> mainDeck){
        
        String[] arrOfStr = drawCard.split("", 2);
        
        String cardLetter = arrOfStr[0];
        String cardNumber = arrOfStr[1];
        
        for (String card: playerDeck){
            if(card.contains(cardLetter) || card.contains(cardNumber)){
                drawPile.add(0, card);
                playerDeck.remove(card);
                return;
            } 
        }
        String pickedCardFromMainDeck = mainDeck.get(0);
        playerDeck.add(pickedCardFromMainDeck);
        mainDeck.remove(pickedCardFromMainDeck);
     }
    
    public String realPlayerPlayCard(String playerCard, ArrayList<String> drawPile){
        
        String[] arrOfStr = playerCard.split("", 2);
        
        String cardLetter = arrOfStr[0];
        String cardNumber = arrOfStr[1];
        
        for (String card: drawPile){
            if(card.contains(cardLetter) || card.contains(cardNumber)){
                return playerCard;
            } else if(playerCard.toLowerCase().equals("pass")){
                return "PASS";
            }
        }
        
        return "NO_CARD";
     }
}
