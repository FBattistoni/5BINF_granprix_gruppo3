package com.mycompany.gran_prix;

import java.util.Random;
import java.util.Scanner;

public class Auto {

    String modelloAuto;
    int tipo;

    public Auto(String modelloAuto, int tipo) {
        this.modelloAuto = modelloAuto;
        this.tipo = tipo;
    }

    // salvataggio auto in file
    public void salvaAuto() {
        // utilizzo l'oggetto ScrittoreAuto per scrivere il file
        ScrittoreAuto scrittoreAuto = new ScrittoreAuto("auto.csv", modelloAuto);
        // attivo un thread separato per permettere l'esecuzione non bloccante della scrittura sul file
        Thread threadScrittoreAuto = new Thread(scrittoreAuto);
        threadScrittoreAuto.start();
    }

    public int getTipo() {
        return tipo;
    }

    public String getModelloAuto() {
        return modelloAuto;
    }
}
