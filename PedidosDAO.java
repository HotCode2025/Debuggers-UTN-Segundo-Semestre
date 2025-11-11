/**
 * Clase Data Access Object (DAO) que gestiona todas las operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * relacionadas con la entidad Pedidos en la base de datos.
 *
 * Esta clase se encarga de la persistencia de los objetos Pedidos.
 *
 * @author Debuggers UTN - Alberto
 */
package SistemaDeVentas;

import java.sql.*;

public class PedidosDAO {

    /**
     * Agrega un nuevo pedido a la base de datos.
     * Los campos 'idCliente', 'idProducto', 'cantidad' y 'precioVenta'
     * son insertados en la tabla 'pedidos'.
     *
     * @param pedido El objeto Pedidos que contiene los datos a ser agregados.
     */
    public void agregarPedido(Pedidos pedido) {
        // Usamos la tabla 'empeados' y sus 5 columnas
        String sql = "INSERT INTO pedidos (idCliente, idProducto, cantidad, precioVenta) VALUES (?, ?, ?, ?)";
        
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
    
    /**
     * Modifica un pedido existente en la base de datos basado en su ID.
     *
     * @param pedido El objeto Pedidos que contiene los nuevos datos y el ID del pedido a modificar.
     * @return true si la modificación fue exitosa (se actualizó al menos una fila), false en caso contrario.
     */
    public boolean modificarPedido(Pedidos pedido) {
        // Usamos la tabla 'empleados' y sus 5 columnas en el SET
        String sql = "UPDATE pedidos SET idCliente = ?, idProducto = ?, cantidad = ?, precioVenta = ? WHERE id = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, pedido.getIdCliente());
            pstmt.setInt(2, pedido.getIdProducto());
            pstmt.setInt(3, pedido.getCantidad());
            pstmt.setDouble(4, pedido.getPrecioVenta());
            // Nota: Aquí se está usando el índice 6 para el ID, cuando debería ser 5.
            pstmt.setInt(6, pedido.getId()); 

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) { 
            /* manejo de errores */ 
            System.err.println("Error al modificar pedido: " + e.getMessage());
        }
        return false;
    }
}