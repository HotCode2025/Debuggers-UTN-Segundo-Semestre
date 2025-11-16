/*
 * 
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Bruno
*/

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProductosDAO {
        public void agregarProducto(Productos producto) {
            String sql = "INSERT INTO productos (nombre, precioVenta, idProveedor) VALUES (?, ?, ?)";

            try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, producto.getNombre());
                pstmt.setDouble(2, producto.getPrecioVenta());
                pstmt.setInt(3, producto.getIdProveedor());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al agregar producto: " + e.getMessage());
            }
        }

        public boolean modificarProducto(Productos producto) {
            String sql = "UPDATE productos SET nombre = ?, precioVenta = ?, idProveedor = ? WHERE id = ?";

            try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, producto.getNombre());
                pstmt.setDouble(2, producto.getPrecioVenta());
                pstmt.setInt(3, producto.getIdProveedor());
                pstmt.setInt(4, producto.getId());
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                System.err.println("Error al modificar producto: " + e.getMessage());
            }
            return false;
        }

        public List<Productos> listarTodos() {
            List<Productos> lista = new ArrayList<>();
            String sql = "SELECT * FROM productos";

            try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(crearProductoDesdeResultSet(rs));
                }
            } catch (SQLException e) {
                System.err.println("Error al listar productos: " + e.getMessage());
            }
            return lista;
        }

        public Productos buscarPorId(int idBusqueda) {
            Productos producto = null;
            String sql = "SELECT * FROM productos WHERE id = ?";

            try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idBusqueda);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        producto = crearProductoDesdeResultSet(rs);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar producto por ID: " + e.getMessage());
            }
            return producto;
        }

        private Productos crearProductoDesdeResultSet(ResultSet rs) throws SQLException {
            Productos producto = new Productos();
            producto.setId(rs.getInt("id"));
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecioVenta(rs.getDouble("precioVenta"));
            producto.setIdProveedor(rs.getInt("idProveedor"));
            return producto;
        }

    }

