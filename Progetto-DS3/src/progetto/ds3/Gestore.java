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
    private int n;
    private ArrayList<Personaggio>personaggi = new ArrayList<>();
    private ArrayList<Boss>boss = new ArrayList<>();
    private ArrayList<Oggetto>oggetti = new ArrayList<>();
    private ArrayList<Combattimento>combattenti = new ArrayList<>();
    private ArrayList<Inventario>inventario = new ArrayList<>();
    
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
        fm.leggiOggetti(oggetti);
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
        n = im.generaNumero(0, 101);
        if(n <= 50){
            n = im.generaNumero(0, boss.size());
            addCombattenti(n);
            combatti();
        }
        
        else{
            gestioneOggetti();
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
    
    void combatti(){
        for(Combattimento c: combattenti){
            
        }
    }
    
    void gestioneOggetti(){
        n = im.generaNumero(0,11);
        if(n < 6){
            boolean check = false;
            n = im.generaNumero(0, oggetti.size());
            String nome = oggetti.get(n).getNome();
            for(int i = 0; i < oggetti.size(); i++){
                for(int j = 0; j < inventario.size(); j++){
                    if(nome.equals(inventario.get(j).getNome())){
                        inventario.get(j).setQuantita();
                        check = true;
                    }
                }
            }

            if(check == false){
                Inventario i = new Inventario();
                inventario.add(i);
                inventario.get(inventario.size()-1).setQuantita();
            }
        }
        
        else{
            n = im.generaNumero(0, inventario.size());
            String nome = inventario.get(n).getNome();
            for(int i = 0; i < inventario.size(); i++){
                if(nome.equals(inventario.get(i).getNome())){
                    if(inventario.get(i).getQuantita() <= 1){
                        inventario.remove(i);
                    }
                    
                    else{
                        inventario.get(i).setQuantita();
                    }
                }
            }
        }
    }
    
    void stampa(){
        for(Personaggio p: personaggi){
            System.out.println("Nome: " + p.getNome() + " vita: " + p.getVita() + " danni: " + p.getDanni()+ " energia: " + p.getEnergia());
        }
    }
}
