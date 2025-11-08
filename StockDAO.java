/*
 * Clase DAO (Data Access Object) que maneja las operaciones con la base de datos
 * relacionadas con el stock de productos.
 */

package SistemaDeVentas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Debuggers UTN - Fede
*/

public class StockDAO {

    // Inserta un nuevo movimiento de stock en la base de datos (entrada o salida)
    public void agregarMovimiento(Stock movimiento) {
        String sql = "INSERT INTO stock (idProducto, idProveedor, cantidad) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, movimiento.getIdProducto());
            pstmt.setInt(2, movimiento.getIdProveedor());
            pstmt.setInt(3, movimiento.getCantidad());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al agregar movimiento de stock: " + e.getMessage());
        }
    }

    // Lista todos los movimientos de stock registrados
    public List<Stock> listarMovimientos() {
        List<Stock> lista = new ArrayList<>();
        String sql = "SELECT * FROM stock";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Stock s = new Stock(
                        rs.getInt("id"),
                        rs.getInt("idProducto"),
                        rs.getInt("idProveedor"),
                        rs.getInt("cantidad")
                );
                lista.add(s);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar movimientos de stock: " + e.getMessage());
        }
        return lista;
    }

    // Calcula el stock actual de un producto (entradas - ventas)
    public int obtenerStockPorProducto(int idProducto) {
        String sql = "SELECT COALESCE((SELECT SUM(cantidad) FROM stock WHERE idproducto = ?), 0) - " +
                     "COALESCE((SELECT SUM(cantidad) FROM ventas_detalle WHERE id_producto = ?), 0) AS StockReal";
          
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idProducto);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("StockReal");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al calcular stock: " + e.getMessage());
        }
        return 0;
    }
    
    /*
     * Descuenta stock después de una venta.
     * Si no se encuentra el producto, muestra una advertencia.
     */
    public void descontarStock(int productoId, int cantidadVendida) throws SQLException {
        String sql = "UPDATE stock SET cantidad_stock = cantidad_stock - ? WHERE producto_id = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cantidadVendida);
            pstmt.setInt(2, productoId);
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas == 0) {
                System.out.println("ADVERTENCIA: No se encontró registro de stock para el producto ID " + productoId);
            } else {
                System.out.println("Stock actualizado: -" + cantidadVendida + " unidades del producto ID " + productoId);
            }
        } catch (SQLException e) { 
            System.err.println("ERROR CRÍTICO: No se pudo descontar stock del producto " + productoId);
            throw e;
        }
    }
}
