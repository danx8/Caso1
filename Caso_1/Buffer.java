package Caso_1;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Producto> buffer;
    private int capacidad;
    private Queue<Producto> productos;

    public Buffer(int capacidad) {
        this.buffer = new LinkedList<>();
        this.capacidad = capacidad;
        this.productos = new LinkedList<>();
    }

    public synchronized void colocarProducto(Producto producto) throws InterruptedException {
        while (productos.size() >= capacidad) {
            wait();
        }
        productos.offer(producto);
        buffer.offer(producto);
        System.out.println("Despachador ha colocado el producto " + producto.getId() + " en el buffer.");

        notifyAll();
    }

    public synchronized Producto tomarProducto() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        Producto producto = buffer.poll();
        productos.poll();
        System.out.println("Repartidor ha tomado el producto " + producto.getId() + " del buffer.");
        notifyAll();
        return producto;
    }
}

