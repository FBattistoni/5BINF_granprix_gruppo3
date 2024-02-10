/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gran_prix;

import java.util.Scanner;

/**
 *
 * @author francescobattistoni
 */
public class Gran_prix {

    public static void main(String[] args) {
        /*
        *   Variabili, oggetti, ecc...
         */
        Scanner sc = new Scanner(System.in);
        String nomeGiocatore;
        String email;
        String password;

        /*  
     *   Menu di scelta dove il giocatore deve registrarsi o accedere, creare 
     *   un file con le credenziali, dove in caso verranno salvate, nel caso 
     *   di accedere verrà fatto un check se le credenziali corrispondono.
     *   L'utente immetterà la scelta e in base al suo input l'if
     *   conterrà i metodi e codice al numero che corrispondono al menu.
         */
        short scelta = 0;
        boolean successo = false;
        while (successo == false) {
            System.out.println("1. Registrati");
            System.out.println("2. Accedi");

            scelta = sc.nextShort();

            if (scelta == 1) {
                successo = true;
                registrazione();
            } else if (scelta == 2) {
                successo = true;
                accesso();
            } else {
                System.out.println("Opzione non corretta. ");
            }
        }
    }

    /*
     *   Metodo per la registrazione del giocatore
     */
    public static void registrazione() {
        System.out.println("Scegli la tua email: ");
        /*Scanner*/
        System.out.println("Scegli la tua password: ");
        /*Scanner*/
        System.out.println("Scegli il tuo nome: ");
        /*Scanner*/
    }

    /*
     *   Metodo per l'accesso del giocatore
     */
    public static void accesso() {
        System.out.println("Immetti il tuo nome: ");
        /*Scanner*/
        System.out.println("Immetti la tua email: ");
        /*Scanner*/
        System.out.println("Immetti la tua password: ");
        /*Scanner*/
    }

}
