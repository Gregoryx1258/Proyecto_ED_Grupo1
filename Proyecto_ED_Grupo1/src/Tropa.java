/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
public class Tropa {
    String nombre, ventaja; //Ventaja corresponde a la variable que guarda contra quien gana la tropa seleccionada
    int dano;

    public Tropa(String nombre, String ventaja, int dano) {
        this.nombre = nombre;
        this.ventaja = ventaja;
        this.dano = dano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVentaja(String ventaja) {
        this.ventaja = ventaja;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVentaja() {
        return ventaja;
    }

    public int getDano() {
        return dano;
    }
    
}
