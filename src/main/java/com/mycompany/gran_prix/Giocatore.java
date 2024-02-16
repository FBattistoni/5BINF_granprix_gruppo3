/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gran_prix;

/**
 * @author cartaginesi, battistoni, marchesini
 */
import java.util.Scanner;

public class Giocatore {

    private Scanner sc = new Scanner(System.in);
    private String nomeGiocatore;
    private String email;
    private String password;
    private String chiave;
    private String passwordCifrata;

    public Giocatore() {
        this.nomeGiocatore = "";
        this.email = "";
        this.password = "";
        this.chiave = "";
    }

    public void registrazione() {
        System.out.println("Immetti il tuo nome: ");
        nomeGiocatore = sc.nextLine();
        setNomeGiocatore(nomeGiocatore);
        System.out.println("Immetti la tua email: ");
        email = sc.nextLine();
        setEmail(email);
        System.out.println("Immetti la tua password: ");
        password = sc.nextLine();
        setPassword(password);
        System.out.println("Immetti la chiave: ");
        chiave = sc.nextLine();
        setChiave(chiave);
    }

    public void accesso() {
        System.out.println("Immetti il tuo nome: ");
        nomeGiocatore = sc.nextLine();
        setNomeGiocatore(nomeGiocatore);
        System.out.println("Immetti la tua email: ");
        email = sc.nextLine();
        setEmail(email);
        System.out.println("Immetti la tua password: ");
        password = sc.nextLine();
        setPassword(password);
    }

    // Metodo per criptare vigenere
    public String criptaVigenere() {
        StringBuilder passwordCifrata = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char carattere = password.charAt(i);
            char chiaveCorrispondente = chiave.charAt(i % chiave.length());

            // Esegue la cifratura di vigenere
            char carattereCifrato = (char) ((carattere + chiaveCorrispondente) % 128);

            passwordCifrata.append(carattereCifrato);
        }

        this.passwordCifrata = passwordCifrata.toString();
        return this.passwordCifrata;
    }

    // Metodo per salvare le credenziali
    public void salvaCredenziali() {
        Scrittore scrittore = new Scrittore("credenziali.csv", nomeGiocatore, email, passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }

    // Metodo per immettere i dati delle Auto, Piloti, ecc...
    public void salvaAuto() {
    }

    // Getters e setters
    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public void setNomeGiocatore(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChiave(String chiave) {
        this.chiave = chiave;
    }
}
