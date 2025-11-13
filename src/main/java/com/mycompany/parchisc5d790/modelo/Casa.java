/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5d790.modelo;

import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author UCR
 */
public class Casa {
    private Ficha[] fichas;
    private String color;
    private int salida;

    public Casa(String color, int salida) {
        fichas = new Ficha[4];
        this.color = color;
        this.salida = salida;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
   public void setFicha(int posicion, Ficha ficha){
       fichas[posicion] = ficha;
   } 
    
   public Ficha getFicha(int posicion){
       return fichas[posicion];
   }
   
   public void dibujar(Component component, Graphics g){
       if (fichas != null){
           for (int indice = 0;indice<fichas.length;indice ++){
               if(fichas[indice] != null){
                   fichas[indice].dibujar(component, g);
               }
           }
       }
   }
    
   public int getCantidadFichas(){
        return fichas.length;
    }
 public int getIndexFicha(int x, int y) {
       for (int index = 0; index < fichas.length; index++) {
           System.out.println(index);
            if (fichas[index] != null) {
                if (fichas[index].isContains(x, y)) {
                    System.out.println("X "+fichas[index].getPosicion().getX());
                    return index;
                }
            }
        }
        return -1;
    }
    
    public boolean isContains(int x, int y){
        for (int index = 0; index < fichas.length; index++){
            if (fichas[index] != null) {
                if (fichas[index].isContains(x,y)){
                    return true;
                }
            }
        }

    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }
    
}
