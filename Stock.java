/*
 * Clase modelo que representa un registro de movimiento de stock.
 * Cada movimiento indica una entrada o salida de productos.
 */

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

public class Stock {
    private int id;            // Identificador único del movimiento de stock
    private int idProducto;    // ID del producto al que pertenece el movimiento
    private int idProveedor;   // ID del proveedor asociado al movimiento
    private int cantidad;      // Cantidad del movimiento (puede ser positiva o negativa)

    // Constructor vacío (necesario para algunos frameworks o inicializaciones por defecto)
    public Stock() {
    }

    // Constructor con parámetros para crear un nuevo movimiento de stock
    public Stock(int id, int idProducto, int idProveedor, int cantidad) {
        this.id = id;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
    }

    // Métodos getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
