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
        System.out.print(aux.getDato().camino);
        return aux;
    }
    @Override
    public String toString(){
        int cont=1;
        NodoTropa aux=frente;
        String s="\nLista Tropas seleccionadas por el Jugador: \n";
        while(aux!=null && cont<6){
            s+=cont+"- "+aux.getDato().getNombre()+"\n";
            aux=aux.getNext();
            cont++;
        }
        return s;
        } 
    
    
}
