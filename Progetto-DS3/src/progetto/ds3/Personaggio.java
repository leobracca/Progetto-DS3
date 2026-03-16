/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;
import java.util.*;
/**
 *
 * @author braccalenti.leonardo
 */
public class Personaggio {
    private String nome;
    private int punteggio;
    private int vita;
    private int fame;
    private int danni;
    private boolean abilita;
    private ArrayList<Inventario>inventario = new ArrayList<>();

    public Personaggio(String nome, String vita, String fame, String danni) {
        this.nome = nome;
        this.vita = Integer.parseInt(vita);
        this.fame = Integer.parseInt(fame);
        this.danni = Integer.parseInt(danni);
    }
    
    
    
    String getNome(){
        return nome;
    }
}
