/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielsm27
 */
public class ColaCPU {
    private NodoTropa frente;
    private NodoTropa ultimo;
    private int largo;

    public ColaCPU() {
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
    @Override
    public String toString(){
        int cont=1;
        NodoTropa aux=frente;
        String s="\nPrimeras 3 tropas seleccionadas por la CPU: \n";
        while(aux!=null && cont<4){
            s+=cont+"- "+aux.getDato().getNombre()+"\n";
            aux=aux.getNext();
            cont++;
        }
        return s;
        } 
    
}
