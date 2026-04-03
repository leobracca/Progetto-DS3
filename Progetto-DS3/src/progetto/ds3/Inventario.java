/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;

/**
 *
 * @author braccalenti.leonardo
 */
public class Inventario {
    private String nome;
    private int quantita = 1;
    private int energia;
    private int vita;
    private int danni;

    Inventario(String nome, Integer vita, Integer danni, Integer energia) {
        this.nome = nome;
        this.vita = vita;
        this.danni = danni;
        this.energia = energia;
    }
    
    String getNome(){
        return nome;
    }
    
    int getQuantita(){
        return quantita;
    }
    
    void setQuantita(int q){
        quantita = quantita + q;
    }

    Integer getEnergia() {
        return energia;
    }

    Integer getVita() {
        return vita;    
    }

    Integer getDanni() {
        return danni;
    }
}
