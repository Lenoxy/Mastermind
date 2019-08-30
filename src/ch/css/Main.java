package ch.css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        // Array mit verfügbaren Farben
        String[] farben = {"rot", "blau", "pink", "grün", "orange", "weiss", "grau", "gelb"};
        // Kontrolle ob nochmals spielen
        boolean weiterspielen = true;
        // wenn true
        while(weiterspielen){
            // Array random Farben
            String[] farbenKombination = new String[4];
            // Array von Eingabe
            String[] benutzerKombination = new String[4];
            // Einleitung
            System.out.println(
                    "Herzlich Willkommen! Bei Mastermind sollst du versuchen eine vierstellige Farbenkombination zu erraten.");
            // Versuche
            int anzahlRunden = 1;
            // random Farben setzen
            for(int i = 0; i < 4; i++){
                Random rand = new Random();
                farbenKombination[i] = farben[rand.nextInt(farben.length)];
                // System.out.println(farbenKombination[i]);
            }
            int anzahlRichtigeFarben = 0;
            int anzahlRichtigePosition = 0;
            // Kontrolle ob schon 12 Versuche
            while(anzahlRunden <= 12){
                System.out.println("Runde:" + anzahlRunden
                        + "/12. Du kannst die Farben rot, blau, pink, grün, orange, weiss, grau und gelb verwenden.");
                // Position
                for(int i = 0; i < 4; i++){
                    System.out.print("Position " + (i + 1) + ": ");
                    // trim wegen Leerzeichen
                    benutzerKombination[i] = br.readLine().trim().toLowerCase();
                    String farbe = benutzerKombination[i];
                    switch(farbe){
                        case "rot":
                            break;
                        case "blau":
                            break;
                        case "pink":
                            break;
                        case "grün":
                            break;
                        case "orange":
                            break;
                        case "weiss":
                            break;
                        case "grau":
                            break;
                        case "gelb":
                            break;
                        default:
                            System.out.println("Ungültige Eingabe! Versuchen Sie es nochmals.");
                            i--;
                            break;
                    }
                }
                for(int i = 0; i <= 3; i++){
                    if(farbenKombination[i].equals(benutzerKombination[i])){
                        anzahlRichtigePosition++;
                    }
                }
                String[] kopieFarbenKombi = farbenKombination.clone();
                String[] kopieBenutzerKombi = benutzerKombination.clone();
                for(int i = 0; i <= 3; i++){
                    for(int y = 0; y < 4; y++){
                        if(kopieFarbenKombi[i].equals(kopieBenutzerKombi[y].toLowerCase())){
                            anzahlRichtigeFarben++;
                            kopieFarbenKombi[i] = "";
                            kopieBenutzerKombi[y] = "n";
                        }
                    }
                }
                anzahlRichtigeFarben = anzahlRichtigeFarben - anzahlRichtigePosition;
                System.out.println("anzahl Farben an der richtigen Position: " + anzahlRichtigePosition);
                System.out.println("anzahl sonst richtige Farben: " + anzahlRichtigeFarben);
                // Kontrolle der richtigen Positionen
                if(anzahlRichtigePosition == 4){
                    System.out.println("\nDu hast gewonnen!grün");
                }
                anzahlRunden++;                anzahlRunden++;

                // Kontrolle ob Versuche abgelaufen
                if(anzahlRunden > 12){
                    System.out.println("Du hast verloren!\n");
                    System.out.println("Die richtige Farbkombination wäre:");
                    for(int i = 0; i < farbenKombination.length; i++){
                        System.out.println("Position " + (i + 1) + ": " + farbenKombination[i]);
                    }
                }
                // Nochmals spielen?
                if(anzahlRunden > 12 || anzahlRichtigePosition == 4){
                    System.out.println("\nNochmal spielen? (y/n)");
                    boolean falscheEingabe = true;
                    while(falscheEingabe){
                        switch(br.readLine().trim().toLowerCase()){
                            case "n":
                                weiterspielen = false;
                                falscheEingabe = false;
                                System.out.println("Wir hoffen es hat dir gefallen!");
                            case "y":
                                falscheEingabe = false;
                                break;
                            default:
                                System.out.println(
                                        "ungültige Antwort. Schreibe 'y' um erneut zu spielen und 'n' zum beenden.");
                        }
                    }
                    boolean n = false;
                    break;
                }
                anzahlRichtigeFarben = 0;
                anzahlRichtigePosition = 0;
            }
        }
    }
}
