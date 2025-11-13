/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5d790.modelo;

import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author Sham
 */
public class AreaJuego {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno = 1;
    private Ficha ficha;
    
    public AreaJuego(String colorJugador1, String nombreJugador1, String nombreJugador2) {
        tablero = new Tablero();
        crearJugadores(colorJugador1, nombreJugador1,nombreJugador2);
        tablero.crearCasas(colorJugador1);
        jugador1.setCasa(tablero.getCasaJugador1());
        jugador2.setCasa(tablero.getCasaJugador2());
    }
    
    public int getIndexFicha(int x, int y){
        return tablero.getIndexFicha(x,y);
    }
    
    public boolean isContains(int x, int y){
        return tablero.isContains(x,y);
    }
    
    public void crearJugadores(String colorJugador1, String nombreJugador1, String nombreJugador2){
        switch(colorJugador1){
            case "Amarillo":
                jugador1=new Jugador(nombreJugador1,colorJugador1);
                jugador2=new Jugador(nombreJugador1,"Rojo");
                break;
            case "Azul":
                jugador1=new Jugador(nombreJugador1,colorJugador1);
                jugador2=new Jugador(nombreJugador1,"Verde");
                break;
            case "Rojo":
                jugador1=new Jugador(nombreJugador1,colorJugador1);
                jugador2=new Jugador(nombreJugador1,"Amarillo");
                break;
            case "Verde":
                jugador1=new Jugador(nombreJugador1,colorJugador1);
                jugador2=new Jugador(nombreJugador1,"Azul");
                break;
        }
    }
    public void dibujar(Component component, Graphics g){
        tablero.dibujar(component, g);
    }
    
    public void realizarJugada(int x, int y){
        int numDado = 5;
        if(turno==1){
            if(jugador1.getCasa().isContains(x, y)){
                        if(numDado == 5){
                        salir(jugador1,x,y);     
                        }   
            }
                else{
                
                }
        //Turno 2 
        }else{
            if(jugador2.getCasa().isContains(x, y)){
                salir(jugador2,x,y);
            }
        }
    }//Fin del método
    
    public void salir(Jugador jugador, int x, int y){
                ficha = jugador.getCasa().getFicha(jugador.getCasa().getIndexFicha(x,y));
                tablero.setFicha(jugador1.getCasa().getSalida(), ficha);
                jugador1.getCasa().setFicha(jugador1.getCasa().getIndexFicha(x,y), null);
    }
    
    public void moverFicha(){
        
    }
}
