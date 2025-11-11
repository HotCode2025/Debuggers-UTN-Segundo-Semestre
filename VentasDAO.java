/*
 * CLASE: VentasDAO
 * PROPÓSITO: Manejo de la persistencia de las ventas, incluyendo el encabezado
 * y los detalles, utilizando transacciones de base de datos.
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Alberto
*/

import java.sql.*;

public class VentasDAO {

    // ------------------------------------------------------------------------------------------------------------
    // Agregamos una nueva venta (Encabezado y Detalle)
    public boolean guardarVenta(Ventas venta) {
        // SQL para insertar el encabezado de la venta
        String sqlVenta = "INSERT INTO ventas (id_cliente, id_empleado, fecha_venta, total) VALUES (?, ?, NOW(), ?)";
        // SQL para insertar un item de detalle.
        String sqlDetalle = "INSERT INTO ventas_detalle (id_venta, id_producto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = null;

        try {
            conn = ConexionDB.getConnection();
            conn.setAutoCommit(false);
            
            // Guardamos el encabezado de la venta
            try (PreparedStatement pstmtVenta = conn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
                
                // Analizamos si el cliente es "Consumidor Final" (ID = 0)
                if (venta.getIdCliente() == 0) {
                    // Si el ID es 0, insertamos NULL en la base de datos
                    pstmtVenta.setNull(1, java.sql.Types.INTEGER);
                } else {
                    // Si es un ID > 0, lo insertamos normalmente
                    pstmtVenta.setInt(1, venta.getIdCliente());
                }

                pstmtVenta.setInt(2, venta.getIdEmpleado());
                pstmtVenta.setDouble(3, venta.getTotal());
                
                int filasAfectadas = pstmtVenta.executeUpdate();
                
                if (filasAfectadas == 0) {
                    throw new SQLException("Falló al guardar la venta, no se insertaron filas en 'ventas'.");
                }
                
                // Obtener el ID de la venta recién generada
                try (ResultSet generatedKeys = pstmtVenta.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        venta.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Falló al crear la venta, no se obtuvo el ID.");
                    }
                }
            }
            
            // Guardamos el detalle de la venta
            try (PreparedStatement pstmtDetalle = conn.prepareStatement(sqlDetalle)) {

                // Recorremos VentasDetalle
                for (VentasDetalle detalle : venta.getItemsVenta()) {
                    pstmtDetalle.setInt(1, venta.getId()); // ID de la venta (obtenido arriba)
                    pstmtDetalle.setInt(2, detalle.getIdProducto());
                    pstmtDetalle.setInt(3, detalle.getCantidad());
                    pstmtDetalle.setDouble(4, detalle.getPrecioUnitario());
                    pstmtDetalle.setDouble(5, detalle.getSubtotal());
                    
                    pstmtDetalle.addBatch(); 
                }
                
                // Ejecutar todas las inserciones por lotes
                pstmtDetalle.executeBatch();
            }
            
            // Verificamos si se pudo grabar el detalle de la venta
            conn.commit();
            System.out.println("Venta ID " + venta.getId() + " guardada exitosamente.");
            return true;
            
        } catch (SQLException e) { 
            // Si algo falla cuando se graba la venta o el detalle llegamos aca
            System.err.println("Error al guardar la venta. Se hará ROLLBACK: " + e.getMessage());
            if (conn != null) {
                try {
                    // Deshacemos todos los cambios realizados en esta transacción
                    conn.rollback();
                    System.err.println("Rollback realizado.");
                } catch (SQLException ex) {
                    System.err.println("Error durante el rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            // 6. Si todo salio bien restauramos el estado de AUTO-COMMIT 
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión o restaurar auto-commit: " + e.getMessage());
                }
            }
        }
    } 
}