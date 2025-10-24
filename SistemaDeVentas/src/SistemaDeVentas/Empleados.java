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
    private String telefono;
    private String email;
    private String cargo;     // Atributo específico
    private double salario;   // Atributo específico    

    public Empleados() {
    }

    public Empleados(int id, String nombre, String telefono, String email, String cargo, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.cargo = cargo;
        this.salario = salario;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
