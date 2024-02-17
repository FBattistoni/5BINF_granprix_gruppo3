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

/*
 * @author cartaginesi, battistoni, marchesini
 */
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

        } catch (IOException ex) {
            Logger.getLogger(ScrittoreAuto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
