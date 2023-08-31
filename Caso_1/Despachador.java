package Caso_1;

public class Despachador extends Thread {
    private Bodega bodega;
    private Buffer buffer;

    public Despachador(Bodega bodega, Buffer buffer) {
        this.bodega = bodega;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Producto producto = bodega.tomarProducto();

                if (producto != null) {
                    buffer.colocarProducto(producto);
                } else {
                    realizarTareaAdicional();
                }

            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    private void realizarTareaAdicional() {
        System.out.println("Despachador está realizando una tarea adicional.");
        // Simulación de una espera activa
        try {
            Thread.sleep(1000); // Espera de 1 segundo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
