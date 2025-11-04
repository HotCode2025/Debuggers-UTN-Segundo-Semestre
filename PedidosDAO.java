/*
 * 
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.*;

public class PedidosDAO {

    public void agregarPedido(Pedidos pedido) {
        // Usamos la tabla 'empeados' y sus 5 columnas
        String sql = "INSERT INTO pedidos (nombre, dni, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setInt(1, pedido.getIdCliente());
            pstmt.setInt(2, pedido.getIdProducto());
            pstmt.setInt(3, pedido.getCantidad());
            pstmt.setDouble(4, pedido.getPrecioVenta());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar empleado: " + e.getMessage());
        }
    } 
    
    public boolean modificarPedido(Pedidos pedido) {
        // Usamos la tabla 'empleados' y sus 5 columnas en el SET
        String sql = "UPDATE pedidos SET nombre = ?, dni = ?, direccion = ?, telefono = ?, correo = ? WHERE id = ?"; 
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, pedido.getIdCliente());
            pstmt.setInt(2, pedido.getIdProducto());
            pstmt.setInt(3, pedido.getCantidad());
            pstmt.setDouble(4, pedido.getPrecioVenta());
            pstmt.setInt(6, pedido.getId()); 

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) { /* manejo de errores */ }
        return false;
    }
}
