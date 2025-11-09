/*
 * Clase modelo que representa a un empleado dentro del sistema.
 * Contiene toda la información personal, laboral y de contacto de un empleado.
 * 
 * @author Debuggers UTN
 */

package gestionempleados;

public class Empleado {

    // ===========================
    // Atributos del empleado
    // ===========================
    private int idEmpleado;         // Identificador único del empleado
    private String nombre;          // Nombre del empleado
    private String apellido;        // Apellido del empleado
    private String tipoDocumento;   // Tipo de documento (DNI, Pasaporte, etc.)
    private String nroDocumento;    // Número de documento
    private String cuil;            // Código Único de Identificación Laboral
    private String sexo;            // Sexo del empleado
    private String fechaNacimiento; // Fecha de nacimiento
    private String domicilio;       // Dirección del empleado
    private String barrio;          // Barrio donde reside
    private String localidad;       // Ciudad o localidad
    private String provincia;       // Provincia o estado
    private String codigoPostal;    // Código postal
    private String telCelular;      // Número de teléfono celular
    private String telFijo;         // Número de teléfono fijo
    private String email;           // Correo electrónico
    private String fechaIngreso;    // Fecha de ingreso a la empresa
    private String fechaEgreso;     // Fecha de egreso (si corresponde)
    private String puesto;          // Puesto o cargo dentro de la empresa
    private double sueldoBase;      // Sueldo base mensual
    private String horario;         // Horario laboral
    private int idUsuario;          // ID del usuario asociado en el sistema
    private boolean estado;         // true = activo, false = inactivo

    // ==========================================================
    // Constructor principal con los campos más relevantes
    // ==========================================================
    public Empleado(int idEmpleado, String nombre, String apellido, String puesto, double SueldoBase) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.sueldoBase = SueldoBase;
        this.estado = true; // Por defecto, el empleado está activo
    }

    // ==========================================================
    // Métodos Getters y Setters (acceso y modificación de datos)
    // ==========================================================
    public int getIdEmpleado() { return this.idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return this.apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getPuesto() { return this.puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public double getSueldoBase() { return this.sueldoBase; }
    public void setSueldoBase(double SueldoBase) { this.sueldoBase = SueldoBase; }

    public boolean isEstado() { return this.estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    // ==========================================================
    // Método toString(): retorna una descripción legible del objeto
    // ==========================================================
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado=").append(idEmpleado);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", puesto=").append(puesto);
        sb.append(", sueldoBase=").append(sueldoBase);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
}

