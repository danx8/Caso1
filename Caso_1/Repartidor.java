package Caso_1;

import java.util.Random;

public class Repartidor extends Thread {
    private Buffer buffer;

    public Repartidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        boolean seguir = true;
        while (seguir) {
            try {
        
                Producto producto = buffer.tomarProducto();

        
                int tiempoEntrega = generarTiempoEntrega();
                Thread.sleep(tiempoEntrega);

                System.out.println("Repartidor ha entregado el producto " + producto.getId());

       
            producto.entregarProductoAlProductor();

            } catch (InterruptedException e) {
                seguir = false;
            }   
        }
    }

    private int generarTiempoEntrega() {
        Random random = new Random();
        return random.nextInt(8) + 3; // Tiempo entre 3 y 10 segundos
    }
}
