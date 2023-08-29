package Caso_1;
public class Productores extends Thread {
    
    private Bodega bodega;
    private int id;

    public Productores(int i, Bodega bodega) {
        this.bodega = bodega;
        this.id = i;
    }

    public Productores() {
    }

    

    @Override
    public synchronized void run() {
        while (!isInterrupted()) {
            try {
                // Crear producto
                
                
                System.out.println("Productor ha creado un producto "+ id);

                Productores producto = new Productores();
                
                bodega.almacenarProducto(producto);
                System.out.println("Almaceno");
    
                Thread.sleep(1000); 

            } catch (InterruptedException e) {
                interrupt();
            }
        }

    }
    
    
}
