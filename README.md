### Struttura del codice

Il codice è organizzato in pacchetti e classi:

**Pacchetti:**

* `com.mycompany.gran_prix`: Contiene le classi principali del gioco.
* `java.io`: Contiene classi per la gestione di file e input/output.

**Classi:**

* `Auto`: Rappresenta un'auto del gioco, con informazioni sul modello e tipo.
* `Circuito`: Rappresenta un circuito del gioco, con informazioni sul nome, numero di giri e lunghezza.
* `Giocatore`: Rappresenta un giocatore del gioco, con informazioni sul nome, email, password e chiave.
* `Giudice`: Gestisce la gara e la classifica.
* `Gran_prix`: La classe principale del gioco che avvia la simulazione.
* `Pilota`: Rappresenta un pilota del gioco, con informazioni sul nome, auto, circuito e giri completati.
* `Lettore`: Legge e visualizza il contenuto di un file.
* `Scrittore`: Scrive informazioni su un file.
* `ScrittoreAuto`: Scrive il modello dell'auto su un file.
* `ScrittorePilota`: Scrive il nome del pilota e il modello dell'auto su un file.

### Come giocare

Per giocare al Gran Premio, è necessario:

1. Eseguire la classe `Gran_prix`.
2. Seguire le istruzioni a schermo per registrarsi o accedere come giocatore.
3. Scegliere un circuito e configurare i piloti e le macchine.
4. Avviare la gara.
5. Scegliere ad ogni giro la gestione del PitStop e dell'incidente.
6. Terminata la gara verrà visualizzata la classifica finale.

### Funzionalità del gioco

* Registrazione e accesso dei giocatori.
* Gestione di circuiti e piloti ed auto.
* Simulazione di una gara automobilistica.
* Visualizzazione della classifica finale.
