package com.mycompany.parchisc5d790.controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Yuliana
 */
public class AudioController {
   private Clip clip;
    
    
    public void iniciarMusica(String ruta){ 
        try{
                URL url = getClass().getResource(ruta); //getClass() = clase actual,  getResource(nombreSonido)= busca un archivo de resources
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(10);
                clip.start();
            }
        catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){
            System.out.print("Error al reproducir el sonido");
        }
    }
    
    //Detiene la música si está sonando
    public void detener(){
    if (clip != null && clip.isRunning()){
        clip.stop();
    }
    }
    public boolean estaReproduciendo(){
      if(clip != null && clip.isRunning()){
  return true;
}
return false;
}
  
}
