/*
 * 
 */

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

public class Pedidos {
    private int id;
    private int idCliente;
    private int idProducto;
    private int cantidad;
    private Double precioVenta;

    public Pedidos() {
    }

    public Pedidos(int id, int idCliente, int idProducto, int cantidad, Double precioVenta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    
    
}
