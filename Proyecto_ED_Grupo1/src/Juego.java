
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gaval
 */
public class Juego {
private int cantidadTropas = 1;
private int numOleada = 0;
private Scanner scanner = new Scanner(System.in);

public void jugar() {
  
    while (cantidadTropas>0) {
        System.out.println("Elija el tipo de tropa para la próxima oleada:");
        System.out.println("c = Caballero, m = Mago, a = Arquero");
        cantidadTropas = numOleada + 4;
        int total = cantidadTropas;
        for (int i = 0; i < total; i++) {
            String personaje = scanner.nextLine().toLowerCase();
            System.out.println("Indique la linea por la que irá la tropa: ");
            System.out.println("1 = Izquierda o 2 = Derecha");
            String camino=scanner.nextLine();
            switch (personaje) {
                case "c":
                    System.out.println("caballero");
                    //llamar encola para ingresar los datos
                    
                    // caballero
                    break;
                case "m":
                    System.out.println("mago");
                    //llamar encola para ingresar los datos
                    
                    // mago
                    break;
                case "a":
                    System.out.println("arquero");
                    //llamar encola para ingresar los datos
                    
                    // Arquero
                    break;
                 
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    i--;
                    break;
            }
        }
        cantidadTropas--;
        numOleada++;
    }
    scanner.close();
}

}
