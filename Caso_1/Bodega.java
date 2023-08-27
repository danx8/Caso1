package Caso_1;

import java.util.Queue;

public class Bodega {
    //referencia a la clase buffer o al buffer->clase bodega
    private int capacidad;
    private int ocupado; 
    private Queue<Productores> productos;


    public   Bodega(int capacidad){
        this.capacidad = capacidad;
        this.ocupado = 0;
    }

    public synchronized void almacenarProducto(Productores producto) throws InterruptedException {
        while (ocupado >=capacidad) {
            wait();
        }
        ocupado++;
    }

    public synchronized void despacharProducto() {
        ocupado--;
        notifyAll();
    }

    public synchronized Productores tomarProducto() {
        if (!productos.isEmpty()) {
            return productos.poll();
        }
        return null;
    }
    
}
