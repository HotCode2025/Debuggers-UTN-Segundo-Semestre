/*
 * 
*/

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.*;

public class EmpleadosDAO {

    public void agregarEmpleado(Empleados empleado) {
        // Usamos la tabla 'empeados' y sus 5 columnas
        String sql = "INSERT INTO empleados (nombre, dni, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getDni());
            pstmt.setString(3, empleado.getDireccion());
            pstmt.setString(4, empleado.getTelefono());
            pstmt.setString(5, empleado.getCorreo());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar empleado: " + e.getMessage());
        }
    } 
    
    public boolean modificarEmpleado(Empleados empleado) {
        // Usamos la tabla 'empleados' y sus 5 columnas en el SET
        String sql = "UPDATE empleados SET nombre = ?, dni = ?, direccion = ?, telefono = ?, correo = ? WHERE id = ?"; 
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getDni());
            pstmt.setString(3, empleado.getDireccion());
            pstmt.setString(4, empleado.getTelefono());
            pstmt.setString(5, empleado.getCorreo());
            pstmt.setInt(6, empleado.getId()); 

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) { /* manejo de errores */ }
        return false;
    }
}
