/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5d790.controlador;

import com.mycompany.parchisc5d790.modelo.AreaJuego;
import com.mycompany.parchisc5d790.modelo.Ficha;
import com.mycompany.parchisc5d790.modelo.Posicion;
import com.mycompany.parchisc5d790.vista.GUIJuego;
import com.mycompany.parchisc5d790.vista.GUIPrincipal;
import com.mycompany.parchisc5d790.vista.PanelControl;
import com.mycompany.parchisc5d790.vista.PanelJuego;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

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
    private Posicion posicion;
    
    public ControladorJuego(GUIPrincipal guiPrincipal, String colorJugador1, String nombreJugador1, String nombreJugador2){
        this.guiPrincipal=guiPrincipal;
        panelJuego=guiJuego.getPanelJuego();
        panelControl=guiJuego.getPanelControl();
        guiJuego = new GUIJuego(this);
        guiJuego.setVisible(true);
        areaJuego = new AreaJuego(colorJugador1,nombreJugador1, nombreJugador2);
        ficha = new Ficha(new Posicion(453,468),new ImageIcon("./src/main/resources/img/piecered.png"),"Amarillo");
    }

    public void dibujar(Component c, Graphics g){
        ficha.dibujar(c,g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Dado":
                System.out.println("Presionó el dado");
                break;
            case "JButton1":
                 guiJuego.dispose();
                 guiPrincipal.setVisible(true);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X "+e.getX()+" Y "+e.getY());
        ficha.getPosicion().setX(e.getX());
        ficha.getPosicion().setY(e.getY());
        panelJuego.repaint();
    }
    
    posicion = new Posicion(e.getX(),e.getY())

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
}
