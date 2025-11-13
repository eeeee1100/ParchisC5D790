/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5d790.modelo;

import java.util.Random;

/**
 *
 * @author UCR
 */
public class Dado {
    private Random random;
    private int numero;
    
    public Dado(){
        this.random = new Random();
    
    }
    
    public int getNumero(){
        return numero;
    
    }
    
    public Dado(Random random, int numero){
        this.random = random;
        this.numero = numero;
    }
    
    public int tiro(){
        numero = random.nextInt(6) + 1;
        return numero;
    }
    
}

