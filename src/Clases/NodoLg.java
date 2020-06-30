/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author JUAN
 */
public class NodoLg {
    private int sw;
    private Object dato;
    private NodoLg liga;
    public String aux;
    
    NodoLg(Object dato){
        this.dato = dato;
        this.sw = 0;
        this.liga = null;
    }
    
    public Object retornaDato(){
        return dato;
    }
    
    public int retornaSw(){
        return sw;
    }
    
    

    public NodoLg retornaLiga(){
        return liga;
    }

    public void asignaDato(Object d){
        dato= d;
    }

    public void asignaLiga(NodoLg x) {
        liga = x;
    }
    
    public void asignaSw(int i){
        sw = i;
    }
    
}
