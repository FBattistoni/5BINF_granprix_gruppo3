package com.mycompany.gran_prix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScrittorePilota implements Runnable {

    String nomeFile3;
    String nomePilota;
    String modelloAuto;

    public ScrittorePilota(String nomeFile3, String nomePilota, String modelloAuto) {
        this.nomeFile3 = nomeFile3;
        this.nomePilota = nomePilota;
        this.modelloAuto = modelloAuto;
    }

    @Override
    public void run() {
        scrivi();
    }

    public void scrivi() {
        // Crea un oggetto BufferedWriter per scrivere nel file 
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile3))) {
            // Scrive il nome del pilota nel file, racchiuso tra '<' e '>'.
            br.write("<" + nomePilota + ">");
            // Aggiunge un carattere di nuova riga al file.
            br.write("\n\r");
            // Scrive il modello dell'auto nel file, racchiuso tra '<' e '>'.
            br.write("<" + modelloAuto + ">");
            // Aggiunge un carattere di nuova riga al file.
            br.write("\n\r");
            // Forza la scrittura di tutti i dati nel buffer sul file.
            br.flush();

        } catch (IOException ex) {
            // In caso di errore di input/output (IOException), registra l'errore usando un Logger.
            Logger.getLogger(ScrittorePilota.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
