package Caso_1;
import java.util.Scanner;



public class Main {
     
     private static int numRepartidores = 0;
     private static int numProductores = 0;



    public static void main(String[] args) {



        Scanner sc3 = new Scanner(System.in);
        System.out.println("Ingrese la capacidad de la bodega: ");
        int bodegaCapacidad = Integer.parseInt(sc3.nextLine());  

        Bodega bodega = new Bodega(bodegaCapacidad);
        
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de productores: ");
        numProductores = Integer.parseInt(sc1.nextLine());

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de repartidores: ");
        numRepartidores = Integer.parseInt(sc2.nextLine());

         Repartidores[] repartidores = new Repartidores[numRepartidores];

          for(int i = 0; i <numRepartidores; i++){
            repartidores[i] = new Repartidores(i,bodega);
            repartidores[i].start();
          }

        Productores[] productores = new Productores[numProductores];

        for (int i = 0; i < numProductores; i++) {
            productores[i] = new Productores(i,bodega );
            productores[i].start();
        }

        // Scanner sc2 = new Scanner(System.in);
        // System.out.println("Ingrese la cantidad de repartidores: ");
        // numRepartidores = Integer.parseInt(sc2.nextLine());

        // Repartidores[] repartidores = new Repartidores[numRepartidores];

        //   for(int i = 0; i <numRepartidores; i++){
        //     repartidores[i] = new Repartidores(i,bodega);
        //     repartidores[i].start();
        //   }

        
    }

}
