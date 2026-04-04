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
    private int energia;
    private int danni;
    private boolean abilita = true;
    private ArrayList<Inventario>inventario = new ArrayList<>();

    public Personaggio(String nome, String vita, String energia, String danni) {
        this.nome = nome;
        this.vita = Integer.parseInt(vita);
        this.energia = Integer.parseInt(energia);
        this.danni = Integer.parseInt(danni);
    }
    
    String getNome(){
        return nome;
    }
    
    int getVita(){
        return vita;
    }

    int getEnergia() {
        return energia;
    }

    int getDanni() {
        return danni;
    }
    
    int sizeInventario(){
        return inventario.size();
    }
    
    boolean getAbilita(){
        return abilita;
    }
    
    int getPunti(){
        return punteggio;
    }

    void setVita(int n) {
        vita = vita + n;
    }
    
    void setPuntiEnergia(int i, int j){
        punteggio = punteggio + i;
        energia = energia + j;
    }
    
    void addOggetti(int n, ArrayList<Oggetto> oggetti){
        String nomeOgg = oggetti.get(n).getNome();
        boolean check = false;
        for(int j = 0; j < inventario.size(); j++){
            if(nomeOgg.equals(inventario.get(j).getNome())){
                inventario.get(j).setQuantita(+1);
                check = true;
                System.out.println("Aumentata quantita " + inventario.get(j).getQuantita());
            }
        }

        if(check == false){
            Inventario i = new Inventario(oggetti.get(n).getNome(), oggetti.get(n).getVita(), oggetti.get(n).getDanni(), oggetti.get(n).getEnergia());
            inventario.add(i);
            System.out.println("Aggiunto oggetto");
        }
        
        setPuntiEnergia(+1, 0);
    }
    
    void removeOggetti(int n, ArrayList<Oggetto> oggetti){
        String nomeOgg = inventario.get(n).getNome();
        for(int i = 0; i < inventario.size(); i++){
            if(nomeOgg.equals(inventario.get(i).getNome())){
                diminuireQuantita(i);
            }
        }
    }
    
    void usaOggetto(String s){
        for(int i = 0; i < inventario.size(); i++){
            if((inventario.get(i).getNome()).equals(s)){
                vita += inventario.get(i).getVita();
                energia += inventario.get(i).getEnergia();
                danni += inventario.get(i).getDanni();
                diminuireQuantita(i);    
            }
        }
    }
    
    void diminuireQuantita(int i){
        if(inventario.get(i).getQuantita() <= 1){
            System.out.println("Rimosso " + inventario.get(i).getQuantita());
            inventario.remove(i);
        }

        else{
            inventario.get(i).setQuantita(-1);
            System.out.println("Diminuita quantita " + inventario.get(i).getQuantita());
        }
        
        setPuntiEnergia(-2, -1);
    }
    
    boolean usaFuga(String s){
        if("si".equals(s)){
            abilita = false;
            System.out.println("Abilita usata, salti il combattimento");
            setPuntiEnergia(-5, +1);
            return false;
        }
        
        else{
            return true;
        }
    }
    
    void stampaInventario(){
        System.out.println("INVENTARIO:");
        for(Inventario i: inventario){
            System.out.println("Nome: " + i.getNome() + ", Quantita: " + i.getQuantita() + ", Energia: " + i.getEnergia() + ", Vita: " + i.getVita() + ", Danni: " + i.getDanni());
        }
        
        System.out.println();
    }
}
