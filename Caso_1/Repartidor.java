package Caso_1;

import java.util.Random;

public class Repartidor extends Thread {
    private Buffer buffer;

    public Repartidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                // Tomar un producto del buffer
                Producto producto = buffer.tomarProducto();

                // Realizar la entrega del producto
                int tiempoEntrega = generarTiempoEntrega();
                Thread.sleep(tiempoEntrega);

                System.out.println("Repartidor ha entregado el producto " + producto.getId());

               // Devolver el producto al productor
               producto.entregarProductoAlProductor();

            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    private int generarTiempoEntrega() {
        Random random = new Random();
        return random.nextInt(8) + 3; // Tiempo entre 3 y 10 segundos
    }
}
