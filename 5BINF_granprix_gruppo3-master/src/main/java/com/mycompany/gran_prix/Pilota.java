/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gran_prix;

/**
 * @author cartaginesi, battistoni, marchesini
 */
public class Pilota extends Thread {

    String nomePilota;
    String modelloAuto;

    public Pilota(String nomePilota, String modelloAuto) {
        this.nomePilota = nomePilota;
        this.modelloAuto = modelloAuto;
    }

    @Override
    public void run() {

    }
}
