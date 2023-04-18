

import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public void menu(){
        Juego obj1 = new Juego();
        byte cont=0;
        while(cont==0){
        System.out.print("Digite el numero correspondiente a la accion a realizar "
                + "\n1-Jugar"
                + "\n2-Salir\n-"); 
            int opc=scanner.nextInt();
            scanner.nextLine();
            switch (opc){
            case 1:
                obj1.jugar();
                break;
            case 2:
                cont++;
                break;
            default :
                System.out.println("La opción digitada es incorrecta");
                break;    
            }        
        }
    
    }
}
