/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package partita_pallavolo;

/**
 *
 * @author B045_14
 */
public class partita_pallavolo {
    
    public static void main(String[] args) {
        
        Arbitro arbitro = new Arbitro();
        
        Giocatore g1 = new Giocatore(1, arbitro);
        Thread t1 = new Thread(g1);
        
        Giocatore g2 = new Giocatore(2, arbitro);
        Thread t2 = new Thread(g2);
        
        System.out.println("Inizio partita!");
        
        t1.start();
        t1.setPriority(10);
        
        t2.start();
        t2.setPriority(10);
        
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Errore, partita interrotta!");
        }
        
        System.out.println("Fine partita!");
        
    }

}
