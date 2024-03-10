package com.mycompany.gran_prix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

import java.util.logging.Logger;

public class Scrittore implements Runnable {

    String nomeFile;
    String nomeGiocatore;
    String email;
    String password;

    public Scrittore(String nomeFile, String nomeGiocatore, String email, String password) {
        this.nomeFile = nomeFile;
        this.nomeGiocatore = nomeGiocatore;
        this.email = email;
        this.password = password;
    }

    @Override
    public void run() {
        scrivi();
    }

    public void scrivi() {
        // Crea un oggetto BufferedWriter per scrivere nel file
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            // Scrive il nome del giocatore nel file, racchiuso tra '<' e '>'.
            br.write("<" + nomeGiocatore + ">");
            // Aggiunge un carattere di nuova riga al file.
            br.write("\n\r");
            // Scrive l'email del giocatore nel file, racchiuso tra '<' e '>'.
            br.write("<" + email + ">");
            // Aggiunge un carattere di nuova riga al file.
            br.write("\n\r");
            // Scrive la password del giocatore nel file, racchiuso tra '<' e '>'.
            br.write("<" + password + ">");
            // Aggiunge un carattere di nuova riga al file.
            br.write("\n\r");
            // Forza la scrittura di tutti i dati nel buffer sul file.
            br.flush();

        } catch (IOException ex) {
            // In caso di errore di input/output (IOException), registra l'errore usando un Logger.
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
