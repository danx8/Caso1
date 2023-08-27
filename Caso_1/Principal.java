package Caso_1;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;


public class Principal {
     private static final int numProductores = 0;
     private static final int numRepartidores = 0;

    public static void main(String[] args) {
        Productores[] productores = new Productores[numProductores];
        Repartidores[] repartidores = new Repartidores[numRepartidores];


          Scanner sc1 = new Scanner(System.in);
          System.out.println("Ingrese la cantidad de productores: ");
          int numProductores = Integer.parseInt(sc1.nextLine());

          for (int i = 0; i < numProductores; i++) {
            productores[i] = new Productores(i);
            productores[i].start();
        }

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de repartidores: ");
        int numRepartidores = Integer.parseInt(sc2.nextLine());

          for(int i = 0; i <numRepartidores; i++){
            repartidores[i] = new Repartidores(i);
            repartidores[i].start();
          }

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Ingrese la capacidad de la bodega: ");
        int bodegaCapacidad = Integer.parseInt(sc3.nextLine());  

        Bodega bodega = new Bodega(bodegaCapacidad);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numRepartidores);




        

        
    }

}
