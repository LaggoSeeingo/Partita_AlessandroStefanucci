/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package partita_pallavolo;

public class Arbitro {
    private static final int VITTORIA = 25;
    private boolean fine = false;
    private int turnoGiocatore = 1; // Inizia il giocatore 1
    
    // Metodo sincronizzato per gestire il punto
    public synchronized boolean assegnaPunto(int idGiocatore, int punti) {
        if (punti >= VITTORIA) {
            fine = true;
            System.out.println("Il giocatore " + idGiocatore + " ha vinto la partita con " + punti + " punti!");
            // Sveglia tutti i thread in attesa
            notifyAll();
            return true;
        }
        return false;
    }
    
    // Metodo per attendere il proprio turno
    public synchronized void attendiTurno(int idGiocatore) {
        while (turnoGiocatore != idGiocatore && !fine) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    
    // Metodo per passare il turno all'altro giocatore
    public synchronized void passaTurno() {
        turnoGiocatore = (turnoGiocatore == 1) ? 2 : 1;
        notifyAll();
    }
    
    public boolean isFine() {
        return fine;
    }
}