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
        Giudice giudice = new Giudice();
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
            System.out.println("Inserisci tipo: ");
            System.out.println("1. Base \n 2. Truccata");
            int tipo = scan.nextInt();
            Auto auto = new Auto(modelloAuto, tipo);
            piloti[i] = new Pilota(nomePilota, auto, nomeCircuito, numeroGiri, lunghezza);
            salvaInformazioniPilota(nomePilota, modelloAuto);
        }
        giudice.inizioGara();
        for (int i = 0; i < piloti.length; i++) {
            piloti[i].start();
        }// Avvio di tutti i thread piloti

        // Attesa che tutti i piloti terminino la gara
        for (Pilota pilota : piloti) {
            try {
                pilota.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        giudice.fineGara();
    }

    public void salvaInformazioniPilota(String nomePilota, String modelloAuto) {
        ScrittorePilota scrittorePilota = new ScrittorePilota("pilota.csv", nomePilota, modelloAuto);
        Thread threadScrittorePilota = new Thread(scrittorePilota);
        threadScrittorePilota.start();
    }
}
