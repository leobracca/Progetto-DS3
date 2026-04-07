/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto.ds3;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author lbrac
 */
class Musica {
    private static Clip clip;
    
    public static void riproduci(String percorso){
        try{
            if(clip != null && clip.isRunning()){
                clip.stop();
            }
            
            File fileAudio = new File(percorso);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
            
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
        
        catch(UnsupportedAudioFileException e){
            System.out.println("Formato non valido");
        }
        
        catch(LineUnavailableException | IOException e){
            System.out.println("Errore nel caricamento");
        }
    }
}
