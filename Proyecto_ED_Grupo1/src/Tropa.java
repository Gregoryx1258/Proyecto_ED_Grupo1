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
    int camino;
    double dano;

    public Tropa(String nombre, String ventaja, double dano, int camino) {
        this.nombre = nombre;
        this.ventaja = ventaja;
        this.dano = dano;
        this.camino = camino;
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

    public void setCamino(int camino) {
        this.camino = camino;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVentaja() {
        return ventaja;
    }

    public double getDano() {
        return dano;
    }

    public int getCamino() {
        return camino;
    }

    
}
