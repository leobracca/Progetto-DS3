/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;

/**
 *
 * @author braccalenti.leonardo
 */
public class Boss {
    private String nome;
    private int vita;
    private int danni;
    
    Boss(String nome, String vita, String danni) {
        this.nome = nome;
        this.vita = Integer.parseInt(vita);
        this.danni = Integer.parseInt(danni);
    }
    
        String getNome(){
        return nome;
    }
    
    Integer getVita(){
        return vita;
    }

    int getDanni() {
        return danni;
    }

    void setVita(int n) {
        vita = vita - n;
    }
}
