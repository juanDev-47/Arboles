/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN
 */
public class ArbolBinario {
    NodoDoble raiz;
    
    public ArbolBinario(){
        this.raiz = null;
    }
    
    public NodoDoble retornaRaiz(){
        return raiz;
    }

    
    public void contruyeABB(int s){ //metodo que genera un arbol n-ario apartir de su representacion en un String
        NodoDoble x = new NodoDoble(s);
        if(raiz == null){
            raiz = x;
            JOptionPane.showMessageDialog(null, "Ingresaste el primer dato del arbol");    
            return;
        }
        NodoDoble p,q;
        p = raiz;  // auxiliar
        q = null;  //padre
        while(true){
            q = p;
            if(s < (int)p.retornaDato()){
                p = p.retornaLi();
                if (p == null) {
                    q.asignaLi(x);
                    return;
                }
            }else{
                p = p.retornaLd();
                if (p == null) {
                    q.asignaLd(x);
                    return;
                }
            }
        }
               
    }
    
    public void recorreInorden(NodoDoble r){
        if(r != null){            
            recorreInorden(r.retornaLi());            
            System.out.print(" "+r.retornaDato());
            recorreInorden(r.retornaLd());
            
        }
    }
    
    public void recorrePreorden(NodoDoble r){
        if(r != null){            
            System.out.print(" "+r.retornaDato());            
            recorrePreorden(r.retornaLi());            
            recorrePreorden(r.retornaLd());
            
        }
    }
    
    public void recorrePosorden(NodoDoble r){
        if(r != null){            
            recorrePosorden(r.retornaLi());            
            recorrePosorden(r.retornaLd());
            System.out.print(" "+r.retornaDato());            
            
        }
    }
    
    public void contruyeAleatorio(int s){  // metodo que va insertando los datos a la izq o derecha de acuerdo a si se genera un 0 ó un 1 respectivamente.
        NodoDoble x = new NodoDoble(s);
        if(raiz == null){
            raiz = x;
            JOptionPane.showMessageDialog(null, "Ingresaste el primer dato del arbol");    
            return;
        }
        NodoDoble p,q;
        p = raiz;  
        q = null;  
        int alea;
        alea = aleatorio();
        do{
            q = p;
            if (alea == 0) {                                    
                    p = p.retornaLi();
                    if (p == null) {
                        q.asignaLi(x);
                        return;
                    }                    
                    
            }else if (alea == 1) {
                               
                p = p.retornaLd();
                if (p == null) {
                    q.asignaLd(x);
                    return;
                }                            
            }
            alea = aleatorio();
        }while(true);
               
    }
    
    public int aleatorio(){
        Random r = new Random();
        int alea = r.nextInt(2);
        
        return alea;
    }
    
    
    public void  convierteLgABinario(Arbol a){ // metodo encargado de convertir un arbol n-ario en un arbol binario
        NodoLg p,q;
        NodoDoble x,ultimo;
        Stack pila = new Stack();
        p = a.primerNodo();
        x = new NodoDoble(p.retornaDato());
        raiz = x;
        ultimo = x;
        p = p.retornaLiga();
        while(p != null){
            if (p.retornaSw() == 0) {
                x = new NodoDoble(p.retornaDato());                
            }else{
                q = (NodoLg)p.retornaDato();
                x = new NodoDoble(q.retornaDato());
                pila.push(x);
                pila.push(q.retornaLiga());
            }            
            ultimo.asignaLi(x);
            ultimo = x;
            p = p.retornaLiga();
            while(p != null){
                if (p.retornaSw() == 0) {
                    x = new NodoDoble(p.retornaDato());                    
                }else{
                    q = (NodoLg)p.retornaDato();
                    x = new NodoDoble(q.retornaDato());
                    pila.push(x);
                    pila.push(q.retornaLiga());
                }
                ultimo.asignaLd(x);
                ultimo = x;
                p = p.retornaLiga();
            }
            if (!pila.empty()) {
                p = (NodoLg)pila.pop();
                ultimo = (NodoDoble)pila.pop();
            }
        }        
    }
    
    public int hojasBinario(NodoDoble raiz){  // metodo para contar las hojas de un arbol binario
        int hh;
        hh = 0;
        if(raiz != null){
            if (raiz.retornaLi() == null && raiz.retornaLd() == null) {
                hh = hh + 1;
            }else{
                hh = hh + hojasBinario(raiz.retornaLi()) + hojasBinario(raiz.retornaLd());
            }                
        }
        return hh;
    }
    
    public int gradoB(NodoDoble raiz){  // metodo para calcular el grado de un arbol binario
        int g;
        g = 0;
        if(raiz != null){
            if(raiz.retornaLi() != null && raiz.retornaLd() != null){
                g = 2;
            }else{
                if(raiz.retornaLi() != null || raiz.retornaLd() != null){
                    g = 1;
                }
            }
            g = mayor(g, gradoB(raiz.retornaLi()));
            g = mayor(g, gradoB(raiz.retornaLd()));
        }
        
        return g;
    }
    
