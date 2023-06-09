
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
public class Juego {
//Declaracion de objetos de las clases a llamar
ColaJug obj2 = new ColaJug();
ColaCPU obj3 = new ColaCPU();
Random r = new Random();
Tiempo tiempo = new Tiempo(); //Metodo para el cronometro
        
    //-------------
//Declaracion de variables
private int cantidadTropas = 1;
private int numOleada = 1,cont=0;
private Scanner scanner = new Scanner(System.in);
String personaje=null;

public void jugar() {
    cont=0;
    numOleada = 1;
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
    //Se inicia el cronometro cuando inicia la oleada
    tiempo.iniciarCronometro();
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
        }//Fin de fase preparacion de usuario 
        
        cantidadTropas = numOleada + 3;
        int contCamino1=0, contCamino2=0; //Contadores para poder delimitar las tropas de la CPU por un camino al 75%
        while (cantidadTropas>0) {
            for (int i = 0; i < numOleada + 3; i++) {
                String letraAlCPU = "cma";
                personaje = String.valueOf(letraAlCPU.charAt(r.nextInt(letraAlCPU.length()))); 
                int camino=(int)(Math.random() * 2) + 1;
                if (camino==1){
                    contCamino1+=1;
                }else{
                    contCamino2+=1;
                }
                if (contCamino1>(numOleada + 3)*0.75){
                    camino=2;
                }else if(contCamino2>(numOleada + 3)*0.75){
                   camino=1; 
                }
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
        this.delay(3000);
        System.out.println("\n\n***FIN DE FASE DE PREPARACION***");
        this.delay(2000);
        System.out.println("\n\n***FASE DE BATALLA***");
        System.out.println("\n\n***COMIENZA LA  OLEADA #"+numOleada+"***");
        
        this.campoBatalla();
        numOleada++;
    
    }//Cierre de ciclo while de los cases
    }//Cierre de metodo jugar

  ////////// Fin de la fase de preparacion, inicio de la seccion de mostrar la batalla
    ///Realizada en la misma clase ya que los metodos de las colas no se pueden utilizar en multiples clases a la vez
    //Declaracion Variables
    double vidaCastCPU=10, vidaCastJug=10;
    public int campoBatalla(){ 
        int contBatallas=1;
        String[][] matriz=new String[3][8];
         
        while (contBatallas<numOleada + 4){
            for (int i=0;i<3;i++){
                for (int j=0;j<8;j++){
                   matriz[i][j]="-"; 
                }
            } 
            this.delay(500);
            System.out.println("\nInicio de la batalla #"+contBatallas+"\n");
            this.delay(2000);
            NodoTropa tropaJug = obj2.atiende();
            NodoTropa tropaCPU = obj3.atiende(); 
            System.out.println("\n");
            //Van las dos primeras tropas por el mismo camino
            if (tropaJug.getDato().camino==1 && tropaCPU.getDato().camino==1){
                matriz[0][0]="-- ";
                matriz[2][0]="-- ";
                matriz[0][7]=" --";
                matriz[2][7]=" --";
                matriz[1][1]="T";
                matriz[1][6]="T";
                matriz[0][2]= tropaJug.getDato().letra.toUpperCase();

                matriz[1][0]=Double.toString(vidaCastJug);
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);

                matriz[0][5]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][2]= "-";
                matriz[0][3]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][5]= "-";
                
