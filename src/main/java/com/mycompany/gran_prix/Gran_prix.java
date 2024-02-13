/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gran_prix;

import java.util.Scanner;

/**
 * @author cartaginesi, battistoni, marchesini
 */
public class Gran_prix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Giocatore giocatore1 = new Giocatore();

        /*scelta tra login e registrazione, il while continue finchè non si
         *sceglie 1 o 2
         */
        short scelta = 0;
        boolean successo = false;
        while (successo == false) {
            System.out.println("1. Registrati");
            System.out.println("2. Accedi");

            scelta = sc.nextShort();

            if (scelta == 1) {
                successo = true;
                giocatore1.registrazione();
            } else if (scelta == 2) {
                successo = true;
                giocatore1.accesso();
            } else {
                System.out.println("Opzione non corretta. ");
            }
        }

        //metodi per criptare e salvare le credenziali messe dalla registrazione
        giocatore1.criptaVigenere();
        giocatore1.salvaCredenziali();

    }

}
