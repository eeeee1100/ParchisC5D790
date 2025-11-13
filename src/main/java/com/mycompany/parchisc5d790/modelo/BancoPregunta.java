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
        agregar(new Pregunta("¿Estás vivo?",1));
        agregar(new Pregunta("¿Te gusta la carrera de ITM?",0));
        agregar(new Pregunta("¿Se puede comer un pollito asado a la leña, con una coca fría y arroz blanco en el laboratorio?",1));
        agregar(new Pregunta("¿María siempre llega temprano?",0));
        agregar(new Pregunta("¿Eres un ser consciente, ergo eres?",1));
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
