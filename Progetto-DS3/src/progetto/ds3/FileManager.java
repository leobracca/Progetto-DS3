/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;
import java.io.*;
import java.util.*;
/**
 *
 * @author braccalenti.leonardo
 */
public class FileManager {
    private String filePersonaggi = "Documenti\\File\\Personaggi.csv";
    private String fileBoss = "Documenti\\File\\Boss.csv";
    private String fileOggetti = "Documenti\\File\\Oggetti.csv";    
    
    ArrayList leggiPersonaggi(ArrayList<Personaggio>personaggi){
        try(BufferedReader read = new BufferedReader(new FileReader(filePersonaggi))){
            read.readLine();
            String line;
            while((line = read.readLine())!= null){
                String[]colonna = line.split(",");
                Personaggio p = new Personaggio(colonna[0],colonna[1],colonna[2], colonna[3]);
                personaggi.add(p);
            }
        }
        
        catch(IOException e){
            System.out.println("Impossibile leggere i personaggi");
        }  
        
        return personaggi;
    }
    
    ArrayList leggiBoss(ArrayList<Boss>boss){
        try(BufferedReader read = new BufferedReader(new FileReader(fileBoss))){
            read.readLine();
            String line;
            while((line = read.readLine()) != null){
                String[]colonna = line.split(",");
                Boss b = new Boss(colonna[0], colonna[1], colonna[2]);
                boss.add(b);
            }
        }
        
        catch(IOException e){
            System.out.println("Impossibile leggere i boss");
        }
        
        return boss;
    }
    
    ArrayList leggiOggetti(ArrayList<Oggetto>oggetti){
        try(BufferedReader read = new BufferedReader(new FileReader(fileOggetti))){
            read.readLine();
            String line;
            while((line = read.readLine()) != null){
                String[]colonna = line.split(",");
                Oggetto o = new Oggetto(colonna[0],colonna[1],colonna[2],colonna[3]);
                oggetti.add(o);
            }
        }
        
        catch(IOException e){
            System.out.println("Impossibile leggere gli oggetti");
        }
        return oggetti;
    }
}
