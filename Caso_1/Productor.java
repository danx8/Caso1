package Caso_1;


class Productor extends Thread {
    private Bodega bodega;
    private int numProductosAProducir;
    private int productosProducidos;

    public Productor(Bodega bodega, int numProductosAProducir) {
        this.bodega = bodega;
        this.numProductosAProducir = numProductosAProducir;
        this.productosProducidos = 0;
    }

    @Override
    public void run() {
        while (productosProducidos < numProductosAProducir) {
            try {
                Producto producto = producirProducto();
                System.out.println("Productor ha producido el producto " + producto.getId());

                bodega.almacenarProducto(producto);
                System.out.println("Productor ha almacenado el producto " + producto.getId() + " en la bodega.");

                producto.esperarEntrega(); // Esperar a que el repartidor entregue el producto
                System.out.println("Productor ha recibido la entrega del producto " + producto.getId());

            } catch (Throwable e) {
                System.out.println("Productor ha sido interrumpido.");
                e.printStackTrace();
            }
        }
    }

    private Producto producirProducto(){
        productosProducidos++;
        return new Producto();
    }
}
