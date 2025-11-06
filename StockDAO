package SistemaDeVentas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {

    // Agregar movimiento (entrada o salida)
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

    // Listar todos los movimientos registrados
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

    // Calcular stock actual por producto (sumando movimientos)
    public int obtenerStockPorProducto(int idProducto) {
        String sql = "SELECT SUM(cantidad) AS total FROM stock WHERE idProducto = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idProducto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al calcular stock: " + e.getMessage());
        }
        return 0;
    }
}
