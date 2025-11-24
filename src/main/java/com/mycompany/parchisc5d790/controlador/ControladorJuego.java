/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5d790.controlador;

import com.mycompany.parchisc5d790.modelo.AreaJuego;
import com.mycompany.parchisc5d790.modelo.Cronometro;
import com.mycompany.parchisc5d790.modelo.Dado;
import com.mycompany.parchisc5d790.modelo.Ficha;
import com.mycompany.parchisc5d790.modelo.Posicion;
import com.mycompany.parchisc5d790.modelo.Pregunta;
import com.mycompany.parchisc5d790.vista.GUIGameOver;
import com.mycompany.parchisc5d790.vista.GUIJuego;
import com.mycompany.parchisc5d790.vista.GUIPrincipal;
import com.mycompany.parchisc5d790.vista.GUIWin;
import com.mycompany.parchisc5d790.vista.PanelControl;
import com.mycompany.parchisc5d790.vista.PanelJuego;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Sham
 */
public class ControladorJuego implements ActionListener, MouseListener {

    
    
    
    private GUIJuego guiJuego;
    private PanelJuego panelJuego;
    private PanelControl panelControl;
    private GUIPrincipal guiPrincipal;
    private Ficha ficha;
    private AreaJuego areaJuego;
    private Dado dado;
    private GUIGameOver guiGameOver;
    private GUIWin guiWin;
    private Cronometro cronometro;
    
    
    private int resultadoDado = 0;
    private boolean turnoTerminado = true;

    public ControladorJuego(GUIPrincipal guiPrincipal, String colorJugador1, String nombreJugador1,  String nombreJugador2) {
        this.guiPrincipal = guiPrincipal;
        guiJuego = new GUIJuego();
        guiGameOver = new GUIGameOver();
        guiWin = new GUIWin();
        panelJuego = guiJuego.getPanelJuego();
        areaJuego = new AreaJuego(colorJugador1,nombreJugador1,nombreJugador2);
        panelControl = guiJuego.getPanelControl();
        panelControl.setJlNombreJugador1(nombreJugador1);
        panelControl.setJlNombreJugador2(nombreJugador2);
        panelControl.escuchar(this);
        panelJuego.escuchar(this);
        dado = new Dado();
        guiJuego.setVisible(true);
        
        //Aficha = new Ficha(new Posicion(100, 100), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Amarillo");
        //453,468
    }

    public void dibujar(Component c, Graphics g) {

        //ficha.dibujar(c, g);
        areaJuego.dibujar(c, g);

    }

    
    private void hacerPregunta(){
        Pregunta pregunta = areaJuego.getPreguntaAleatroia();
        if (pregunta == null){
        System.out.println("Error: No hay preguntas en el banco.");
        return;
        }
        
        int respuestaCorrecta = pregunta.isRespuesta();
        String enunciado = pregunta.getEnunciado();
        
        int respuestaUsuarioInt = JOptionPane.showConfirmDialog(guiJuego,enunciado,"Pregunta",JOptionPane.YES_NO_OPTION);
        
        boolean acierto = (respuestaUsuarioInt == respuestaCorrecta);
        
        if (acierto) {
            JOptionPane.showMessageDialog(guiJuego, "!Respuesata correcta! +1 punto.");
            areaJuego.aplicarResultadoPregunta(true);

        } else {
            JOptionPane.showMessageDialog(guiJuego, "!Respuesata incorrecta! -1 punto.");
            areaJuego.aplicarResultadoPregunta(false);
        }
    }
    
    private void finalizarTurno(){
        System.out.println("Turno finalizado");
        turnoTerminado = true;
        resultadoDado = 0;
        panelJuego.repaint();
    
    }
//    
//       public void Controlador() {
//
//        timer = new Timer(30, this);
//        panelControl = new PanelControl(this);
//        cronometro = new Cronometro();
//        update();
//        frame.setVisible(true);
//    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Dado":
                if(turnoTerminado){
                    resultadoDado = dado.tiro();
                    System.out.println("Resultado de dado:" + resultadoDado);
                    String rutaImagen = "/img/dado" + resultadoDado + ".1.png";
                    ImageIcon iconoDado = new ImageIcon(getClass().getResource(rutaImagen));
                    javax.swing.JButton btn = panelControl.getBtnDado();
                    btn.setIcon(iconoDado);
                    btn.setText("");
                    panelJuego.repaint();
                    
                    turnoTerminado = false;
                    
                    
                    if(resultadoDado == 5){
                        
                        System.out.println("Jugador 1: !Saca o mueve una ficha!");
                        
                    } else {
                    
                        System.out.println("Jugador 1: Mueve " + resultadoDado + " casillas.");
                    
                    }
                
                } else {
                
                    System.out.println("Debes mover una ficha antes de volver a tirar el dado.");
                
                }
                break;

            case "AtrasJuego":
                guiJuego.dispose();
                guiPrincipal.setVisible(true);
                break;
                
                
             case "Menu":
                guiPrincipal.setVisible(true);
                guiGameOver.setVisible(false);
                break;   
            
             case "MenuWin":
                guiPrincipal.setVisible(true);
                guiGameOver.setVisible(false);
                break;
                
            case "Reiniciar":
                
                break;
                
            case "ReiniciarWin":
                
                break;

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X " + e.getX() + " Y " + e.getY());
        
        if (turnoTerminado) {
            System.out.println("Espera, debes lanzar el dado primero.");
            return;
        }
        
        if (resultadoDado == 5){
        
            int indexFichaCasa = areaJuego.getIndexFicha(e.getX(), e.getY());
            if (indexFichaCasa != -1){
            System.out.println("Moviendo ficha en indice de casa: " + indexFichaCasa); 
            areaJuego.sacarFicha(indexFichaCasa);
            
            finalizarTurno();
            return;
            
            }
            
        }
        
        int indiceCelda = areaJuego.getIndexFichaEnTablero(e.getX(), e.getY());
        if (indiceCelda != -1) {
            System.out.println("Moviendo ficha de celda " + indiceCelda + " " + resultadoDado + "pasos.");
            int nuevaCeldaIndice = areaJuego.moverFicha(indiceCelda, resultadoDado);
            panelJuego.repaint();
            if (areaJuego.isCeldaNormal(nuevaCeldaIndice)){
                System.out.println("Casilla normal, mostrando pregunta!");
                hacerPregunta();
            } else {
                System.out.println("Casilla especial, turno seguro.");
            }
            
            finalizarTurno();
            return;
        
        }
        
        System.out.println("Click en un area no valida. Intenta de nuevo.");
        

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand() != null) {
//            switch (e.getActionCommand()) {
//                case "Iniciar":
//                     
//                    cronometro.start();
//                    timer.start();
//                   
//                    break;
//                case "Detener":
//
//                   cronometro.stop();
//                   timer.stop();
//                    break;
//                case "Pausar":
//                    cronometro.reset();
//                    timer.restart();
//                    break;
//
//            }
//
//        }
//        if (timer.isRunning()) {
//            update();
//          
//             if (cronometro.getElapsedTime()>= 20000) {
//                        timer.stop();
//                        cronometro.stop();
//                    }
//        }
//    }
//
//    public void update() {
//
//        frame.setJlTime(cronometro.getFormattedTime());
//    }
//    
//    

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}//Fin de la clase
