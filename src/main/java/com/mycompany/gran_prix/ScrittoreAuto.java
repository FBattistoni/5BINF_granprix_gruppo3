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
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile2))) {
            br.write("<" + modelloAuto + ">");
            br.write("\n\r");
            br.flush();

        } catch (Exception ex) {
            System.out.println("Errore: " + ex);
        }
    }
}
