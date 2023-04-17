
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gaval
 */
public class Juego {
//Declaracion de objetos de las clases a llamar
CampoBatalla obj1 = new CampoBatalla();
ColaJug obj2 = new ColaJug();
ColaCPU obj3 = new ColaCPU();
Random r = new Random();
    //-------------
//Declaracion de variables
private int cantidadTropas = 1;
private int numOleada = 1,cont=0;
private Scanner scanner = new Scanner(System.in);
String personaje=null;

public void jugar() {
    //Ciclo de las oleadas -General-
    System.out.println("Este juego consiste en derrotar el castillo del jugador contrario+"
            + "\nSe ecogeran tropas para atacar el castillo, habrán dos caminos, si dos tropas se topan, pelearan"
            + "entre ellas.\nLos Caballeros ganan a los arqueros, los magos a los caballeros y"
            + "los arqueros ganan a los magos, la tabla de daño es:"
            + "\nMago      ->1.5"
            + "\nCaballero ->2"
            + "\nArquero   ->1"
            + "\n\nPresione enter para empezar el juego\n-");
    String enter = scanner.nextLine();
    while (cont==0) {
        System.out.println("Oleada #"+numOleada+"\n****FASE DE PREPARACION***\n\n");
        cantidadTropas = numOleada + 4;
        //Ciclo para la fase de preparacion
        while (cantidadTropas>0) {
            System.out.println("Elija las topas para esta oleada");
            for (int i = 0; i < numOleada + 4; i++) {
                System.out.println("Elija el tipo de tropa para la oleada(tropas restantes:"+cantidadTropas+"):");
                System.out.println("c = Caballero, m = Mago, a = Arquero");
                System.out.print("-");
                personaje = scanner.nextLine().toLowerCase();
                System.out.println("Indique la linea por la que ira la tropa: ");
                System.out.println("1 = Izquierda o 2 = Derecha");
                System.out.print("-");
                int camino=scanner.nextInt();
                scanner.nextLine();
                switch (personaje) {
                    case "c":
                        //llamar encola para ingresar los datos automaticamente
                        // caballero
                        obj2.encola(new NodoTropa(new Tropa("Caballero","c","a",2,camino)));
                        cantidadTropas--;
                        break;
                    case "m":
                        //llamar encola para ingresar los datos automaticamente
                        // mago
                        obj2.encola(new NodoTropa(new Tropa("Mago","m","c",1.5,camino)));
                        cantidadTropas--;
                        break;
                    case "a":
                        //llamar encola para ingresar los datos automaticamente
                        // Arquero
                        obj2.encola(new NodoTropa(new Tropa("Arquero","a","m",1,camino)));
                        cantidadTropas--;
                        break;

                    default:
                        System.out.println("Opcion inválida. Intente de nuevo.");
                        i--;
                        break;
                }
            }            
        }
        cantidadTropas = numOleada + 3;
        while (cantidadTropas>0) {
            for (int i = 0; i < numOleada + 3; i++) {
                String letraAlCPU = "cma";
                personaje = String.valueOf(letraAlCPU.charAt(r.nextInt(letraAlCPU.length()))); 
                int camino= (int)(Math.random() * 2) + 1;
                switch (personaje) {
                    case "c":
                        //llamar encola para ingresar los datos automaticamente CPU
                        // caballero
                        obj3.encola(new NodoTropa(new Tropa("Caballero","c","a",2,camino)));
                        break;
                    case "m":
                        //llamar encola para ingresar los datos automaticamente CPU
                        // mago
                        obj3.encola(new NodoTropa(new Tropa("Mago","m","c",1.5,camino)));
                        break;
                    case "a":
                        //llamar encola para ingresar los datos automaticamente CPU
                        // Arquero
                        obj3.encola(new NodoTropa(new Tropa("Arquero","a","m",1,camino)));
                        break;
                }
                cantidadTropas--;
        }        
        }
        System.out.println(obj3.toString());
        System.out.println("\n\n***FIN DE FASE DE PREPARACION***");
        System.out.println("\n\n***COMIENZA LA PRIMER OLEADA***");
        obj1.campoBatalla();
        numOleada++;
    
    }
scanner.close();
}
}
