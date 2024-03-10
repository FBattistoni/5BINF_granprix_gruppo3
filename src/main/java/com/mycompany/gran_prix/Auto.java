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

    public void salvaAuto() {
        ScrittoreAuto scrittoreAuto = new ScrittoreAuto("auto.csv", modelloAuto);
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
