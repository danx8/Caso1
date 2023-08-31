package Caso_1;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de productores: ");
        int numProductores = scanner.nextInt();

        System.out.print("Ingrese la cantidad de repartidores: ");
        int numRepartidores = scanner.nextInt();

        System.out.print("Ingrese la capacidad de la bodega: ");
        int capacidadBodega = scanner.nextInt();

        System.out.print("Ingrese la capacidad del buffer: ");
        int capacidadBuffer = scanner.nextInt();

        Bodega bodega = new Bodega(capacidadBodega);
        Buffer buffer = new Buffer(capacidadBuffer);
        Despachador despachador = new Despachador(bodega, buffer);

        // Crear y empezar los repartidores
        Repartidor[] repartidores = new Repartidor[numRepartidores];
        for (int i = 0; i < numRepartidores; i++) {
            repartidores[i] = new Repartidor(buffer);
            repartidores[i].start();
        }

        // Crear y empezar los productores
        Productor[] productores = new Productor[numProductores];
        for (int i = 0; i < numProductores; i++) {
            productores[i] = new Productor(bodega, numRepartidores);
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







       