                matriz[0][4]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                //Primera validacion de batalla
                if (tropaJug.getDato().ventaja==tropaCPU.getDato().letra){
                    matriz[0][3]= "-";
                    matriz[0][4]= "X";
                    matriz[0][5]= tropaJug.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);
                    vidaCastCPU-=tropaJug.getDato().getDano();
                    if (vidaCastCPU<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][7]=(" "+Double.toString(0));
                    matriz[1][6]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                    }            
                    matriz[1][7]=Double.toString(vidaCastCPU);
                    matriz[0][5]= "-";
                    matriz[1][5]= tropaJug.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);
                } else if (tropaCPU.getDato().ventaja==tropaJug.getDato().letra){ //Segunda validacion de batalla
                    matriz[0][4]= "-";
                    matriz[0][3]= "X";
                    matriz[0][2]= tropaCPU.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);

                    vidaCastJug-=tropaCPU.getDato().getDano();
                    if (vidaCastJug<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][0]=(" "+Double.toString(0));
                    matriz[1][1]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                    }
                    matriz[1][0]=Double.toString(vidaCastJug);
                    matriz[0][2]= "-";
                    matriz[1][2]= tropaCPU.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);
                } else{ //Tercera validacion de batalla
                    matriz[0][4]= "X";
                    matriz[0][3]= "X";
                    for (int i=0;i<3;i++){
                        for (int j=0;j<8;j++){
                           System.out.print(matriz[i][j]+" "); 
                        }
                    System.out.println(""); 
                    } 
                    this.delay(200);
                    System.out.print("\n\n----Ambas tropas murieron en el combate---\n\n");
                    this.delay(1000);
                }

            //Fin primera situacion  ***********************

            }else if(tropaJug.getDato().camino==2 && tropaCPU.getDato().camino==1){
                matriz[0][0]="-- ";
                matriz[2][0]="-- ";
                matriz[0][7]=" --";
                matriz[2][7]=" --";
                matriz[1][1]="T";
                matriz[1][6]="T";
                matriz[2][2]= tropaJug.getDato().letra.toUpperCase();

                matriz[1][0]=Double.toString(vidaCastJug);
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
                matriz[0][5]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][2]= "-";
                matriz[2][3]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][5]= "-";
                matriz[0][4]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][3]= "-";
                matriz[2][4]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][4]= "-";
                matriz[0][3]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][4]= "-";
                matriz[2][5]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][3]= "-";
                matriz[0][2]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][5]= "-";
                matriz[1][5]= tropaJug.getDato().letra.toUpperCase();
                vidaCastCPU-=tropaJug.getDato().getDano();
                if (vidaCastCPU<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][7]=(" "+Double.toString(0));
                    matriz[1][6]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                }
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
                matriz[0][2]= "-";
                matriz[1][2]= tropaCPU.getDato().letra.toUpperCase();
                vidaCastJug-=tropaCPU.getDato().getDano();
                if (vidaCastJug<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][0]=(" "+Double.toString(0));
                    matriz[1][1]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                }
                matriz[1][0]=Double.toString(vidaCastJug);
                this.mostrarBatalla(matriz);
                
           //Fin segunda situacion  ***********************

            }else if(tropaJug.getDato().camino==1 && tropaCPU.getDato().camino==2){
                matriz[0][0]="-- ";
                matriz[2][0]="-- ";
                matriz[0][7]=" --";
                matriz[2][7]=" --";
                matriz[1][1]="T";
                matriz[1][6]="T";
                matriz[0][2]= tropaJug.getDato().letra.toUpperCase();

                matriz[1][0]=Double.toString(vidaCastJug);
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
                matriz[2][5]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][2]= "-";
                matriz[0][3]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][5]= "-";
                matriz[2][4]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][3]= "-";
                matriz[0][4]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][4]= "-";
                matriz[2][3]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][4]= "-";
                matriz[0][5]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][3]= "-";
                matriz[2][2]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][5]= "-";
                matriz[1][5]= tropaJug.getDato().letra.toUpperCase();
                vidaCastCPU-=tropaJug.getDato().getDano();
                if (vidaCastCPU<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][7]=(" "+Double.toString(0));
                    matriz[1][6]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                }
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
                matriz[2][2]= "-";
                matriz[1][2]= tropaCPU.getDato().letra.toUpperCase();
                vidaCastJug-=tropaCPU.getDato().getDano();
                if (vidaCastJug<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][0]=(" "+Double.toString(0));
                    matriz[1][1]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                }
                matriz[1][0]=Double.toString(vidaCastJug);
                this.mostrarBatalla(matriz);
            //Fin tercera situacion  ***********************

            }else if(tropaJug.getDato().camino==2 && tropaCPU.getDato().camino==2){
                matriz[0][0]="-- ";
                matriz[2][0]="-- ";
                matriz[0][7]=" --";
                matriz[2][7]=" --";
                matriz[1][1]="T";
                matriz[1][6]="T";
                matriz[2][2]= tropaJug.getDato().letra.toUpperCase();

                matriz[1][0]=Double.toString(vidaCastJug);
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);

                matriz[2][5]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][2]= "-";
                matriz[2][3]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][5]= "-";
                
                matriz[2][4]= tropaCPU.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                //Primera validacion de batalla
                if (tropaJug.getDato().ventaja==tropaCPU.getDato().letra){
                    matriz[2][3]= "-";
                    matriz[2][4]= "X";
                    matriz[2][5]= tropaJug.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);

                    vidaCastCPU-=tropaJug.getDato().getDano();
                    if (vidaCastCPU<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][7]=(" "+Double.toString(0));
                    matriz[1][6]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                    }
                    matriz[1][7]=Double.toString(vidaCastCPU);
                    matriz[2][5]= "-";
                    matriz[1][5]= tropaJug.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);
                } else if (tropaCPU.getDato().ventaja==tropaJug.getDato().letra){ //Segunda validacion de batalla
                    matriz[2][4]= "-";
                    matriz[2][3]= "X";
                    matriz[2][2]= tropaCPU.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);

                    vidaCastJug-=tropaCPU.getDato().getDano();
                    if (vidaCastJug<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][0]=(" "+Double.toString(0));
                    matriz[1][1]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                    }
                    matriz[1][0]=Double.toString(vidaCastJug);
                    matriz[2][2]= "-";
                    matriz[1][2]= tropaCPU.getDato().letra.toUpperCase();
                    this.mostrarBatalla(matriz);
                } else{ //Tercera validacion de batalla
                    matriz[2][4]= "X";
                    matriz[2][3]= "X";
                    for (int i=0;i<3;i++){
                        for (int j=0;j<8;j++){
                           System.out.print(matriz[i][j]+" "); 
                        }
                    System.out.println(""); 
                    } 
                    this.delay(200);
                    System.out.print("\n\n----Ambas tropas murieron en el combate---\n\n");
                    this.delay(1000);
                }
            }//Fin cuarta situacion  ***********************
            contBatallas++;
        }// Fin contador batallas
        System.out.println("\nInicio de la batalla #"+contBatallas+"\n");
        this.delay(2000);
        NodoTropa tropaJug = obj2.atiende();
        for (int i=0;i<3;i++){
            for (int j=0;j<8;j++){
               matriz[i][j]="-"; 
            }
        }   
        if(tropaJug.getDato().camino==2){
                matriz[0][0]="-- ";
                matriz[2][0]="-- ";
                matriz[0][7]=" --";
                matriz[2][7]=" --";
                matriz[1][1]="T";
                matriz[1][6]="T";
                matriz[2][2]= tropaJug.getDato().letra.toUpperCase();

                matriz[1][0]=Double.toString(vidaCastJug);
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
                matriz[2][2]= "-";
                matriz[2][3]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][3]= "-";
                matriz[2][4]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][4]= "-";
                matriz[2][5]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[2][5]= "-";
                matriz[1][5]= tropaJug.getDato().letra.toUpperCase();
                vidaCastCPU-=tropaJug.getDato().getDano();
                if (vidaCastCPU<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][7]=(" "+Double.toString(0));
                    matriz[1][6]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                }
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
            }else if(tropaJug.getDato().camino==1){
                matriz[0][0]="-- ";
                matriz[2][0]="-- ";
                matriz[0][7]=" --";
                matriz[2][7]=" --";
                matriz[1][1]="T";
                matriz[1][6]="T";
                matriz[0][2]= tropaJug.getDato().letra.toUpperCase();

                matriz[1][0]=Double.toString(vidaCastJug);
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
                matriz[0][2]= "-";
                matriz[0][3]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][3]= "-";
                matriz[0][4]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][4]= "-";
                matriz[0][5]= tropaJug.getDato().letra.toUpperCase();
                this.mostrarBatalla(matriz);
                matriz[0][5]= "-";
                matriz[1][5]= tropaJug.getDato().letra.toUpperCase();
                vidaCastCPU-=tropaJug.getDato().getDano();
                if (vidaCastCPU<=0){//Llamada a meetodo para validar si la partida terminó segun la vida del castillo
                    matriz[1][7]=(" "+Double.toString(0));
                    matriz[1][6]="X";
                    this.mostrarBatalla(matriz);
                    this.batallaTerminada();
                    return 1;//Saca del metodo campoBatalla
                }
                matriz[1][7]=Double.toString(vidaCastCPU);
                this.mostrarBatalla(matriz);
            }
        return 0;
    }//Cierre de metodo campo batalla
    
    private void delay(long milis)
	{
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    private void mostrarBatalla(String[][] matriz){
        for (int i=0;i<3;i++){
                        for (int j=0;j<8;j++){
                           System.out.print(matriz[i][j]+" "); 
                        }
                    System.out.println(""); 
                } 
                System.out.print("\n");
                this.delay(1000);
    }
    private int batallaTerminada(){
        if (vidaCastJug<=0 ) {
            System.out.println("El enemigo ha destruido tu castillo");
            this.delay(1000);
            System.out.println("Has perdido la partida");
            this.delay(1000);
            System.out.println("Finalizando juego, saliendo al menu.....");
            this.delay(1500);
            tiempo.detenerCronometro();//Se detiene el cronometro una vez termina la partida
            cont=1;//Contador correspondiente al ciclo de la fase de preparacion, poner un 1 signfica que se finalizará la oleada
            return 1;//Indica que se debe detener la batalla
        }else if(vidaCastCPU<=0){
            System.out.println("Has destruido el castillo enemigo");
            this.delay(1000);
            System.out.println("FELICIDADES, ganaste la partida");
            this.delay(1000);
            System.out.println("Finalizando juego, saliendo al menu.....");
            this.delay(1500);
            tiempo.detenerCronometro();//Se detiene el cronometro una vez termina la partida
            cont=1;//Contador correspondiente al ciclo de la fase de preparacion, poner un 1 signfica que se finalizará la partida
            return 1;//Indica que se debe detener la batalla
        }
        return -1;//Indica seguir con la batalla
    }
    
}//Parentesis final