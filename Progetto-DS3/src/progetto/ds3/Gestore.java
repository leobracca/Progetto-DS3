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
    private int round = 1;
    private int n;
    private int c = 0;
    boolean combatti = true;
    private ArrayList<Personaggio>personaggi = new ArrayList<>();
    private ArrayList<Boss>boss = new ArrayList<>();
    private ArrayList<Oggetto>oggetti = new ArrayList<>();
    
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
        for(round = 1; round <= 10 && personaggi.size() >= 1; round ++){
            im.prossimo();
            System.out.println("Round: " + round);
            checkEnergia();
            if(personaggi.size() >= 1){
                stampa();
                stampaInventario();
                usaOggetto();
                puntiEnergia(+1, -1);
                generaEvento();     
            }  
        }
    }
    
    void generaEvento(){
        n = im.generaNumero(0, 101);
        if(n <= 25){
            System.out.println("Boss");
            n = im.generaNumero(0, boss.size());
            combatti(n);
        }
        
        else{
            System.out.println("Oggetti");
            gestioneOggetti();
        }
    }
    
    void combatti(int n){
        combatti = true;
        usareAbilita();
        while(combatti == true){
            puntiEnergia(-2, +3);
            stampa();
            stampaInventario();
            stampaBoss(n);
            
            im.prossimo();
            boss.get(n).setVita(personaggi.get(0).getDanni());
        
            if(boss.get(n).getVita() <= 0){
                boss.remove(n);
                combatti = false;
                puntiEnergia(10, 3);
                System.out.println("Hai vinto il combattimento");
            }

            else{
                personaggi.get(0).setVita(boss.get(n).getDanni());               
                checkSconfitto();
            }
        }
    }
    
    void usareAbilita(){
        if(personaggi.get(0).getAbilita() == true){
            String s = im.fuga();
            combatti = personaggi.get(0).usaFuga(s);
        }
    }
    
    void gestioneOggetti(){
        n = im.generaNumero(0,11);
        if(n < 6){
            addOggetti();
        }
        
        else{
            if(personaggi.get(0).sizeInventario() >= 1){
                removeOggetti();
            }
            
            else{
                personaggi.get(0).setVita(-10);
                checkSconfitto();
            }
        }
    }
    
    void addOggetti(){
        n = im.generaNumero(0, oggetti.size());        
        personaggi.get(0).addOggetti(n, oggetti);
    }
    
    void removeOggetti(){
        n = im.generaNumero(0, personaggi.get(0).sizeInventario());
        personaggi.get(0).removeOggetti(n, oggetti);
    }
    
    void usaOggetto(){
        if(personaggi.get(0).sizeInventario() >= 1){
            String s = im.sceltaOggetto();
            personaggi.get(0).usaOggetto(s);
        }
    }
    
    void checkEnergia(){
        if(personaggi.get(0).getEnergia() <= 0){
            c++;
            checkSconfitto();
        }
        
        else{
            c = 0;
        }
    }
    
    void stampa(){
        System.out.println("STATUS GIOCATORE:");
        for(Personaggio p: personaggi){
            System.out.println("Nome: " + p.getNome() + " vita: " + p.getVita() + " danni: " + p.getDanni()+ " energia: " + p.getEnergia() + " punti: " + p.getPunti());
        }
    }
    
    void stampaBoss(int n){
        for(Boss b: boss){
            if(b.getNome().equals(boss.get(n).getNome())){
                System.out.println("Nome: " + b.getNome() + " vita: " + b.getVita() + " danni: " + b.getDanni());
            }
        }
    }
    
    void puntiEnergia(int i, int j){
        personaggi.get(0).setPuntiEnergia(i, j);
    }
    
    void stampaInventario(){
        personaggi.get(0).stampaInventario();
    }
    
    void checkSconfitto(){
        if(personaggi.get(0).getVita() <= 0 || c >= 3){
            System.out.println("Sei morto");
            personaggi.remove(0);
            combatti = false;
        }
    }
}
