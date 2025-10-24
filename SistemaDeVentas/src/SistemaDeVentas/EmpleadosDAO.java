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
        String sql = "INSERT INTO empleados (nombre, telefono, email, cargo, salario) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getTelefono());
            pstmt.setString(3, empleado.getEmail());
            pstmt.setString(4, empleado.getCargo()); 
            pstmt.setDouble(5, empleado.getSalario());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar empleado: " + e.getMessage());
        }
    } 
    
    public boolean modificarEmpleado(Empleados empleado) {
        // Usamos la tabla 'empleados' y sus 5 columnas en el SET
        String sql = "UPDATE empleados SET nombre = ?, telefono = ?, email = ?, cargo = ?, salario = ? WHERE id = ?"; 
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getTelefono());
            pstmt.setString(3, empleado.getEmail());
            pstmt.setString(4, empleado.getCargo());
            pstmt.setDouble(5, empleado.getSalario());
            pstmt.setInt(6, empleado.getId()); 

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) { /* manejo de errores */ }
        return false;
    }
}
