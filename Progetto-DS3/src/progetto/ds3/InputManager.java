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
public class InputManager {
    private String scelta;
    Scanner s = new Scanner(System.in);
    
    String sceltaPersonaggio(){
        System.out.println("Quale personaggio scegli?");
        String nPersonaggio = s.nextLine();
        
        return nPersonaggio;
    }
    
    void prossimo(){
        s.nextLine();
    }
}
