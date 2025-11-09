package ar.com.codesystem.ventas;

public class Orden {
    private int idOrden;
    private Producto productos[]; // Declaramos el arreglo - Lista de productos
    private static int contadorOrdenes;
    private static final int MAX_PRODUCTOS = 10;
    
    // Constructor vacio

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }
}
