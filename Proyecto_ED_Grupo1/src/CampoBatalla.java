/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gaval
 */
public class CampoBatalla {
    
    public void campoBatalla(){
        int vidaCastCPU=10, vidaCastJug=10;
        String[][] matriz=new String[3][8];
        for (int i=0;i<3;i++){
            for (int j=0;j<8;j++){
               matriz[i][j]="-"; 
            }
        }  

        matriz[1][1]="C";
        matriz[1][6]="C";
        matriz[0][2]="M";
        matriz[1][0]=Integer.toString(vidaCastJug);
        matriz[1][7]=Integer.toString(vidaCastCPU);
        for (int i=0;i<3;i++){
                for (int j=0;j<8;j++){
                   System.out.print(matriz[i][j]+" "); 
                }
            System.out.println(""); 
        } 
        vidaCastJug-=2;
        vidaCastCPU-=2;
        matriz[1][0]=Integer.toString(vidaCastJug);
        matriz[1][7]=Integer.toString(vidaCastCPU);
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
