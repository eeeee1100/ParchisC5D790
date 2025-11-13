/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5d790.modelo;

import java.util.ArrayList;

/**
 *
 * @author Sham
 */
public class BancoPregunta {
    private ArrayList<Pregunta> listaPreguntas;

    public BancoPregunta() {
        listaPreguntas = new ArrayList<Pregunta>();
    }
    
    public void crearPreguntas(){
        agregar(new Pregunta("¿Es San José la capital de Costa Rica?",1));
        agregar(new Pregunta("¿Un método void recibe parametros?",0));
        agregar(new Pregunta("¿Un ArrayList permite establecer un arreglo sin número establecido?",1));
        agregar(new Pregunta("¿María siempre llega temprano?",0));
        agregar(new Pregunta("¿Los atributos privados se pueden acceder desde afuera de la clase?",0));
    }
    
    public void agregar(Pregunta pregunta){
        listaPreguntas.add(pregunta);
    }
    
    public Pregunta getPregunta(int posicion){
        return listaPreguntas.get(posicion);
    }
    
    public int getElementos(){
        return listaPreguntas.size();
    }
    
    
}//Fin de la clase
