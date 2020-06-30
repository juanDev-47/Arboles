/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Stack;

/**
 *
 * @author JUAN
 */
public class ListaG {
    NodoLg primero,ultimo;
    
    public ListaG(){
        primero = null;
        ultimo = null;
    }
    
    public boolean esVacia(){
        return primero == null;
    }
    
    public NodoLg primerNodo(){
        return primero;
    }
    
    public NodoLg ultimoNodo(){
        return ultimo;
    }
    
    public boolean finDeRecorrido(NodoLg x){
        return x == null;
    }
    
    public void constLg(String s){ // se construye la lista generalizada a partir de un String ingresado por el usuario.
        char c;
        Stack<NodoLg> pila = new Stack();
        NodoLg x = new NodoLg(null);
        ultimo = x;
        primero = x;
        int n = s.length();
        for (int i = 1; i < n-1; i++) {
            c = s.charAt(i);
            String p = Character.toString(c);
            switch(p){
                
                case ",":
                    x = new NodoLg(null);
                    ultimo.asignaLiga(x);
                    ultimo = x;                    
                    
                    break;
                    
                case "(":
                    pila.push(ultimo);
                    x = new NodoLg(null);
                    ultimo.asignaSw(1);
                    ultimo.asignaDato(x);
                    ultimo = x;
                    break;
                    
                case ")":
                    ultimo = pila.pop();
                    break;
                    
                default:
                    ultimo.asignaSw(0);
                    ultimo.asignaDato(p);
                    break;
                
            }                
        }
        
    }
    
    public void mostrarLista(NodoLg p){ // metodo que se encarga de recorrer la lista e ir imprimiendo los datos en ella 
        System.out.print("(");
        while(!finDeRecorrido(p)){
            if (p.retornaSw() == 0) {
                System.out.print(p.retornaDato());
            }else{
                mostrarLista((NodoLg)p.retornaDato());
            }
            if (p.retornaLiga() != null) {
                System.out.print(",");
            }
            p = p.retornaLiga();            
        }
        System.out.print(")");
    }
    
    public ListaG copiaLg(){ // metodo que genera una copia identica de la lista generalizada.
        ListaG c = new ListaG();
        c.primero = copia(primerNodo());
        return c;
    }
    
    public NodoLg copia(NodoLg p){
        NodoLg x;
        x = null;
        if (p != null) {
            x = new NodoLg(null);
            if (p.retornaSw() == 1) {
                x.asignaSw(1);
                x.asignaDato(copia((NodoLg)p.retornaDato()));                
            }else{
                x.asignaDato(p.retornaDato());
            }            
        }
        return x;
    }    
    
    
}
