package com.mycompany.gran_prix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import java.util.Scanner;

public class Pilota extends Thread {
    // Scanner per l'input dell'utente
    Scanner sc = new Scanner(System.in);

    // Attributi del pilota
    String nomePilota;
    Auto auto;
    String nomeCircuito;
    int ngiri;
    int lunghezzaCircuito;
    boolean running = true; // Indica se il pilota è in gara
    int giriCompletati = 0; // Numero di giri completati

    // Costruttore
    public Pilota(String nomePilota, Auto auto, String nomeCircuito, int ngiri, int lunghezzaCircuito) {
        this.nomePilota = nomePilota;
        this.auto = auto;
        this.nomeCircuito = nomeCircuito;
        this.ngiri = ngiri;
        this.lunghezzaCircuito = lunghezzaCircuito;
    }

    @Override
    public void run() {
        // Genera un numero casuale per la simulazione
        Random r = new Random();

        // Ciclo di gara
        while (giriCompletati < ngiri && running) {
            int spostamentoPercorso = 0; // Spostamento del pilota nel giro

            // Simulazione del movimento in base al tipo di auto
            if (auto.getTipo() == 1) {
                // Auto di tipo 1
                spostamentoPercorso = r.nextInt(100); // Genera un numero casuale da 0 a 99
                int posizione = spostamentoPercorso;  // Posizione del pilota nel circuito

                // Gestione pit stop
                pitStop(posizione);

                // Gestione incidenti
                incidente(r);
                
                // Verifica se un giro è stato completato
                giriCompletati = verificaGiro(posizione, lunghezzaCircuito, giriCompletati);
                
            } else {
                if (auto.getTipo() == 2) {
                    // Auto di tipo 2
                    spostamentoPercorso = r.nextInt(200); // Genera un numero casuale da 0 a 199
                    int posizione = spostamentoPercorso; // Posizione del pilota nel circuito

                    // Gestione pit stop
                    pitStop(posizione);
                    
                    // Gestione incidenti
                    incidente(r);
                    
                    // Verifica se un giro è stato completato
                    giriCompletati = verificaGiro(posizione, lunghezzaCircuito, giriCompletati);
                }
            }
        }
    }

    // Simulazione pit stop
    public void pitStop(int posizione) {
        // Richiesta all'utente se effettuare un pit stop
        System.out.println("Vuoi effettuare un PitStop(si/no)?");
        String scelta = sc.nextLine();
        
        // Effettua il pit stop se l'utente sceglie "si"
        switch (scelta) {
            case "si" -> {
                System.out.println(nomePilota + " sta effettuando un pit stop.");
                try {
                    Thread.sleep(1500);  // Simulazione del tempo di pit stop (1.5 secondi)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            default -> {
                // Non fare nulla
            }
        }

    }

    // Simulazione incidente
    public void incidente(Random rand) {
        if (rand.nextDouble() < 0.025) { // Probabilità del 2,5% che l'utente possa scegliere l'opzione di causare un incidente
            // Richiesta all'utente se effettuare un incidente
            System.out.println("Vuoi far avvenire un incidente alla macchina(si/no)?");
            String scelta = sc.nextLine();

            // Effettua incidente se l'utente sceglie "si"
            switch (scelta) {
                case "si" -> {
                    System.out.println("Incidente! " + nomePilota + " è costretto ad abbandonare la gara.");
                    running = false;
                    try {
                        Thread.sleep(1500); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                default -> {
                }
            }

        }

    }

    public int verificaGiro(int posizione, int lunghezzaCircuito, int giriCompletati) {
        // Verifica se è stato completato un giro
        if (posizione >= lunghezzaCircuito) {
            System.out.println(nomePilota + " ha completato il giro " + (giriCompletati + 1) + " su " + ngiri);
            posizione -= lunghezzaCircuito; // Resetta la posizione per il nuovo giro
            giriCompletati++; //incremento numero di giri completati
        }
        return giriCompletati;
    }

    public int getGiriCompletati() {
        return giriCompletati;
    }
}
