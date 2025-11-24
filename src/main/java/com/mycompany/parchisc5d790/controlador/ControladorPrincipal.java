/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5d790.controlador;

import com.mycompany.parchisc5d790.modelo.Cronometro;
import com.mycompany.parchisc5d790.vista.GUICreditos;
import com.mycompany.parchisc5d790.vista.GUICronometro;
import com.mycompany.parchisc5d790.vista.GUIHistoria;
import com.mycompany.parchisc5d790.vista.GUIInstrucciones;
import com.mycompany.parchisc5d790.vista.GUIJuego;
import com.mycompany.parchisc5d790.vista.GUIJugador;
import com.mycompany.parchisc5d790.vista.GUIPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Sham
 */
public class ControladorPrincipal implements ActionListener{
    private GUIPrincipal guiPrincipal;
    private GUICreditos guiCreditos;
    private GUIInstrucciones guiInstrucciones;
    private GUIHistoria guiHistoria;
    private ControladorJuego controladorJuego;
    private GUIJugador guiJugador;
    private GUIJuego guiJuego;
    private AudioController audio;
    private Timer timer;
    private Cronometro cronometro;
    private GUICronometro guiCronometro;
    
    public ControladorPrincipal(){
        guiPrincipal = new GUIPrincipal(this); 
        guiPrincipal.setVisible(true);
        guiCreditos = new GUICreditos(this);
        guiInstrucciones = new GUIInstrucciones(this);
        guiHistoria = new GUIHistoria(this);
        guiJugador = new GUIJugador(this);
        audio = new AudioController();
        timer = new Timer(30, this);
        guiCronometro = new GUICronometro(this);
        cronometro = new Cronometro();
        update();
        guiCronometro.setVisible(true);
    }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "Jugar":
                    guiPrincipal.setVisible(false);
                    guiJugador.setVisible(true);
                    break;
                case "Continuar":
                    System.out.println(guiJugador.getCbColor());
                    System.out.println(guiJugador.getTxtJugador1());
                    System.out.println(guiJugador.getTxtJugador2());
                    controladorJuego = new ControladorJuego(guiPrincipal, guiJugador.getCbColor(), guiJugador.getTxtJugador1(), guiJugador.getTxtJugador2());
                    break;
                case "Instrucciones":
                    guiPrincipal.setVisible(false);
                    guiInstrucciones.setVisible(true);
                    break;
                case "AtrasInstrucciones":
                    guiPrincipal.setVisible(true);
                    guiInstrucciones.setVisible(false);
                    break;  
                case "1":
                    guiPrincipal.setVisible(false);
                    guiCreditos.setVisible(true);
                    System.out.print("Presioné el botón Creditos");
                    break;
                case "AtrasCreditos":
                    guiPrincipal.setVisible(true);
                    guiCreditos.setVisible(false);
                    break;
                case "Historia":
                    guiPrincipal.setVisible(false);
                    guiHistoria.setVisible(true);
                    break;
                case "AtrasHistoria":
                    guiPrincipal.setVisible(true);
                    guiHistoria.setVisible(false);
                    break;
                case "Salir":
                    System.exit(0);
                    break;
                case "Volumen":
                    if(audio.estaReproduciendo()){
                        audio.detener();
                    }else{
                        audio.iniciarMusica("/audios/LABUBU - OFFICIAL MV FULL SONG 2025.wav");
                    }
                    break;
                    
                   case "Iniciar":
                    cronometro.start();
                    timer.start();
                    break;
                    
                case "Detener":
                   cronometro.stop();
                   timer.stop();
                    break;
                    
                case "Pausar":
                    cronometro.reset();
                    timer.restart();
                    break;
            }
                    
        if (timer.isRunning()) {
            update();
          
             if (cronometro.getElapsedTime()>= 20000) {
                        timer.stop();
                        cronometro.stop();
                    }
        }
    }

    public void update() {
        guiCronometro.setJlTime(cronometro.getFormattedTime());
    }
    
}
