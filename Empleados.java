/*
 * 
 */

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

public class Empleados {
    private int id;
    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;
    private String correo;

    public Empleados() {
        // Constructor vacio
    }

    public Empleados(int id, String nombre, String dni, String direccion, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
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
}