    public int mayor(int a, int b){
        if (a >= b) {
            return a;
        }
        
        return b;
    }
    
    public int alturaB(NodoDoble raiz){ //metodo para calcular la altura de un arbol binario
        int alti,altd;
        if(raiz == null){
            return 0;
        }
        alti = 0;
        altd = 0;
        if (raiz.retornaLi() != null) {
            alti = alturaB(raiz.retornaLi());
        }
        if (raiz.retornaLd() != null) {
            altd = alturaB(raiz.retornaLd());
        }
        return mayor(alti,altd);
    }
    
    public int distancia(int i, int j){ // metodo que calcula la distancia entre dos datos ingresados por el usuario
        if (i == j) {
            JOptionPane.showMessageDialog(null, "son los mismos datos");
            return 0;
        }
        int count = 0;
        NodoDoble p = raiz;
        NodoDoble q = p;
        if (i < (int)raiz.retornaDato() && j < (int)raiz.retornaDato()) {
            p = p.retornaLi();
            q = p;
            if (i < j) {                
                p = p.retornaLi();
                q = q.retornaLd();            
                count++;
                while(p != null){
                    if ((int)p.retornaDato() < i) {
                        p = p.retornaLi();
                        count++;
                    }else if ((int)p.retornaDato() > i) {
                        p = p.retornaLd();
                        count++;
                    }
                }
                while(q != null){
                    if ((int)q.retornaDato() < j) {
                        q = q.retornaLi();
                        count++;
                    }else{
                        q = q.retornaLd();
                        count++;
                    }
                }
                
            }else{
                p = p.retornaLd();
                q = q.retornaLi();
                
                while(p != null){
                    if ((int)p.retornaDato() < i) {
                        p = p.retornaLi();
                        count++;
                    }else if ((int)p.retornaDato() > i) {
                        p = p.retornaLd();
                        count++;
                    }
                }
                while(q != null){
                    if ((int)q.retornaDato() < j) {
                        q = q.retornaLi();
                        count++;
                    }else if ((int)q.retornaDato() > j) {
                        q = q.retornaLd();
                        count++;
                    }

                    }
                
            }    
        } // son menores que la raiz ambos datos
        
        if (i > (int)raiz.retornaDato() && j > (int)raiz.retornaDato()) {
            p = p.retornaLd();
            q = p;
            if (i < j) {                
                p = p.retornaLi();
                q = q.retornaLd();            
                count++;
                while(p != null){
                    if ((int)p.retornaDato() < i) {
                        p = p.retornaLi();
                        count++;
                    }else if ((int)p.retornaDato() > i) {
                        p = p.retornaLd();
                        count++;
                    }
                }
                while(q != null){
                    if ((int)q.retornaDato() < j) {
                        q = q.retornaLi();
                        count++;
                    }else{
                        q = q.retornaLd();
                        count++;
                    }
                }
                
            }else{
                p = p.retornaLd();
                q = q.retornaLi();
                
                while(p != null){
                    if ((int)p.retornaDato() < i) {
                        p = p.retornaLi();
                        count++;
                    }else if ((int)p.retornaDato() > i) {
                        p = p.retornaLd();
                        count++;
                    }
                }
                while(q != null){
                    if ((int)q.retornaDato() < j) {
                        q = q.retornaLi();
                        count++;
                    }else if ((int)q.retornaDato() > j) {
                        q = q.retornaLd();
                        count++;
                    }

                    }
                
            }    
        } // son mayores ambos datos que la raiz 
        
        if (i < (int)raiz.retornaDato() && j > (int)raiz.retornaDato()) {
            p = p.retornaLi();
            q = q.retornaLd();
            while(p != null){
                if ((int)p.retornaDato() < i) {
                    p = p.retornaLi();
                    count++;
                }else if ((int)p.retornaDato() > i) {
                    p = p.retornaLd();
                    count++;
                }
            }
            while(q != null){
               if ((int)q.retornaDato() < j) {
                    q = q.retornaLi();
                    count++;
                }else if ((int)q.retornaDato() > j) {
                    q = q.retornaLd();
                    count++;
                } 
            }
            
        }else{
            p = p.retornaLd();
            q = p.retornaLi();
            
            while(p != null){
                if ((int)p.retornaDato() < i) {
                    p = p.retornaLi();
                    count++;
                }else if ((int)p.retornaDato() > i) {
                    p = p.retornaLd();
                    count++;
                }
            }
            
            while(q != null){
               if ((int)q.retornaDato() < j) {
                    q = q.retornaLi();
                    count++;
                }else if ((int)q.retornaDato() > j) {
                    q = q.retornaLd();
                    count++;
                } 
            }
            
        } // un dato es mayor y el otro menor que la raiz 
        
        return count;
    }
    
    
    
}
