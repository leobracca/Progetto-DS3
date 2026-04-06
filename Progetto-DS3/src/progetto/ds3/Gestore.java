 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;
import java.util.*;
import java.io.*;
/**
 *
 * @author braccalenti.leonardo
 */
public class Gestore implements Serializable{
    private int round = 0;
    private int n;
    private int c = 0;
    
    private Boss bossAttuale = null;
    
    private ArrayList<Personaggio>personaggi = new ArrayList<>();
    private ArrayList<Boss>boss = new ArrayList<>();
    private ArrayList<Oggetto>oggetti = new ArrayList<>();
    
    FileManager fm = new FileManager();
    InputManager im = new InputManager();
    
    
    void init(){
        leggiFile();
        //addPersonaggio();
        //stampa();
        //iniziaGioco();
    }
    
    void leggiFile(){
        fm.leggiPersonaggi(personaggi);
        fm.leggiBoss(boss);
        fm.leggiOggetti(oggetti);
    }
    
    void addPersonaggio(String nPersonaggio){
        for(int i = 0; i < personaggi.size(); i++){
            if(!nPersonaggio.equals(personaggi.get(i).getNome())){
                personaggi.remove(i);
                i--;
            }
        }
    }
    
    String iniziaGioco(){
        round++;
        if(round > 10){
            return "VITTORIA";
        }
        
        checkEnergia();
        puntiEnergia(1, -1);
        
        return generaEvento();
    }
    
    String generaEvento(){
        n = im.generaNumero(0, 101);
        if(n <= 25){
            n = im.generaNumero(0, boss.size());
            this.bossAttuale = boss.get(n);
            return "Boss";   
        }
        
        return gestioneOggetti();
    }
    
    String combatti(int n){
        if(bossAttuale == null){
            return "";
        }

        Personaggio p = personaggi.get(0);
        String stringa = "";
        
        puntiEnergia(-2, +3);
        
        bossAttuale.setVita(p.getDanni());
        stringa += "Attacchi il boss " + bossAttuale.getNome() + " per " + p.getDanni() + " danni \n";

        if(bossAttuale.getVita() <= 0){
            stringa += "Hai sconfitto " + bossAttuale.getNome() + ", puoi continuare \n";
            puntiEnergia(10, 3);
            bossAttuale = null;
        }

        else{
            p.setVita(bossAttuale.getDanni());               
            stringa += bossAttuale.getNome() + " ti colpisce per " + bossAttuale.getDanni() + " danni \n";
        
            if(p.getVita() <= 0){
                stringa += "SEI MORTO \n";
            }
        }
        
        
        return stringa;
    }
    
    String usareAbilita(){
        Personaggio p = personaggi.get(0);
        
        if(p.getAbilita()){
            p.usaFuga();
            this.bossAttuale = null;
            return "Abilita usata, salti il combattimento";
        }

        return "Abilita non usata";
    }
    
    String gestioneOggetti(){
        n = im.generaNumero(0,11);
        if(n < 6){
            addOggetti();
            return "Oggetto trovato";
        }
        
        else{
            if(personaggi.get(0).sizeInventario() >= 1){
                removeOggetti();
                return "Oggetto perso";
            }
            
            else{
                personaggi.get(0).setVita(-10);
                checkSconfitto();
                return "Trappola";
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
    
    String usaOggetto(){
        Personaggio p = personaggi.get(0);
        
        if(p.sizeInventario() > 0){
            int n = im.generaNumero(0, p.sizeInventario());
            String nome = p.nomeOggetto(n);
            p.usaOggetto(nome);
            return "Hai usato: " + nome;
        }
        
        return "Inventario vuoto";
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
        }
    }
    
    ArrayList<Personaggio> getPersonaggio(){
        return personaggi;
    }

    String getRound() {
        return String.valueOf(round);
    }

    String getNomeBoss() {
        if(bossAttuale == null){
            return "No boss";
        }
        
        return String.valueOf(bossAttuale.getNome());
    }
}
