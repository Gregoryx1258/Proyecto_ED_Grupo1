/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielsm27
 */
public class ColaJug {
    private NodoTropa frente;
    private NodoTropa ultimo;
    private int largo;

    public ColaJug() {
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
    }
        
    public void encola(NodoTropa nuevoNodo){
        if(frente == null){  // significa que la cola esta vacia
            frente = nuevoNodo;
            ultimo = nuevoNodo;                    
        } else{
            ultimo.setNext(nuevoNodo);
            ultimo=nuevoNodo;
        }
        largo++;
    }
    
    public NodoTropa atiende(){
        NodoTropa aux = frente;
        if(frente!=null){
            frente=frente.getNext();
            aux.setNext(null);
            largo--;
        }
        return aux;
    }
   
}
