package Caso_1;
public class Productores extends Thread {

    private Bodega bodega;

    public Productores(int i) {
    }

    public Productores() {
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                // Crear producto
                
                Productores producto = new Productores();
                System.out.println("Productor ha creado un producto.");
                
                bodega.almacenarProducto(producto);
    
                Thread.sleep(1000); 

            } catch (InterruptedException e) {
                interrupt();
            }
        }

    }
    
    
}
