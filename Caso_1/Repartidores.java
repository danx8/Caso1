package Caso_1;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Repartidores  extends Thread{

    private Bodega bodega;
    private CyclicBarrier cyclicBarrier;

   public Repartidores(int i,Bodega bodega) {
    this.bodega = bodega;
    

    }


@Override
    public void run() {
        while (!isInterrupted()) {
            try {
                // Esperar a que el despachador tenga un producto listo
                cyclicBarrier.await();

                // Tomar un producto de la bodega
                Productores producto = bodega.tomarProducto();
                if (producto != null) {
                    System.out.println("Repartidor ha tomado un producto.");

                    // Simular tiempo de entrega
                    int tiempoEntrega = generarTiempoEntrega();
                    Thread.sleep(tiempoEntrega);

                    System.out.println("Repartidor ha entregado un producto.");
                }

            } catch (InterruptedException | BrokenBarrierException e) {
                interrupt();
            }
        }
    }


     private int generarTiempoEntrega() {
        //tiempo de entrega aleatorio entre 3 y 10 segundos
        Random random = new Random();
        return random.nextInt(8) + 3;
    }
    
}
