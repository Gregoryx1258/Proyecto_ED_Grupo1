/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
public class NodoTropa {
    private Tropa dato;
    private NodoTropa next;

    public NodoTropa(Tropa dato) {
        this.dato = dato;
    }

    public void setDato(Tropa dato) {
        this.dato = dato;
    }

    public void setNext(NodoTropa next) {
        this.next = next;
    }

    public Tropa getDato() {
        return dato;
    }

    public NodoTropa getNext() {
        return next;
    }
    
}
