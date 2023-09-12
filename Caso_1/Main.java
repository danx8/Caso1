package Caso_1;



import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numProductores = 0;
        int numRepartidores = 0;
        int capacidadBodega = 0;
        int numProductos = 0;
        int capacidadBuffer = 1;

        boolean procesoValido = true;
        while (procesoValido){
        procesoValido = !procesoValido;

            System.out.print("Ingrese la cantidad de productores: ");
            numProductores = scanner.nextInt();

            System.out.print("Ingrese la cantidad de repartidores: ");
            numRepartidores = scanner.nextInt();

            System.out.print("Ingrese la capacidad de la bodega: ");
            capacidadBodega = scanner.nextInt();

            System.out.print("Ingrese la cantidad de productos: ");
            numProductos = scanner.nextInt();

            if ((numProductores <= 0) || ( numRepartidores <= 0)|| (capacidadBodega <= 0)){
                procesoValido = true;
                System.out.println( "\n No es posible llevar a cabo el proceso debido a que uno de los elementos seleccionados para (productores, repartidores o productos) tiene un valor igual o menor a cero.");
                System.out.println("\n Seleccione nuevamente los valores");
            }
        }
        Bodega bodega = new Bodega(capacidadBodega);
        Buffer buffer = new Buffer(capacidadBuffer);
        Despachador despachador = new Despachador(bodega, buffer);

        int numProductosxP = numProductos / numProductores;

        int x = numProductosxP * numProductores;

        int[] pxp = new int[numProductores];
        Arrays.fill(pxp, numProductosxP);
        int faltante = numProductos-x;

        for (int j = 0; j < numProductores && faltante > 0; j++){
            pxp[j] = pxp[j] + 1;
            faltante--;
        }

        if (x != numProductos) {
            numProductosxP = numProductosxP + 1;
        }

        // Crear y empezar los repartidores
        Repartidor[] repartidores = new Repartidor[numRepartidores];
        for (int i = 0; i < numRepartidores; i++) {
            repartidores[i] = new Repartidor(buffer);
            repartidores[i].start();
        }

        // Crear y empezar los productores
        Productor[] productores = new Productor[numProductores];
        for (int i = 0; i < numProductores; i++) {
            productores[i] = new Productor(bodega, pxp[i]);
            productores[i].start();
        }

        // Iniciar el despachador
        despachador.start();

        // Esperar a que todos los productores terminen
        for (Productor productor : productores) {
            try {
                productor.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Interrumpir y esperar a que todos los repartidores terminen
        for (Repartidor repartidor : repartidores) {
            repartidor.interrupt();
            try {
                repartidor.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Interrumpir y esperar a que el despachador termine
        despachador.interrupt();
        try {
            despachador.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }



     // Productor[] productores = new Productor[numProductores];

        // for (int i = 0; i < numProductores; i++) {
        //     productores[i] = new Productor(bodega,i );
        //     productores[i].start();
        // }

        // Scanner sc2 = new Scanner(System.in);
        // System.out.println("Ingrese la cantidad de repartidores: ");
        // numRepartidores = Integer.parseInt(sc2.nextLine());

        // Repartidores[] repartidores = new Repartidores[numRepartidores];

        //   for(int i = 0; i <numRepartidores; i++){
        //     repartidores[i] = new Repartidores(i,bodega);
        //     repartidores[i].start();
        //   }

        






}







       