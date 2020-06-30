/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN
 */
public class Arbol {
    NodoLg primero,ultimo,raiz,padre;
    Object convert;
    String aux;
    
    public Arbol(){
        this.primero = null;
        this.ultimo = null;
        this.padre = null;
        this.aux = null;
        this.convert = null;
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
    
    public String retornaAux(){
        return aux;
    }
    
    public void asignaAux(String a){
        aux = a;
    }

    
    public void construyeArbol(String s){
        char c;
        int i,n;        
        NodoLg x;
        Stack<NodoLg> pila = new Stack();
        primero = new NodoLg(null);
        NodoLg ultimo1 = primero;
        c = s.charAt(1);
        String p,p1;     
        primero.asignaDato(c);        
        n = s.length();
        if (n == 2){
            return;
        }
        i = 3;                   
        while(i <= n-3){
            x = new NodoLg(null);
            ultimo1.asignaLiga(x);
            ultimo1 = x;
            p1 = Character.toString(s.charAt(i));
            p = Character.toString(s.charAt(i+1)); 
            if("(".equals(p)){
                ultimo1.asignaSw(1);
                pila.push(ultimo1);
                x = new NodoLg(p1);
                ultimo1.asignaDato(x);
                ultimo1 = x;
                i = i + 2;
            }else{
                ultimo1.asignaDato(p1);
                if(")".equals(p)){
                    i++;
                    while(i < n && ")".equals(p1) && !pila.empty() ){  //
                        ultimo1 = pila.pop();
                        i++;
                    }
                    if (",".equals(p1)) {
                        i++;
                    }
                }else{
                    i = i + 2;
                }
            }
        }        
        
        
    }
    
    public void mostrarArbol(NodoLg L, int band){
        NodoLg p,q,primero1;
        String muestra = null;
        Stack<NodoLg> pila = new Stack();
        if(L == null){
            JOptionPane.showMessageDialog(null,"LISTA VACIA");
            return;
        }
        primero1 = null;
        if (band == 0) {
            System.out.print("(" + L.retornaDato());
            if (L.retornaLiga() == null) {
                System.out.print(")");
                return;
            }
            System.out.print("(");
            primero1 = L;            
        }
        p = L.retornaLiga();
        while(p != null){
            if(p.retornaSw() == 0){
                System.out.print(p.retornaDato());
            }else{
                q = (NodoLg)p.retornaDato();
                System.out.print(q.retornaDato()+"(");
                mostrarArbol((NodoLg)p.retornaDato(),1);                
            }
            if (p.retornaLiga() != null) {                
                System.out.print(",");
            }
            p = p.retornaLiga();
        }
        System.out.print(")");
        if (primero1 == L) {
            System.out.print(")");
        }

    }
    
    
    public int altura(NodoLg raiz){
        NodoLg p;
        int g,h;
        h = 1;
        if(raiz == null)return 0;
        if(raiz.retornaLiga() == null)return 1;
        p = raiz;
        while(p != null){
            if (p.retornaSw() == 1) {
                g = altura((NodoLg)p.retornaDato());
                if (g > h) {
                    h = g;
                }
            }
            p = p.retornaLiga();
        }
        
        return h + 1;
    }
    
    public int grado(NodoLg raiz){
        if(raiz == null || raiz.retornaLiga() == null)return 0;
        int grado = 0;
        int cuenta = 0;
        int g;
        NodoLg p = raiz.retornaLiga();
        while(p != null){
            cuenta++;
            if (p.retornaSw() == 1) {
                g = grado((NodoLg)p.retornaDato());
                if (g > grado) {
                    grado = g;
                }
            }
            p = p.retornaLiga();
        }
        if (cuenta > grado) {
            grado = cuenta;
        }
        return grado;
    }
    
    public int hojas(NodoLg h){
        
        NodoLg p;
        if(h == null)return 0;
        if(h.retornaLiga() == null)return 1;
        int hojas = 0;
        p = h.retornaLiga();
        while(p != null){
            if(p.retornaSw() == 0)hojas++;
            else hojas = hojas + hojas((NodoLg)p.retornaDato());
            p = p.retornaLiga();
        }
        return hojas;
    }
    
    public void padreDeUnDato(String d){
        int n = 0;
        String c;
        NodoLg p,q;
        Stack pila = new Stack();
        p = primerNodo();
        if (p.retornaDato().equals(d)) {
            JOptionPane.showMessageDialog(null, "El dato es la raiz, por lo tanto no tiene padre");
            return;
        }
        pila.push(p.retornaDato());
        p = p.retornaLiga();
        while(p != null){
            if(p.retornaSw() == 0){
                if(p.retornaDato().equals(d)){ 
                    aux = (String)pila.pop();
                    padre = p;
                    padre.asignaDato(aux);
                    return;
                }
                p = p.retornaLiga();
            }else{
                q = (NodoLg)p.retornaDato();
                if (q.retornaDato().equals(d)) {
                    aux = (String)pila.pop();
                    padre = q;
                    padre.asignaDato(aux);
                    return;
                }else{
                    pila.push(p.retornaLiga());
                    pila.push(q.retornaDato());
                    p = q.retornaLiga();
                }
            }
//            while(p == null && !pila.empty()){
//                c = Character.toString((char)pila.pop());
//                p = (NodoLg)pila.pop();
//            }
        }
        JOptionPane.showMessageDialog(null, "Dato no esta en el árbol");
    }
    
    public Arbol copiaArbol(){ // metodo que genera una copia identica de la lista generalizada.
        Arbol c = new Arbol();
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
