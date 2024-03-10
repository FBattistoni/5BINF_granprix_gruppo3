package com.mycompany.gran_prix;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ScrittoreAuto implements Runnable {

    String nomeFile2;
    String modelloAuto;

    public ScrittoreAuto(String nomeFile2, String modelloAuto) {
        this.nomeFile2 = nomeFile2;
        this.modelloAuto = modelloAuto;
    }

    @Override
    public void run() {
        scrivi();
    }

    public void scrivi() {
        // Crea un oggetto BufferedWriter per scrivere nel file
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile2))) {
            // Scrive il modello dell'auto racchiuso tra '<' e '>'
            br.write("<" + modelloAuto + ">");
            // Aggiunge un carattere di nuova riga
            br.write("\n\r");
            // Forza la scrittura di tutti i dati nel buffer sul file
            br.flush();

        } catch (Exception ex) {
            // Stampa un messaggio di errore se si verifica un problema
            System.out.println("Errore: " + ex);
        }
    }
}
