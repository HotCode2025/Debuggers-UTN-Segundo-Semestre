/*
 * Clase modelo que representa a un empleado dentro del sistema de ventas.
 * Su función principal es almacenar y manejar toda la información relevante
 * de cada empleado, como sus datos personales y laborales.
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Celeste
 */
public class Empleados {
    
    // ==========================
    // Atributos o propiedades
    // ==========================

    private int id;              // Identificador único del empleado
    private String nombre;       // Nombre del empleado
    private String apellido;     // Apellido del empleado
    private String dni;          // Documento Nacional de Identidad
    private String direccion;    // Domicilio del empleado
    private String telefono;     // Número de teléfono de contacto
    private String correo;       // Correo electrónico del empleado
    private String puesto;       // Cargo o puesto que ocupa en la empresa
    private double sueldo;       // Sueldo base correspondiente al empleado

    // ==========================
    // Constructores
    // ==========================

    // Constructor vacío (necesario para inicializaciones por defecto o frameworks)
    public Empleados() {
    }

    /*
     * Constructor con parámetros.
     * Permite crear objetos Empleados con todos sus atributos definidos al momento de instanciar.
     */
    public Empleados(int id, String nombre, String apellido, String dni, String direccion, 
                     String telefono, String correo, String puesto, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    // ==========================
    // Métodos Getters y Setters
    // ==========================
    // Permiten acceder y modificar los valores de los atributos de forma controlada.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    // ==========================
    // Método toString()
    // ==========================
    /*
     * Este método sobrescribe el método toString() de la clase Object.
     * Su objetivo es devolver una representación en texto del objeto Empleados,
     * mostrando todos sus atributos de manera legible.
     * 
     * Es útil para mostrar información por consola o en interfaces gráficas.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("id=").append(id);
        sb.append(", Nombre=").append(nombre);
        sb.append(", Apellido=").append(apellido);
        sb.append(", Nro Documento=").append(dni);
        sb.append(", Dirección=").append(direccion);
        sb.append(", Nro Teléfono=").append(telefono);
        sb.append(", Correo=").append(correo);
        sb.append(", Puesto=").append(puesto);
        sb.append(", Sueldo=").append(sueldo);
        sb.append('}');
        return sb.toString();
    }
}
