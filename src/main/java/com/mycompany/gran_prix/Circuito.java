package com.mycompany.gran_prix;

import java.io.IOException;
import java.util.Scanner;

public class Circuito {

    // Attributi del circuito
    String nomeCircuito;
    int numeroGiri;
    int lunghezza;

    // Scanner per l'input da tastiera
    private final Scanner scan = new Scanner(System.in);

    // Giudice per la gestione della gara
    private final Giudice giudice = new Giudice();

    // Costruttore
    public Circuito(String nomeCircuito, int numeroGiri, int lunghezza) {
        this.nomeCircuito = nomeCircuito;
        this.numeroGiri = numeroGiri;
        this.lunghezza = lunghezza;
    }

    // Metodo per l'inserimento dei dati dei piloti
    public void inserisciDatiPiloti() throws IOException {
        System.out.println("Inserisci il numero di piloti che partecipano alla gara: ");
        int npiloti = scan.nextInt();

        // Crea un array di piloti
        Pilota[] piloti = new Pilota[npiloti];
        
        // Inserimento dati per ogni pilota
        for (int i = 0; i < piloti.length; i++) {
            scan.nextLine();
            
            System.out.println("Inserisci il nome del pilota: ");
            String nomePilota = scan.nextLine();
            
            System.out.println("Inserisci il modello dell'auto: ");
            String modelloAuto = scan.nextLine();
            
            System.out.println("Inserisci il tipo (1 - Base, 2 - Truccata): ");
            int tipo = scan.nextInt();

            // Crea un'auto per il pilota
            Auto auto = new Auto(modelloAuto, tipo);

            // Crea un nuovo pilota con i dati inseriti
            piloti[i] = new Pilota(nomePilota, auto, nomeCircuito, numeroGiri, lunghezza);

            // Salva l'auto del pilota
            auto.salvaAuto();
        }

        // Inizio gara
        giudice.inizioGara();

        // Avvio di tutti i thread piloti
        for (Pilota pilota : piloti) {
            pilota.start();
        }

        // Attesa che tutti i piloti terminino la gara
        for (Pilota pilota : piloti) {
            try {
                pilota.join(); // Attende che il thread pilota termini
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Stampa tempi piloti
        String[] tempiPiloti = new String[piloti.length];
        for (int i = 0; i < piloti.length; i++) {
            tempiPiloti[i] = piloti[i].nomePilota + ": " + piloti[i].getGiriCompletati();
        }
        // Fine gara e visualizzazione classifica
        giudice.fineGara(tempiPiloti);
    }
}
