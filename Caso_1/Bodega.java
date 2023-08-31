package Caso_1;

import java.util.LinkedList;
import java.util.Queue;

public class Bodega {
    private int capacidad;
    private Queue<Producto> productos;

    public Bodega(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new LinkedList<>();
    }

    public synchronized void almacenarProducto(Producto producto) throws InterruptedException {
        while (productos.size() >= capacidad) {
            wait();
        }
        productos.offer(producto);
        System.out.println("Se agrego un producto a la bodega: ");
        notifyAll();
    }

    public synchronized Producto tomarProducto() throws InterruptedException {
        while (productos.isEmpty()) {
            wait();
        }
        Producto producto = productos.poll();
        notifyAll();
        return producto;
    }
}
