/**
 * Clase que representa un pedido dentro del sistema de ventas.
 * Contiene información detallada sobre el pedido, incluyendo la identificación
 * del cliente, el producto solicitado, la cantidad y el precio de venta unitario.
 *
 * @author Debuggers UTN - Alberto
 */
package SistemaDeVentas;

public class Pedidos {
    private int id;             /** Identificador único del pedido (clave primaria). */
    private int idCliente;      /** Identificador del cliente que realiza el pedido. */
    private int idProducto;     /** Identificador del producto solicitado. */
    private int cantidad;       /** Cantidad de unidades del producto solicitadas en este pedido. */
    private Double precioVenta; /** Precio unitario de venta acordado para este producto en el pedido. */

    /**
     * Constructor por defecto de la clase Pedidos.
     * Inicializa un nuevo objeto Pedidos sin valores preestablecidos.
     */
    public Pedidos() {
    }

    /**
     * Constructor que permite inicializar un objeto Pedidos con todos sus atributos.
     *
     * @param id Identificador único del pedido.
     * @param idCliente Identificador del cliente.
     * @param idProducto Identificador del producto.
     * @param cantidad Cantidad de producto solicitado.
     * @param precioVenta Precio unitario de venta.
     */
    public Pedidos(int id, int idCliente, int idProducto, int cantidad, Double precioVenta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    /**
     * Obtiene el identificador único del pedido.
     * @return El ID del pedido.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el identificador del cliente.
     * @return El ID del cliente asociado al pedido.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente.
     * @param idCliente El nuevo ID del cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el identificador del producto solicitado.
     * @return El ID del producto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador del producto.
     * @param idProducto El nuevo ID del producto.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene la cantidad de unidades del producto solicitadas.
     * @return La cantidad total.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades del producto solicitado.
     * @param cantidad La nueva cantidad.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio unitario de venta.
     * @return El precio de venta (Double).
     */
    public Double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Establece el precio unitario de venta para el pedido.
     * @param precioVenta El nuevo precio de venta (Double).
     */
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}