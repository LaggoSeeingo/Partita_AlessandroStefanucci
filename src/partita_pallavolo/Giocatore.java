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
    private Arbitro arbitro;
    
    public Giocatore(int idGiocatore, Arbitro arbitro) {
        this.idGiocatore = idGiocatore;
        punti = 0;
        this.arbitro = arbitro;
        random = new Random(); // Inizializza generatore di numeri casuali
    }
    
    public int getIdGiocatore() {
        return idGiocatore;
    }
    
    public int getPunti() {
        return punti;
    }
    
    public void run() {
        while (!arbitro.isFine()) {
            
            arbitro.attendiTurno(idGiocatore);
            
            if (!arbitro.isFine()) {
                
                int num = random.nextInt(2) + 1;               
                if (num == 1) {
                    punti++;
                    System.out.println("Il giocatore: " + idGiocatore + " ha segnato! punteggio: " + punti);
                    
                    // Verifica se il punto determina la vittoria
                    if (arbitro.assegnaPunto(idGiocatore, punti)) {
                        break;
                    }
                } else {
                    System.out.println("Il giocatore: " + idGiocatore + " non ha segnato... punteggio: " + punti);
                }
                
                // Passa il turno all'altro giocatore
                arbitro.passaTurno();
            }
        }
    }
}
