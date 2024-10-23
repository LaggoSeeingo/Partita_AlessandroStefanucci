/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package partita_pallavolo;

/**
 *
 * @author B045_14
 */
import java.util.Random;

public class Giocatore implements Runnable {
    private int idGiocatore;
    private int punti;
    private Random random; // Dichiarazione generatore di numeri casuali
    
    public Giocatore(int idGiocatore) {
        this.idGiocatore = idGiocatore;
        punti = 0;
        random = new Random(); // Inizializza generatore di numeri casuali
    }
    
    public int getIdGiocatore() {
        return idGiocatore;
    }
    
    public void run() {
        while (true) {
            int num = random.nextInt(2) + 1;
            if (num == 1) {
                punti++;
                System.out.println("Il giocatore: " + idGiocatore + " ha segnato! punteggio: " + punti);
                Thread.currentThread().yield();
            }
            else {
                System.out.println("Il giocatore: " + idGiocatore + " non ha segnato... punteggio: " + punti);
                Thread.currentThread().yield();
            }
        }
    }
}
