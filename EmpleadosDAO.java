/*
 * Clase encargada de la comunicación entre la aplicación y la base de datos
 * para realizar las operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * del módulo de Empleados.
 */

package SistemaDeVentas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Debuggers UTN - Celeste
 */

public class EmpleadosDAO {

    // ==========================================================
    // MÉTODO: agregarEmpleado
    // ==========================================================
    /*
     * Inserta un nuevo registro en la tabla 'empleados'.
     * Usa un PreparedStatement para prevenir inyecciones SQL
     * y manejar de forma segura los parámetros.
     */
    public void agregarEmpleado(Empleados empleado) {
        String sql = "INSERT INTO empleados (nombre, apellido, dni, direccion, telefono, correo, puesto, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asignamos cada atributo del empleado a su posición en la consulta
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getDni());
            pstmt.setString(4, empleado.getDireccion());
            pstmt.setString(5, empleado.getTelefono());
            pstmt.setString(6, empleado.getCorreo());
            pstmt.setString(7, empleado.getPuesto());
            pstmt.setDouble(8, empleado.getSueldo());
            
            pstmt.executeUpdate(); // Ejecuta la inserción
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar empleado: " + e.getMessage());
        }
    } 
    
    // ==========================================================
    // MÉTODO: modificarEmpleado
    // ==========================================================
    /*
     * Actualiza los datos de un empleado existente en la base de datos,
     * identificándolo por su ID.
     */
    public boolean modificarEmpleado(Empleados empleado) {
        String sql = "UPDATE empleados SET nombre = ?, apellido = ?, dni = ?, direccion = ?, telefono = ?, correo = ?, puesto = ?, sueldo = ? WHERE id = ?"; 
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getDni());
            pstmt.setString(4, empleado.getDireccion());
            pstmt.setString(5, empleado.getTelefono());
            pstmt.setString(6, empleado.getCorreo());
            pstmt.setString(7, empleado.getPuesto());
            pstmt.setDouble(8, empleado.getSueldo());
            pstmt.setInt(9, empleado.getId()); 

            // Devuelve true si se actualizó al menos un registro
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) { 
            System.err.println("Error al modificar empleado: " + e.getMessage());
        }
        return false;
    }

    // ==========================================================
    // MÉTODO: buscarPorId
    // ==========================================================
    /*
     * Busca un empleado por su ID en la base de datos.
     * Devuelve el objeto Empleados correspondiente o null si no lo encuentra.
     */
    public Empleados buscarPorId(int idBusqueda) {
        Empleados empleado = null;
        String sql = "SELECT * FROM empleados WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idBusqueda); 

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    empleado = crearEmpleadoDesdeResultSet(rs);
                }
            }
        } 
        catch (SQLException e) { 
            System.err.println("Error al buscar por ID: " + e.getMessage());
        }
        return empleado;
    }

    // ==========================================================
    // MÉTODO: listarTodos
    // ==========================================================
    /*
     * Recupera todos los registros de la tabla empleados
     * y los devuelve en una lista de objetos Empleados.
     */
    public List<Empleados> listarTodos() {
        List<Empleados> listaEmpleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Empleados empleado = crearEmpleadoDesdeResultSet(rs);
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar todos los empleados: " + e.getMessage());
        }
        return listaEmpleados;
    }
    
    // ==========================================================
    // MÉTODO AUXILIAR: crearEmpleadoDesdeResultSet
    // ==========================================================
    /*
     * Crea un objeto Empleados a partir de los datos obtenidos
     * de una fila del ResultSet (resultado de una consulta SQL).
     */
    private Empleados crearEmpleadoDesdeResultSet(ResultSet rs) throws SQLException {
        Empleados empleado = new Empleados();
        empleado.setId(rs.getInt("id"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido(rs.getString("apellido"));
        empleado.setDni(rs.getString("dni"));
        empleado.setDireccion(rs.getString("direccion"));
        empleado.setTelefono(rs.getString("telefono"));
        empleado.setCorreo(rs.getString("correo"));
        empleado.setPuesto(rs.getString("puesto"));
        empleado.setSueldo(rs.getDouble("sueldo"));
        return empleado;
    }
}
