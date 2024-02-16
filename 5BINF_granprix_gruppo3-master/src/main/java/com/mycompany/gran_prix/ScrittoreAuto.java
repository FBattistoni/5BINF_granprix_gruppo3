/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gran_prix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente Locale
 */
public class ScrittoreAuto implements Runnable {

    String nomeFile;
    String modelloAuto;

    public ScrittoreAuto(String nomeFile, String modelloAuto) {
        this.nomeFile = nomeFile;
        this.modelloAuto = modelloAuto;
    }

    @Override
    public void run() {
        scrivi();
    }

    public void scrivi() {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            br.write("<" + modelloAuto + ">");
            br.write("\n\r");
            br.flush();

        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

