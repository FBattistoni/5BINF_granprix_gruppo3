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

            switch (scelta) {
                case 1 -> {
                    successo = true;
                    giocatore1.registrazione();
                    giocatore1.criptaVigenere();
                    giocatore1.salvaCredenziali();
                }
                case 2 -> {
                    successo = true;
                    giocatore1.accesso();
                }
                default ->
                    System.out.println("Opzione non corretta. ");
            }
        }
        giocatore1.salvaAuto();
        giocatore1.salvaPilota();
    }

}
