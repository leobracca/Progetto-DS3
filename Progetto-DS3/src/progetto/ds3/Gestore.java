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
public class Gestore {
    private int round = 0;
    private ArrayList<Personaggio>personaggi = new ArrayList<>();
    FileManager fm = new FileManager();
    InputManager im = new InputManager();
    
    
    void init(){
        addPersonaggio();
        stampa();
    }
    
    void addPersonaggio(){
        fm.leggiPersonaggi(personaggi);
        String nPersonaggio = im.sceltaPersonaggio();
        
        for(int i = 0; i < personaggi.size(); i++){
            if(!nPersonaggio.equals(personaggi.get(i).getNome())){
                personaggi.remove(i);
                i--;
            }
        }
    }
    
    void stampa(){
        for(Personaggio p: personaggi){
            System.out.println("Nome: " + p.getNome() + " vita: " + p.getVita() + " danni: " + p.getDanni()+ " fame: " + p.getFame());
        }
    }
}
