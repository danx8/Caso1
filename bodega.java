
public class Bodega {

    private int capacidad;
    private int ocupado; 


    public   Bodega(int capacidad){
        this.capacidad = capacidad;
        this.ocupado = 0;
    }

    public synchronized void almacenarProducto() throws InterruptedException {
        while (ocupado >=capacidad) {
            wait();
        }
        ocupado++;
    }

    public synchronized void despacharProducto() {
        ocupado--;
        notifyAll();
    }


   


    
}
