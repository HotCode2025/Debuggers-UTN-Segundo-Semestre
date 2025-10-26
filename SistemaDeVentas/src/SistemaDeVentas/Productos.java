/*
 * 
 */

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

public class Productos {
    private int id;
    private String nombre;
    private Double precioVenta;
    private int idProveedor;

    public Productos() {
        // Constructor vacio
    }

    public Productos(int id, String nombre, Double precioVenta, int idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.idProveedor = idProveedor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }


    
}
