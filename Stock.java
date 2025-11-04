/*
 * 
*/

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

public class Stock {
    private int id;
    private int idProducto;
    private int idProveedor;
    private int cantidad;

    public Stock() {
    }

    public Stock(int id, int idProducto, int idProveedor, int cantidad) {
        this.id = id;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
