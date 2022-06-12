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
public class ColourCard extends Card{
    
    public void ColourCard() {
        System.out.println("Initialise class");
    }
    
    @Override
    public ArrayList<String> initialiseCardDeck() {
        System.out.println("Initialise deck");
        return new ArrayList<String>();
    }
}
