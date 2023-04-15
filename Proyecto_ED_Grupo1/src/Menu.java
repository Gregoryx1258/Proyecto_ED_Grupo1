
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gaval
 */
public class Menu {
    public void menu(){
        byte cont=0;
        while(cont==0){
        byte opc = Byte.parseByte(JOptionPane.showInputDialog(null, "Digite el número correspondiente a la acción a realizar "
                + "\n1-Jugar"
                + "\n2-Salir"));  
            switch (opc){
            case 1:
                JOptionPane.showMessageDialog(null, "Jugar");
                break;
            case 2:
                cont++;
                    break;
            default :
                JOptionPane.showMessageDialog(null, "La opción digitada es incorrecta");
                break;    
            }        
        }
    }

}
