/*
 * CLASE: Clientes
 *
 * PROPÓSITO:
 * Esta clase actúa como el Modelo de Objeto de Dominio (Entity/POJO) para la tabla 'clientes' 
 * en la base de datos. Almacena la información de un único cliente y proporciona los métodos 
 * de acceso (getters y setters) para cada uno de sus atributos.
 */

package SistemaDeVentas;

/*
 * @author Debuggers UTN - Jairo
*/
/**
 * Representa la entidad Cliente.
 * Esta clase es un POJO (Plain Old Java Object) que mapea la tabla 'clientes'
 * de la base de datos.
 */
public class Clientes {

    // --- Atributos Privados ---
    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    /**
     * Constructor vacío (sin argumentos).
     * Requerido para ciertas librerías (como frameworks de persistencia) y para
     * instanciar el objeto antes de llenarlo (ej. usando setters).
     */
    public Clientes() {
        // Constructor vacio
    }

    /**
     * Constructor que inicializa todos los atributos del cliente.
     *
     * @param id Identificador único del cliente (llave primaria).
     * @param nombre Nombre del cliente.
     * @param telefono Número de teléfono.
     * @param correo Dirección de correo electrónico.
     * @param direccion Dirección física (domicilio).
     */
    public Clientes(int id, String nombre, String telefono, String correo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    // --- Métodos de Acceso (Getters y Setters) ---
    // --- Métodos de Acceso (Getters y Setters) ---
    /**
     * Obtiene el ID del cliente.
     *
     * @return El ID numérico del cliente.
     */
    public int getId() { 
        return this.id;
    }

    /**
     * Establece el ID del cliente.
     *
     * @param id El nuevo ID numérico para el cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre para el cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return El teléfono del cliente.
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono El nuevo número de teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return El email del cliente.
     */
    public String getCorreo() {
        return this.correo;
    }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param correo El nuevo correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la dirección física del cliente.
     *
     * @return La dirección del cliente.
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Establece la dirección física del cliente.
     *
     * @param direccion La nueva dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Sobrescribe el método toString() para devolver una representación en cadena
     * del objeto Cliente.
     * Útil para depuración y para mostrar el objeto en logs o en la consola
     * (ej. en buscarPorId).
     *
     * @return Una cadena que describe al cliente con todos sus atributos.
     */
    @Override
    public String toString() {
        return "Cliente{" + 
                "ID=" + id + 
                ", Nombre='" + nombre + '\'' + 
                ", Teléfono='" + telefono + '\'' + 
                ", Correo='" + correo + '\'' + 
                ", Dirección='" + direccion + '\'' + 
                '}';
        }
}
