/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gran_prix;

/**
 * @author cartaginesi, battistoni, marchesini
 */
import java.util.Scanner;

public class Circuito {

    //Dichiarazione degli attributi, variabili, costruttore, ecc...
    String nomeCircuito;
    int numeroGiri;
    int lunghezza;

    public Circuito(String nomeCircuito, int numeroGiri, int lunghezza) {
        this.nomeCircuito = nomeCircuito;
        this.numeroGiri = numeroGiri;
        this.lunghezza = lunghezza;
    }

    //Metodo per inserire i dati dei piloti
    public void inserisciDatiPiloti() {
        Scanner scan = new Scanner(System.in);
        System.out.println("inserisci il numero di piloti che partecipano alla gara");
        int npiloti = scan.nextInt();
        Pilota[] piloti = new Pilota[npiloti];
        //Crea un array di piloti che permetta all'utente di inserire i dati
        for (int i = 0; i < piloti.length; i++) {
            scan.nextLine();
            System.out.println("Inserisci nome del pilota:");
            String nomePilota = scan.nextLine();
            System.out.println("Inserisci modello dell'auto:");
            String modelloAuto = scan.nextLine();
            piloti[i] = new Pilota(nomePilota, modelloAuto);
        }
    }
}
