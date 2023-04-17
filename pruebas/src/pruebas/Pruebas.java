/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;
import java.util.Random;
/**
 *
 * @author gaval
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    Random r = new Random();

        letraAlCPU = "cma";
        String tropaCPU = String.valueOf(letraAlCPU.charAt(r.nextInt(letraAlCPU.length())));
        System.out.println(tropaCPU);
}
    }

