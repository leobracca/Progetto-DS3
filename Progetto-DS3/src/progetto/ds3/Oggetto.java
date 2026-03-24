/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;

/**
 *
 * @author braccalenti.leonardo
 */
class Oggetto {
    private String nome;
    private int vita;
    private int danni;
    private int energia;
    
    Oggetto(String nome, String vita, String danni, String energia){
        this.nome = nome;
        this.vita = Integer.parseInt(vita);
        this.danni = Integer.parseInt(danni);
        this.energia = Integer.parseInt(energia);
    }
}
