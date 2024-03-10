package com.mycompany.gran_prix;

import java.io.IOException;
import java.util.Scanner;

public class Giocatore {

    private final Scanner sc = new Scanner(System.in);
    private String nomeGiocatore;
    private String email;
    private String password;
    private String chiave;
    private String passwordCifrata;
    private String modelloAuto;
    private String nomePilota;

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

    public void salvaCredenziali() {
        Scrittore scrittore = new Scrittore("credenziali.csv", nomeGiocatore, email, passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }

    public void gestioneCircuito() throws IOException {
        System.out.println("Immetti il nome del circuito: ");
        String nomeCircuito = sc.nextLine();
        System.out.println("Immetti il numero dei giri: ");
        int numeroGiri = sc.nextInt();
        System.out.println("Immetti la lunghezza del circuito: ");
        int lunghezzaCircuito = sc.nextInt();
        Circuito circuito = new Circuito(nomeCircuito, numeroGiri, lunghezzaCircuito);
        circuito.inserisciDatiPiloti();
    }

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
