package com.mycompany.gran_prix;

import java.io.IOException;
import java.io.FileReader;

/**
 *
 * @author cartaginesi, battistoni, marchesini
 */
public class Lettore extends Thread {

    String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public void leggi() {
        synchronized (nomeFile) {
            int i;
            try (FileReader fr = new FileReader(nomeFile)) {
                while ((i = fr.read()) != -1) {
                    System.out.println((char) i);
                }

                System.out.println("\n\r");

            } catch (IOException ex) {
                System.err.println("Errore in lettura!");
            }
        }
    }

    @Override
    public void run() {
        leggi();
    }
}
