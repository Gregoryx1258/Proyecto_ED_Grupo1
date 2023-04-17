/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
public class Tropa {
    String nombre, letra,ventaja; //letra describe el tipo de tropa de manera simple para el codigo
    //Ventaja corresponde a la variable que guarda contra quien gana la tropa seleccionada
    int camino;
    double dano;

    public Tropa(String nombre, String letra, String ventaja, double dano,int camino) {
        this.nombre = nombre;
        this.letra = letra;
        this.ventaja = ventaja;
        this.camino = camino;
        this.dano = dano;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLetra() {
        return letra;
    }

    public String getVentaja() {
        return ventaja;
    }

    public int getCamino() {
        return camino;
    }

    public double getDano() {
        return dano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setVentaja(String ventaja) {
        this.ventaja = ventaja;
    }

    public void setCamino(int camino) {
        this.camino = camino;
    }

    public void setDano(double dano) {
        this.dano = dano;
    }

    
}
