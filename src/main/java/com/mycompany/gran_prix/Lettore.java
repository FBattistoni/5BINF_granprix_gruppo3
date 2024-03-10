package com.mycompany.gran_prix;

import java.io.IOException;
import java.io.FileReader;

/**
 *
 * @author cartaginesi, battistoni, marchesini
 */
public class Lettore extends Thread {

    // Nome del file da leggere
    String nomeFile;

    // Costruttore
    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    // Metodo per la lettura del file (carattere per carattere)
    public void leggi() {
        synchronized (nomeFile) { // Sincronizzazione per evitare letture multiple in contemporanea
            int i;
            try (FileReader fr = new FileReader(nomeFile)) {
                // Lettura carattere per carattere dal file
                while ((i = fr.read()) != -1) {
                    System.out.println((char) i);
                }

                System.out.println("\n\r"); // Aggiunge un carattere di nuova riga al file.

            } catch (IOException ex) {
                // Gestione dell'errore in caso di problemi durante la lettura
                System.err.println("Errore in lettura!");
            }
        }
    }

    @Override
    public void run() {
        leggi();
    }
}
