package com.mycompany.gran_prix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gran_prix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Giocatore giocatore1 = new Giocatore();

        /*scelta tra login e registrazione, il while continue finchè non si
         *sceglie 1 o 2
         */
        short scelta = 0;
        boolean successo = false;
        while (!successo) {
            System.out.println("1. Registrati");
            System.out.println("2. Accedi");

            scelta = sc.nextShort();

            switch (scelta) {
                case 1 -> {
                    successo = true;
                    giocatore1.registrazione();
                    giocatore1.criptaVigenere();
                    giocatore1.salvaCredenziali();
                    try {
                        giocatore1.gestioneCircuito();
                    } catch (IOException ex) {
                        Logger.getLogger(Gran_prix.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 2 -> {
                    successo = true;
                    giocatore1.accesso();
                    try {
                        giocatore1.gestioneCircuito();
                    } catch (IOException ex) {
                        Logger.getLogger(Gran_prix.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                default ->
                    System.out.println("Opzione non corretta. ");
            }
        }
    }
}
