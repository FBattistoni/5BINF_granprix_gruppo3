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

        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile3))) {
            br.write("<" + nomePilota + ">");
            br.write("\n\r");
            br.write("<" + modelloAuto + ">");
            br.write("\n\r");
            br.flush();

        } catch (IOException ex) {
            Logger.getLogger(ScrittorePilota.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
