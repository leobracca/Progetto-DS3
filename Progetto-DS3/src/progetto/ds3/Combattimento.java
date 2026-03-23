/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;

/**
 *
 * @author braccalenti.leonardo
 */
public class Combattimento {
    String nome;
    int vita;
    int danni;
    
    Combattimento(Personaggio p) {
        this.nome = p.getNome();
        this.vita = p.getVita();
        this.danni = p.getDanni();
    }
    
    Combattimento(Boss b){
        this.nome = b.getNome();
        this.vita = b.getVita();
        this.danni = b.getDanni();
    }
    
}
