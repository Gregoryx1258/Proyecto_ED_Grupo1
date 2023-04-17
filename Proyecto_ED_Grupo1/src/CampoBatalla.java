/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gaval
 */
public class CampoBatalla {
    //Declaracion objetos
    ColaJug obj2 = new ColaJug();
    ColaCPU obj3 = new ColaCPU();
    //Declaracion Variables
    double vidaCastCPU=10, vidaCastJug=10;
    public void campoBatalla(){     
        String[][] matriz=new String[3][8];
        for (int i=0;i<3;i++){
            for (int j=0;j<8;j++){
               matriz[i][j]="-"; 
            }
        }  
        NodoTropa tropaJug = obj2.atiende();
        System.out.print(tropaJug);
        NodoTropa tropaCPU = obj3.atiende();
        //Van las dos primeras tropas por el mismo camino
        if (tropaJug.getDato().camino==1 || tropaCPU.getDato().camino==1){
            matriz[0][0]="-- ";
        matriz[2][0]="-- ";
        matriz[0][7]=" --";
        matriz[2][7]=" --";
        matriz[1][1]="C";
        matriz[1][6]="C";
        matriz[0][2]="M";
        matriz[1][0]=Double.toString(vidaCastJug);
        matriz[1][7]=Double.toString(vidaCastCPU);
        for (int i=0;i<3;i++){
                for (int j=0;j<8;j++){
                   System.out.print(matriz[i][j]+" "); 
                }
            System.out.println(""); 
        } 
        System.out.print("\n");
        
        matriz[1][0]=Double.toString(vidaCastJug);
        matriz[1][7]=Double.toString(vidaCastCPU);
        matriz[0][2]="-";
        matriz[0][3]="M";
        for (int i=0;i<3;i++){
                for (int j=0;j<8;j++){
                   System.out.print(matriz[i][j]+" "); 
                }
            System.out.println(""); 
        }
        
        }else if(tropaJug.getDato().camino==2 || tropaCPU.getDato().camino==1){
    
        }else if(tropaJug.getDato().camino==1 || tropaCPU.getDato().camino==2){
    
        }else if(tropaJug.getDato().camino==2 || tropaCPU.getDato().camino==2){
    
        }
        
        
        
        
        
        matriz[0][0]="-- ";
        matriz[2][0]="-- ";
        matriz[0][7]=" --";
        matriz[2][7]=" --";
        matriz[1][1]="C";
        matriz[1][6]="C";
        matriz[0][2]="M";
        matriz[1][0]=Double.toString(vidaCastJug);
        matriz[1][7]=Double.toString(vidaCastCPU);
        for (int i=0;i<3;i++){
                for (int j=0;j<8;j++){
                   System.out.print(matriz[i][j]+" "); 
                }
            System.out.println(""); 
        } 
        System.out.print("\n");
        
        matriz[1][0]=Double.toString(vidaCastJug);
        matriz[1][7]=Double.toString(vidaCastCPU);
        matriz[0][2]="-";
        matriz[0][3]="M";
        for (int i=0;i<3;i++){
                for (int j=0;j<8;j++){
                   System.out.print(matriz[i][j]+" "); 
                }
            System.out.println(""); 
        }
        
    }
}
