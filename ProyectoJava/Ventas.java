/*
 * CLASE: Venta
 * PROPÓSITO: Modelo de Objeto para la tabla 'ventas'.
 * Almacena los datos principales o de 'encabezado' de una venta.
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Alberto
*/

import java.time.LocalDateTime;
import java.util.List;

public class Ventas {
    private int id;
    private int idCliente;
    private int idEmpleado;
    private LocalDateTime fechaVenta;
    private double total;
    
    private List<VentasDetalle> itemsVentas; 

    public Ventas() {
        this.fechaVenta = LocalDateTime.now(); 
    }

    public Ventas(int idCliente, int idEmpleado, double total, List<VentasDetalle> items) {
        this(); 
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.total = total;
        this.itemsVentas = items; // Asigna la lista de detalles
    }
    
    // Getters 
    public int getId() { return id; }
    public int getIdCliente() { return idCliente; }
    public int getIdEmpleado() { return idEmpleado; }
    public LocalDateTime getFechaVenta() { return fechaVenta; }
    public double getTotal() { return total; }
    public List<VentasDetalle> getItemsVenta() { return this.itemsVentas; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }
    public void setTotal(double total) { this.total = total; }

    // 
    @Override
    public String toString() {
        return "Venta{" + 
                "id=" + id + 
                ", idCliente=" + idCliente + 
                ", idEmpleado=" + idEmpleado + 
                ", fechaVenta=" + fechaVenta + 
                ", total=" + total + 
                ", items=" + (itemsVentas != null ? itemsVentas.size() : 0) + 
                '}';
    }
}