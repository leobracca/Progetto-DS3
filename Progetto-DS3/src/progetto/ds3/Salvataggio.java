/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;
import java.io.*;
/**
 *
 * @author lbrac
 */
public class Salvataggio {
    public static void salvaSer(Personaggio p){
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("salvataggio.ser"))){
            o.writeObject(p);
        }
        
        catch(IOException E){
            System.out.println("Impossibile salvataggio");
        }
    }
    
    public static Personaggio caricaSer() {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream("salvataggio.ser"))) {
            return (Personaggio) o.readObject();
        } catch (Exception e) {
            System.out.println("Nessun personaggio trovato");
            return null;
        }
    }
    
    public static void salvaCSV(Personaggio p, String round){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salvataggio.csv", false))) {
            String riga = p.getNome() + "," + p.getVita() + "," + p.getDanni() + "," + p.getEnergia() + "," + round + "," + p.getPunti() + "," + p.getAbilita();
            bw.write(riga);
        }
        
        catch(IOException e){
            System.out.println("Impossibile salvare csv");
        }
    }
    
    public static Personaggio caricaCSV() {
    File f = new File("salvataggio.csv");
    if (!f.exists()) {
        System.out.println("File di salvataggio non trovato.");
        return null;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea = br.readLine();
            if (linea != null && !linea.isEmpty()) {
                String[] parti = linea.split(",");

                String nome = parti[0];
                String vita = parti[1];
                String danno = parti[2];
                String energia = parti[3];
                String round = parti[4];
                String punti = parti[5];
                boolean abilita = Boolean.parseBoolean(parti[6]);

                return new Personaggio(nome, vita, danno, energia, round, punti, abilita);
            }
        } 
    
        catch (IOException | NumberFormatException e) {
            System.out.println("Errore caricamento CSV.");
        }
        return null;
    }
}
