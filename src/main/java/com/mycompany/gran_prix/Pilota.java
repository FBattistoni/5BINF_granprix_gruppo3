package com.mycompany.gran_prix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import java.util.Scanner;

public class Pilota extends Thread {

    Scanner sc = new Scanner(System.in);
    String nomePilota;
    Auto auto;
    String nomeCircuito;
    int ngiri;
    int lunghezzaCircuito;
    boolean running = true;
    int giriCompletati = 0;

    public Pilota(String nomePilota, Auto auto, String nomeCircuito, int ngiri, int lunghezzaCircuito) {
        this.nomePilota = nomePilota;
        this.auto = auto;
        this.nomeCircuito = nomeCircuito;
        this.ngiri = ngiri;
        this.lunghezzaCircuito = lunghezzaCircuito;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (giriCompletati < ngiri && running) {
            int spostamentoPercorso = 0;
            if (auto.getTipo() == 1) {
                spostamentoPercorso = r.nextInt(100);
                int posizione = spostamentoPercorso;
                pitStop(posizione);
                incidente(r);
                giriCompletati = verificaGiro(posizione, lunghezzaCircuito, giriCompletati);
            } else {
                if (auto.getTipo() == 2) {
                    spostamentoPercorso = r.nextInt(200);
                    int posizione = spostamentoPercorso;
                    pitStop(posizione);
                    incidente(r);
                    giriCompletati = verificaGiro(posizione, lunghezzaCircuito, giriCompletati);
                }
            }
        }
    }

    public void pitStop(int posizione) {
        System.out.println("Vuoi effettuare un PitStop(si/no)?");
        String scelta = sc.nextLine();
        // Effettua il Pitstop
        switch (scelta) {
            case "si" -> {
                System.out.println(nomePilota + " sta effettuando un pit stop.");
                try {
                    Thread.sleep(1500); // Pitstop (1.5 secondi)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            default -> {
            }
        }

    }

    public void incidente(Random rand) {
        if (rand.nextDouble() < 0.025) { // Probabilità del 2,5% che l'utente possa scegliere l'opzione di causare un incidente
            System.out.println("Vuoi far avvenire un incidente alla macchina(si/no)?");
            String scelta = sc.nextLine();
            switch (scelta) {
                //effettua un incidente
                case "si" -> {
                    System.out.println("Incidente! " + nomePilota + " è costretto ad abbandonare la gara.");
                    running = false;
                    try {
                        Thread.sleep(1500); // Pitstop (1.5 secondi)
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
            giriCompletati++;
        }
        return giriCompletati;
    }

    public int getGiriCompletati() {
        return giriCompletati; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
