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
public class NodoDoble {
    private  Object dato;
    private NodoDoble li, ld;

    public NodoDoble(Object dato) {
        this.dato = dato;
        this.li = null;
        this.ld = null;
    }

    public Object retornaDato(){
        return dato;
    }

    public NodoDoble retornaLi(){
        return li;
    }

    public NodoDoble retornaLd(){
        return ld;
    }

    public void asignaDato(Object d){
        dato= d;
    }

    public void asignaLd(NodoDoble x) {
        ld=x;
    }

    public void asignaLi(NodoDoble x) {
        li=x;
    }


}
