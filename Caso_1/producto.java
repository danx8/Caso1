package Caso_1;

 class Producto {
    private int id;
    private static int nextId = 1;
    private boolean entregado;

    public Producto() {
        this.id = generateUniqueId();
    }

    private synchronized static int generateUniqueId() {
        return nextId++;
    }

    public int getId() {
        return id;
    }


    public synchronized void entregarProductoAlProductor() {
        entregado = true;
        notify();
    }

    public synchronized void esperarEntrega() throws InterruptedException {
        System.out.println("Productor está esperando la entrega del producto " + id);
        while (!entregado) {
            wait();
        }
    }
    
}
