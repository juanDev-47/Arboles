/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 
 */
package Clases;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN PABLO ARENAS VELEZ 
 * cedula 1037633965
 */

public class main {
    public static void main(String[] args) {
        boolean salir = false;  
        int j = 0;
        int opcion; //Guardaremos la opcion del usuario
        int f1;
        int c1;
        int v;

        
      
           do{
               try{
           opcion =  Integer.parseInt(JOptionPane.showInputDialog("        Escribe una de las opciones\n\n"
                                                                + "1. Crear Lista Generalizada.\n"
                                                                + "2. Crear Arboles n-arios\n"
                                                                + "3. Crear Arboles Binarios\n"
                                                                + "4. Salir"
                                                                
                                                                 ));
            

        switch(opcion){    // menu principal
                case 1:   // Crear Listas Generalizadas
                    try{
                        ListaG L = new ListaG();
                        ListaG L1 = new ListaG();
                        int opcion2; 
                        String s;
                        boolean a = true;
                        do{
                            opcion2 =  Integer.parseInt(JOptionPane.showInputDialog("        Menu Listas generalizadas\nEscribe una de las opciones \n"  
                                                                     + "\n\n1. Construir Lista.\n"
                                                                     + "2. Mostrar lista\n"
                                                                     + "3. Copiar lista\n"
                                                                     + "4. salir\n"
                                                                      ));
                            switch(opcion2){
                                case 1: 
                                      s = (JOptionPane.showInputDialog("Ingrese la cadena para convertir\nen lista generalizada\nejemplo: (a,b,c,(d,e),f,g)"));
                                      L.constLg(s); // mediante el metodo constLg(s) que recibe como parametro un string se crea la lista generalizada
                                      JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                                      

                                    break;

                                case 2:
                                    System.out.println("\nRepresentacion como hilera de la lista generalizada");
                                    L.mostrarLista(L.primerNodo());
                                    System.out.println("");

                                    break;
                                    
                                case 3:                                        
                                      L1 = L.copiaLg(); // generamos una copia de la lista L previamente generada y queda en el objeto L1
                                      JOptionPane.showMessageDialog(null,"Lista copiada");
                                      System.out.println("");    
                                      System.out.println("Lista copia de la original, se hace uso del metodo copiaLg() y se muestra");
                                      L1.mostrarLista(L.primerNodo());
                                      System.out.println("");
                                      
                                      
                                    
                                    break;    

                                case 4:
                                    
                                    a = false;
                                    break;
                                    
                                default:
                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");

                            }

                        }while(a == true);




                        }
                        catch(NumberFormatException w){
                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                        }
                        break;
                case 2:  // todo Crear Arboles
                    try{  
                        String s;
                        Arbol A1 = new Arbol();
                        Arbol A = new Arbol();
                        Arbol C = new Arbol();
                        Arbol B = new Arbol();
                        
                        int opcion2; 
                        boolean a = true;
                        do{  // sub-menu de la opcion 2 (arboles n-arios)
                            opcion2 =  Integer.parseInt(JOptionPane.showInputDialog("        Menu Arboles n-arios\nEscribe una de las opciones" 
                                                                     + "\n\n1. Construir Arbol n-ario.\n"
                                                                     + "2. Mostrar arbol en hilera\n"
                                                                     + "3. Crear copia del arbol\n"                                                                     
                                                                     + "4. Mostar la cantidad de hojas del arbol\n"
                                                                     + "5. Mostrar el Grado del arbol\n"
                                                                     + "6. Mostrar la altura del arbol\n"
                                                                     + "7. Crear arbol binario de busqueda a partir\nde un arbol representado en listas generalizadas\n"
                                                                     + "8. Ingresar dos datos y ver si son primos\n"
                                                                     + "9. Salir"
                                                                      ));
                            switch(opcion2){
                                case 1:
                                    s = (JOptionPane.showInputDialog("Ingrese la cadena para convertir\nen un Arbol representado en LG\nejemplo: (a(b,c(a,e),f,g))\nnotar que son diferentes a las lista G"));
                                    A1.construyeArbol(s);
                                    A.construyeArbol(s);
                                    JOptionPane.showMessageDialog(null,"Arbol creado con exito");
                                    C.construyeArbol(s);
                                    B.construyeArbol(s);

                                    break;

                                case 2:
                                    JOptionPane.showMessageDialog(null,"Arbol representado como hilera");
                                    System.out.println("");
                                    System.out.println("Representacion de un arbol como cadena de caracteres");
                                    A1.mostrarArbol(A1.primerNodo(), 0);
                                    System.out.println("");


                                    break;
                                    
                                case 3:
                                    if (A1.primerNodo() == null) {
                                        JOptionPane.showMessageDialog(null, "se debe crear un arbol n-ario primero");
                                        break;
                                    }
                                    Arbol copia;
                                    copia = A1.copiaArbol();
                                    JOptionPane.showMessageDialog(null, "copia del Arbol generada");
                                    System.out.println("\ncopia del arbol creado, mostramos su resultado");
                                    copia.mostrarArbol(A1.primerNodo(), 0);
                                    System.out.println("");

                                    break;
                                    
                                case 4:
                                    JOptionPane.showMessageDialog(null,"La cantidad de hojas en el arbol es: " + B.hojas(B.primerNodo()));

                                    break;
                                
                                case 5:
                                    int q = C.grado(C.primerNodo());
                                    JOptionPane.showMessageDialog(null,"el grado del arbol es: " + q );
                                    
                                    
                                    break;    

                                case 6:                                   
                                    int altura = C.altura(C.primerNodo());
                                    JOptionPane.showMessageDialog(null, "La altura del arbol es: " + altura);
                                    
                                    break;    
                                
                                case 7:                                   
                                    Arbol AcB = new Arbol();
                                    ArbolBinario ab = new ArbolBinario();
                                    String s1 = (JOptionPane.showInputDialog("Ingrese la cadena para convertir\nen un Arbol representado en LG\nejemplo: (a(b,c(a,e),f,g))\nnotar que son diferentes a las lista G"));
                                    AcB.construyeArbol(s1);
                                    JOptionPane.showMessageDialog(null,"Arbol creado con exito");
                                    ab.convierteLgABinario(AcB);
                                    System.out.println("\nArbol binario en preorden a partir de una arbol\nrepresentado como lista generalizada\n");
                                    ab.recorrePreorden(ab.retornaRaiz());                                    
                                    JOptionPane.showMessageDialog(null, "\naltura del arbol binario: " + ab.alturaB(ab.retornaRaiz()) + "\n"+ "grado del arbol binario: " + ab.gradoB(ab.retornaRaiz()) + "\n" + "hojas del arbol binario: " + ab.hojasBinario(ab.retornaRaiz()));
                                    
                                    
                                    break;    
                                
                                case 8:     
                                    try{
                                        if (A.primerNodo() == null) {
                                        JOptionPane.showMessageDialog(null, "Primero se debe construir el arbol n-ario");
                                        break;
                                        }
                                        NodoLg p1,p2,abuelo1,abuelo2;
                                        String primo1 = (JOptionPane.showInputDialog("Ingrese el primer dato a comparar"));
                                        String primo2 = (JOptionPane.showInputDialog("Ingrese el segundo dato a comparar"));
                                        A.padreDeUnDato(primo1); // determinamos el padre del primer dato
                                        p1 = A.padre; // guardamos el nodo que contiene el padre del primer dato
                                        String s11 = (String)p1.retornaDato();
                                        A.padreDeUnDato(primo2);
                                        p2 = A.padre;
                                        String s12 = (String)p2.retornaDato();
                                        if (s11 == s12) {
                                            JOptionPane.showMessageDialog(null, "los datos son hermanos, vienen del mismo padre: " + s11);
                                            break;
                                        }
                                        A.padreDeUnDato(s11); // volvemos a consultar el padre pero del dato padre que ya habiamos consultado
                                        abuelo1 = A.padre; // este seria el abuelo del primero dato consultado, si este dato coincide con el padre del dato p2 nos daremos cuenta si son o no primos
                                        String a12 = (String)abuelo1.retornaDato();
                                        A.padreDeUnDato(s12);
                                        abuelo2 = A.padre;
                                        String a11 = (String)abuelo2.retornaDato();
                                        if (a12 == a11) {
                                        JOptionPane.showMessageDialog(null, "Los datos " + primo1 + " y " + primo2 + " son primos");
                                        }else{
                                        JOptionPane.showMessageDialog(null, "Los datos " + primo1 + " y " + primo2 + " no son primos");
                                        }
                                        }catch(ClassCastException w){
                                            JOptionPane.showMessageDialog(null,"Solo muestra quien es el padre de los datos si son hermanos\n presenta un error pero no lo detecte");
                                            break;
                                        }
                                    
                                    break;    
                                    
                                case 9:                                   
                                    
                                    a = false;
                                    break;    

                                default:
                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 9");

                            }

                        }while(a == true);




                        }
                        catch(NumberFormatException w){
                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                        }
                   
                   break;  
                case 3: // Crear Arboles Binarios
                     try{

                        
                        int opcion2; 
                        boolean a = true;
                        do{ // sub-menu de la opcion 3 del menu principal
                            opcion2 =  Integer.parseInt(JOptionPane.showInputDialog("        Menu arboles binarios\nEscribe una de las opciones\n" 
                                                                     + "\n\n1. Crear arbol binario de busqueda.\n"
                                                                     + "2. Crear arbol binario de forma aleatoria\n"                                                                     
                                                                     + "3. salir\n"
                                                                      ));
                            switch(opcion2){
                                case 1:  //Crear arbol binario de busqueda
                                    try{
                                        
                                        int opcion3; 
                                        ArbolBinario Bn = new ArbolBinario();
                                        int dato;
                                        boolean a1 = true;
                                        do{  // sub-menu de la opcion 1 del sub-menu de arboles binarios
                                            opcion3 =  Integer.parseInt(JOptionPane.showInputDialog("        Menu Arbol de busqueda\nEscribe una de las opciones" 
                                                                                     + "\n\n1. Construir Arbol.\n"
                                                                                     + "2. Mostrar arbol en Inorden\n"
                                                                                     + "3. Mostrar arbol en Preorden\n"
                                                                                     + "4. Mostrar arbol en Posorden\n"
                                                                                     + "5. Distancia entre cada par de hojas\n"
                                                                                     + "6. Distancia entre dos datos ingresados por el usuario\n"
                                                                                     + "7. Salir"                                                                     

                                                                                      ));
                                            switch(opcion3){
                                                case 1:
                                                    try{
                                                        boolean z = true;
                                                        int opc;
                                                        
                                                        do {
                                                            opc = Integer.parseInt((JOptionPane.showInputDialog("1. ingresar dato\n"
                                                                                                              + "2. no ingresar mas datos")));
                                                            switch(opc){
                                                                case 1:
                                                                    opc = Integer.parseInt((JOptionPane.showInputDialog("cual dato desea ingresar, (solo datos numericos)")));
                                                                    Bn.contruyeABB(opc);
                                                                    break;
                                                                case 2:
                                                                    z = false;
                                                                    break;
                                                                default:
                                                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 2");    
                                                            }
                                                            
                                                            
                                                        } while (z == true);
                                                        
                                                        
                                                    }catch(NumberFormatException w){
                                                         JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                                                        }
                                                    
                                                    break;

                                                case 2:
                                                    if (Bn.retornaRaiz() == null) {
                                                        JOptionPane.showMessageDialog(null, "no se ha ingresado ningun dato aun");
                                                        break;
                                                    }
                                                    System.out.println("\nDatos en inorden");
                                                    Bn.recorreInorden(Bn.retornaRaiz());
                                                    System.out.println("");

                                                    break;
                                                case 3:
                                                    if (Bn.retornaRaiz() == null) {
                                                        JOptionPane.showMessageDialog(null, "no se ha ingresado ningun dato aun");
                                                        break;
                                                    }
                                                    System.out.println("\nDatos en preorden");
                                                    Bn.recorrePreorden(Bn.retornaRaiz());
                                                    System.out.println("");

                                                    break;
                                                    
                                                case 4:
                                                    if (Bn.retornaRaiz() == null) {
                                                        JOptionPane.showMessageDialog(null, "no se ha ingresado ningun dato aun");
                                                        break;
                                                    }
                                                    System.out.println("\nDatos en posorden");
                                                    Bn.recorrePosorden(Bn.retornaRaiz());
                                                    System.out.println("");

                                                    break;    

                                                case 5:// distancia entre cada uno de los arboles
//                                                    Bn.distanciaEntreArboles();
                                                    break;
                                                    
                                                case 6: // distancia entre dos datos ingresados por el usuario
                                                    int i = Integer.parseInt((JOptionPane.showInputDialog("ingresar primer dato")));
                                                    int j1 = Integer.parseInt((JOptionPane.showInputDialog("ingresar segundo dato")));
                                                    int dist1 = Bn.distancia(i,j1);
                                                    JOptionPane.showMessageDialog(null, "la distancia entre los dos datos es: " + dist1);
                                                    break;
                                                    
                                                case 7:
                                                    a1 = false;
                                                    break;

                                                default:
                                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");

                                            }

                                        }while(a1 == true);

                                    }catch(NumberFormatException w){
                                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                                        }
                                            break;

                                            
                                        case 2: //Crear arbol binario de forma aleatoria
                                            try{
                                        
                                        int opcion3; 
                                        ArbolBinario Ba = new ArbolBinario();
                                        int dato;
                                        boolean a1 = true;
                                        do{  // sub-menu de la opcion 1 del sub-menu de arboles binarios
                                            opcion3 =  Integer.parseInt(JOptionPane.showInputDialog("        Menu Arbol aleatorio\nEscribe una de las opciones" 
                                                                                     + "\n\n1. Construir Arbol.\n"
                                                                                     + "2. Mostrar arbol en Inorden\n"
                                                                                     + "3. Mostrar arbol en Preorden\n"
                                                                                     + "4. Mostrar arbol en Posorden\n"
                                                                                     + "5. Distancia entre cada par de datos\n"
                                                                                     + "6. Distancia entre dos datos ingresados por el usuario\n"
                                                                                     + "7. Salir"                                                                     

                                                                                      ));
                                            switch(opcion3){
                                                case 1:
                                                    try{
                                                        boolean z = true;
                                                        int opc;
                                                        
                                                        do {
                                                            dato = Integer.parseInt((JOptionPane.showInputDialog("1. ingresar dato\n"
                                                                                                              + "2. no ingresar mas datos")));
                                                            switch(dato){
                                                                case 1:
                                                                    opc = Integer.parseInt((JOptionPane.showInputDialog("cual dato desea ingresar, (solo datos numericos)")));
                                                                    Ba.contruyeAleatorio(opc);
                                                                    break;
                                                                case 2:
                                                                    z = false;
                                                                    break;
                                                                default:
                                                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 2");    
                                                            }
                                                            
                                                            
                                                        } while (z == true);
                                                        
                                                        
                                                    }catch(NumberFormatException w){
                                                         JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                                                        }
                                                    
                                                    break;

                                                case 2:
                                                    if (Ba.retornaRaiz() == null) {
                                                        JOptionPane.showMessageDialog(null, "no se ha ingresado ningun dato aun");
                                                        break;
                                                    }
                                                    System.out.println("\nDatos en inorden");
                                                    Ba.recorreInorden(Ba.retornaRaiz());
                                                    System.out.println("");

                                                    break;
                                                case 3:
                                                    if (Ba.retornaRaiz() == null) {
                                                        JOptionPane.showMessageDialog(null, "no se ha ingresado ningun dato aun");
                                                        break;
                                                    }
                                                    System.out.println("\nDatos en preorden");
                                                    Ba.recorrePreorden(Ba.retornaRaiz());
                                                    System.out.println("");

                                                    break;
                                                    
                                                case 4:
                                                    if (Ba.retornaRaiz() == null) {
                                                        JOptionPane.showMessageDialog(null, "no se ha ingresado ningun dato aun");
                                                        break;
                                                    }
                                                    System.out.println("\nDatos en posorden");
                                                    Ba.recorrePosorden(Ba.retornaRaiz());
                                                    System.out.println("");

                                                    break;    

                                                case 5: // distancia entre cada par de arboles 
                                                    
                                                    
                                                    break;
                                                    
                                                case 6: // distancia entre dos datos ingresados por el usuario
                                                    int i = Integer.parseInt((JOptionPane.showInputDialog("ingresar primer dato")));
                                                    int j1 = Integer.parseInt((JOptionPane.showInputDialog("ingresar segundo dato")));
                                                    int dist2 = Ba.distancia(i,j1);
                                                    JOptionPane.showMessageDialog(null, "la distancia entre los dos datos es: " + dist2);
                                                    
                                                    break;
                                                    
                                                case 7:
                                                    a1 = false;
                                                    break;

                                                default:
                                                    JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");

                                            }

                                        }while(a1 == true);

                                    }catch(NumberFormatException w){
                                            JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                                        }
                                            break;

                                        case 3:

                                            a = false;
                                            break;    

                                        default:
                                            JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 3");

                                    }

                                }while(a == true);




                                }
                                catch(NumberFormatException w){
                                    JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                                }


                           break;
                
                case 4:                    
                    salir = true;
                    break;   
                   
                   
                default:
                   JOptionPane.showMessageDialog(null, "Solo opciones entre 1 y 4");
           }
               }
               catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Presiono cancelar ó aceptar\n sin seleccionar opcion validad", "Presiono cancelar ó aceptar sin seleccionar opcion validad", JOptionPane.ERROR_MESSAGE);
      }     
               
       }while(!salir);
    }
}

