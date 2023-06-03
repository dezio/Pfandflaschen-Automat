package de.nathix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        double pricePerBottle = 0.25;
        double pricePerGlasBottle = 0.08;

        boolean flaschenEinlegen = true;
        double price = 0;
        int anzahl = 0;

        while(flaschenEinlegen) {
            String flaschenTyp = InputHelper.askForOption("Welcher Flaschentyp?", new String[] {"Dose", "Glasflasche"});
            if(flaschenTyp.equals("Dose")) {
                price += pricePerBottle;
            } else if(flaschenTyp.equals("Glasflasche")) {
                price += pricePerGlasBottle;
            }
            anzahl++;

            if(InputHelper.askForOption("Mehr?", new String[]{"Ja", "Nein"}).equals("Nein")) {
                flaschenEinlegen = false;
            }
        }

        System.out.println("Du hast " + anzahl + " Flaschen/Dosen eingelegt");
        System.out.println("Du bekommst " + price + "€");
    }
}