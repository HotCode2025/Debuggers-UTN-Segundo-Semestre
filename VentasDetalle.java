/*
 * Clase VentaDetalle
 * Esta clase representa un ítem dentro de una Venta.
 * Contiene la información del producto vendido, cantidad y el precio en el momento de la venta.
*/
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Alberto
*/

public class VentasDetalle {

    // -------------------------------------------------------------------------
    // Atributos privados que representan los datos del ítem de la venta
    private int idProducto;
    private int cantidad;
    private double precioUnitario;
    private String nombreProducto;

    // -------------------------------------------------------------------------
    // Constructor
    /*
     * Constructor para crear un nuevo ítem dentro del detalle de la venta.
     * @param idProducto El ID del producto.
     * @param cantidad La cantidad vendida.
     * @param precioUnitario El precio unitario de venta.
     * @param nombreProducto El nombre del producto.
     */
    public VentasDetalle(int idProducto, int cantidad, double precioUnitario, String nombreProducto) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nombreProducto = nombreProducto;
    }

    // -------------------------------------------------------------------------
    // Getters 
    public int getIdProducto() { return idProducto; }
    public int getCantidad() { return cantidad; }
    public String getNombreProducto() { return nombreProducto; }
    public double getPrecioUnitario() { return precioUnitario; }

    // -------------------------------------------------------------------------
    /*
     * Método para calcular el subtotal de esta línea de detalle de venta.
     * El subtotal es el resultado de (cantidad * precioUnitario).
     * @return El valor subtotal de la línea.
    */
    public double getSubtotal() {
        return this.cantidad * this.precioUnitario;
    }
}