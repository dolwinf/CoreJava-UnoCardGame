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
public class StandardColourCard extends Card{
    
     public void StandardColourCard() {
        System.out.println("Initialise class");
    }
    
        ArrayList<String> deck = new ArrayList<>();
        
        @Override
        public ArrayList<String> initialiseCardDeck() {
        deck.add("R0");
        deck.add("R1");
        deck.add("R2");
        deck.add("R3");
        deck.add("R4");
        deck.add("R5");
        deck.add("R6");
        deck.add("R7");
        deck.add("R8");
        deck.add("R9");
        
        deck.add("B0");
        deck.add("B1");
        deck.add("B2");
        deck.add("B3");
        deck.add("B4");
        deck.add("B5");
        deck.add("B6");
        deck.add("B7");
        deck.add("B8");
        deck.add("B9");
        
        deck.add("Y0");
        deck.add("Y1");
        deck.add("Y2");
        deck.add("Y3");
        deck.add("Y4");
        deck.add("Y5");
        deck.add("Y6");
        deck.add("Y7");
        deck.add("Y8");
        deck.add("Y9");
        
        deck.add("G0");
        deck.add("G1");
        deck.add("G2");
        deck.add("G3");
        deck.add("G4");
        deck.add("G5");
        deck.add("G6");
        deck.add("G7");
        deck.add("G8");
        deck.add("G9");
        
        return deck;
     }
     
     
        
    
}
