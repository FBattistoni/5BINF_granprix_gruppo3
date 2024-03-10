package com.mycompany.gran_prix;

public class Giudice {

    public void inizioGara() {
        System.out.println("La gara sta per iniziare!");
        System.out.println("3...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("2...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("1...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Partenza!");
    }

    public void fineGara(String[] tempiPiloti) {
        System.out.println("La gara è finita!");
        System.out.println("Classifica finale:");

        // Ordina i tempi dei piloti
        for (int i = 0; i < tempiPiloti.length - 1; i++) {
            for (int j = 0; j < tempiPiloti.length - i - 1; j++) {
                String[] split1 = tempiPiloti[j].split(": ");
                String[] split2 = tempiPiloti[j + 1].split(": ");
                int tempo1 = Integer.parseInt(split1[1]);
                int tempo2 = Integer.parseInt(split2[1]);
                if (tempo1 > tempo2) {
                    String temp = tempiPiloti[j];
                    tempiPiloti[j] = tempiPiloti[j + 1];
                    tempiPiloti[j + 1] = temp;
                }
            }
        }

        // Stampa la classifica finale
        for (int i = 0; i < tempiPiloti.length; i++) {
            System.out.println((i + 1) + ". " + tempiPiloti[i]);
        }
    }
}
