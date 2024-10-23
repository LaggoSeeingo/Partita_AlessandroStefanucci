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
        
        Giocatore g1 = new Giocatore(1);
        Thread t1 = new Thread(g1);
        t1.start();
        t1.setPriority(10);
                
                
        Giocatore g2 = new Giocatore(2);
        Thread t2 = new Thread(g2);
        t2.start();
        t2.setPriority(10);
        
    }

}
