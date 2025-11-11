/**
 * Clase que representa un producto disponible para la venta dentro del sistema.
 * Contiene los atributos principales de un producto, como su identificación única,
 * nombre, precio de venta y el identificador del proveedor asociado.
 *
 * @author Debuggers UTN - Bruno
 */
package SistemaDeVentas;

public class Productos {
    private int id;                 /** Identificador único del producto (clave primaria). */
    private String nombre;          /** Nombre o descripción del producto. */
    private Double precioVenta;     /** Precio de venta unitario del producto. */
    private int idProveedor;        /** Identificador del proveedor que suministra el producto. */

    /**
     * Constructor por defecto (vacío) de la clase Productos.
     * Permite crear una instancia de Producto sin inicializar sus atributos.
     */
    public Productos() {
        // Constructor vacio
    }

    /**
     * Constructor que inicializa un objeto Productos con todos sus atributos.
     *
     * @param id Identificador único del producto.
     * @param nombre Nombre o descripción del producto.
     * @param precioVenta Precio de venta unitario.
     * @param idProveedor Identificador del proveedor.
     */
    public Productos(int id, String nombre, Double precioVenta, int idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.idProveedor = idProveedor;
    }

    /**
     * Obtiene el identificador único del producto.
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     * @param id El nuevo ID del producto.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio de venta unitario del producto.
     * @return El precio de venta (Double).
     */
    public Double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Establece el precio de venta unitario del producto.
     * @param precioVenta El nuevo precio de venta (Double).
     */
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Obtiene el identificador del proveedor.
     * @return El ID del proveedor.
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * Establece el identificador del proveedor.
     * @param idProveedor El nuevo ID del proveedor.
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}