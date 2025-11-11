/**
 * Clase que representa a un Proveedor que suministra productos al sistema de ventas.
 * Contiene información detallada de contacto, dirección y el tipo de productos
 * que proporciona.
 *
 * @author Debuggers UTN - Kevin
 */
package SistemaDeVentas;

public class Proveedores {
    private int id;                 /** Identificador único del proveedor (clave primaria). */
    private String nombre;          /** Nombre comercial o razón social del proveedor. */
    private String telefono;        /** Número de contacto del proveedor. */
    private String correo;          /** Dirección de correo electrónico del proveedor. */
    private String direccion;       /** Dirección física o postal del proveedor. */
    private String representante;   /** Nombre de la persona de contacto clave dentro del proveedor. */
    private String tipoProductos;   /** Descripción de la categoría de productos que suministra (ej. 'Lácteos', 'Electrónica'). */

    /**
     * Constructor por defecto de la clase Proveedores.
     * Permite crear una instancia sin inicializar sus atributos.
     */
    public Proveedores() {
    }

    /**
     * Constructor que inicializa un objeto Proveedores con todos sus atributos.
     *
     * @param id Identificador único del proveedor.
     * @param nombre Nombre del proveedor.
     * @param telefono Teléfono de contacto.
     * @param correo Correo electrónico.
     * @param direccion Dirección física.
     * @param representante Nombre del representante de ventas.
     * @param tipoProductos Tipo de productos que suministra.
     */
    public Proveedores(int id, String nombre, String telefono, String correo, String direccion, String representante, String tipoProductos) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.representante = representante;
        this.tipoProductos = tipoProductos;
    }

    /**
     * Obtiene el identificador único del proveedor.
     * @return El ID del proveedor.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del proveedor.
     * @param id El nuevo ID del proveedor.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre o razón social del proveedor.
     * @return El nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre o razón social del proveedor.
     * @param nombre El nuevo nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono del proveedor.
     * @return El número de teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del proveedor.
     * @param telefono El nuevo número de teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección de correo electrónico del proveedor.
     * @return La dirección de correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece la dirección de correo electrónico del proveedor.
     * @param correo La nueva dirección de correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la dirección física o postal del proveedor.
     * @return La dirección del proveedor.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección física o postal del proveedor.
     * @param direccion La nueva dirección.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre del representante de ventas del proveedor.
     * @return El nombre del representante.
     */
    public String getRepresentante() {
        return representante;
    }

    /**
     * Establece el nombre del representante de ventas del proveedor.
     * @param representante El nuevo nombre del representante.
     */
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    /**
     * Obtiene la descripción del tipo de productos que suministra el proveedor.
     * @return El tipo de productos.
     */
    public String getTipoProductos() {
        return tipoProductos;
    }

    /**
     * Establece la descripción del tipo de productos que suministra el proveedor.
     * @param tipoProductos El nuevo tipo de productos.
     */
    public void setTipoProductos(String tipoProductos) {
        this.tipoProductos = tipoProductos;
    }

    /**
     * Proporciona una representación en cadena de texto del objeto Proveedor,
     * incluyendo todos sus atributos.
     *
     * @return Una cadena de texto con los detalles del proveedor.
     */
    @Override
    public String toString() {
        return "Proveedor {" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Correo='" + correo + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Representante='" + representante + '\'' +
                ", Tipo de productos='" + tipoProductos + '\'' +
                '}';
    }
}