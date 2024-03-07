/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gran_prix;

/**
 * @author cartaginesi, battistoni, marchesini
 */
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
    
    public String getModelloAuto(){
        return modelloAuto;
    }
}
