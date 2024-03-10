package com.mycompany.gran_prix;

import java.io.IOException;
import java.util.Scanner;

public class Circuito {

    String nomeCircuito;
    int numeroGiri;
    int lunghezza;
    private final Scanner scan = new Scanner(System.in);
    private final Giudice giudice = new Giudice();

    public Circuito(String nomeCircuito, int numeroGiri, int lunghezza) {
        this.nomeCircuito = nomeCircuito;
        this.numeroGiri = numeroGiri;
        this.lunghezza = lunghezza;
    }

    public void inserisciDatiPiloti() throws IOException {
        System.out.println("Inserisci il numero di piloti che partecipano alla gara: ");
        int npiloti = scan.nextInt();
        Pilota[] piloti = new Pilota[npiloti];
        // Crea un array di piloti che permetta all'utente di inserire i dati
        for (int i = 0; i < piloti.length; i++) {
            scan.nextLine();
            System.out.println("Inserisci il nome del pilota: ");
            String nomePilota = scan.nextLine();
            System.out.println("Inserisci il modello dell'auto: ");
            String modelloAuto = scan.nextLine();
            System.out.println("Inserisci il tipo (1 - Base, 2 - Truccata): ");
            int tipo = scan.nextInt();
            Auto auto = new Auto(modelloAuto, tipo);
            piloti[i] = new Pilota(nomePilota, auto, nomeCircuito, numeroGiri, lunghezza);
            auto.salvaAuto();
        }
        giudice.inizioGara();
        for (Pilota pilota : piloti) {
            pilota.start(); // Avvio di tutti i thread piloti
        }

        // Attesa che tutti i piloti terminino la gara
        for (Pilota pilota : piloti) {
            try {
                pilota.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String[] tempiPiloti = new String[piloti.length];
        for (int i = 0; i < piloti.length; i++) {
            tempiPiloti[i] = piloti[i].nomePilota + ": " + piloti[i].getGiriCompletati();
        }
        giudice.fineGara(tempiPiloti); // Termina la gara e visualizza la classifica
    }
}
