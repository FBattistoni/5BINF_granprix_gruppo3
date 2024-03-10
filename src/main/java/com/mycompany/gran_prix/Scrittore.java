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

        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            br.write("<" + nomeGiocatore + ">");
            br.write("\n\r");
            br.write("<" + email + ">");
            br.write("\n\r");
            br.write("<" + password + ">");
            br.write("\n\r");
            br.flush();

        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
