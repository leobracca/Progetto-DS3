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
    private ArrayList<Boss>boss = new ArrayList<>();
    private ArrayList<Combattimento>combattenti = new ArrayList<>();
    
    FileManager fm = new FileManager();
    InputManager im = new InputManager();
    
    
    void init(){
        leggiFile();
        addPersonaggio();
        stampa();
        iniziaGioco();
    }
    
    void leggiFile(){
        fm.leggiPersonaggi(personaggi);
        fm.leggiBoss(boss);
    }
    
    void addPersonaggio(){
        String nPersonaggio = im.sceltaPersonaggio();
        
        for(int i = 0; i < personaggi.size(); i++){
            if(!nPersonaggio.equals(personaggi.get(i).getNome())){
                personaggi.remove(i);
                i--;
            }
        }
    }
    
    void iniziaGioco(){
        for(int i = 0; i < 10; i++){
            generaEvento();
            round++;
            System.out.println("Round: " + round);
            stampa();
            im.prossimo();
        }
    }
    
    void generaEvento(){
        int n = im.generaNumero(0, 101);
        if(n <= 50){
            n = im.generaNumero(0, boss.size());
            addCombattenti(n);
        }
        
        else{
            
        }
    }
    
    void addCombattenti(int n){
        Combattimento c1 = new Combattimento(personaggi.get(0));
        combattenti.add(c1);
        int i = 0;
        for(Boss b: boss){
            if(i == n){
                Combattimento c2 = new Combattimento(boss.get(n));
                combattenti.add(c2);
            }
        }
    }
    
    void stampa(){
        for(Personaggio p: personaggi){
            System.out.println("Nome: " + p.getNome() + " vita: " + p.getVita() + " danni: " + p.getDanni()+ " fame: " + p.getFame());
        }
    }
}
