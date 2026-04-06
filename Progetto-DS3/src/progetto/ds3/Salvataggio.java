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
}
