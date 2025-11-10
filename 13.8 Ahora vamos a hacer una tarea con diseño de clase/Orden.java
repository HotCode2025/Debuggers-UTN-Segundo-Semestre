package ventas;

public class Orden {
    private int idOrden;
    private Producto productos[];
    private static int contadorOrdenes;
    private int contadorProductos;
    private static final int MAX_PRODUCTOS = 10;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        productos = new Producto[MAX_PRODUCTOS];
    }

    public void agregarProducto(Producto producto) {
        if (contadorProductos < MAX_PRODUCTOS) {
            productos[contadorProductos++] = producto;
        } else {
            System.out.println("Se ha superado el máximo de productos por orden: " + MAX_PRODUCTOS);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < contadorProductos; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }

    public void mostrarOrden() {
        System.out.println("Orden #" + idOrden);
        System.out.println("Productos de la orden:");
        for (int i = 0; i < contadorProductos; i++) {
            System.out.println(productos[i]);
        }
        System.out.println("Total de la orden: $" + calcularTotal());
        System.out.println();
    }
}