/*
 * 
*/
package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.*;

public class ProductosDAO {

    public void agregarProducto(Productos producto) {
        // Usamos la tabla 'empeados' y sus 5 columnas
        String sql = "INSERT INTO pedidos (nombre, dni, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecioVenta());
            pstmt.setInt(3, producto.getIdProveedor());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar empleado: " + e.getMessage());
        }
    } 
    
    public boolean modificarProducto(Productos producto) {
        // Usamos la tabla 'empleados' y sus 5 columnas en el SET
        String sql = "UPDATE pedidos SET nombre = ?, dni = ?, direccion = ?, telefono = ?, correo = ? WHERE id = ?"; 
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecioVenta());
            pstmt.setInt(3, producto.getIdProveedor());
            pstmt.setInt(4, producto.getId()); 

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) { /* manejo de errores */ }
        return false;
    }

    // ------------------------------------------------------------------------------------------------------------
    // Busca un producto específico por su ID.
    public Productos buscarPorId(int idBusqueda) {
        Productos producto = null;

        // Búsqueda exacta por ID
        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idBusqueda); 

            try (ResultSet rs = pstmt.executeQuery()) {
                // Si encuentra un resultado (solo debería haber uno)
                if (rs.next()) {
                    producto = crearProductoDesdeResultSet(rs);
                }
            }
        } 
        catch (SQLException e) { 
            System.err.println("Error al buscar por ID: " + e.getMessage());
        }
        return producto; // Devuelve el objeto o null si no lo encuentra
    }

    private Productos crearProductoDesdeResultSet(ResultSet rs) throws SQLException {
        Productos producto = new Productos();
        
        producto.setId(rs.getInt("id")); 
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecioVenta(rs.getDouble("precioVenta"));
        producto.setIdProveedor(rs.getInt("idProveedor")); 
        
        return producto;
    }
// ------------------------------------------------------------------------------------------------------------
// Devuelve todos los productos registrados (para usar en el listado general de stock)  PARTE AGREGADA DE STOCK NECESARIA.
public List<Productos> listarTodos() {
    List<Productos> lista = new ArrayList<>();
    String sql = "SELECT * FROM productos";

    try (Connection conn = ConexionDB.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Productos producto = new Productos();
            producto.setId(rs.getInt("id"));
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecioVenta(rs.getDouble("precioVenta"));
            producto.setIdProveedor(rs.getInt("idProveedor"));
            lista.add(producto);
        }

    } catch (SQLException e) {
        System.err.println("Error al listar productos: " + e.getMessage());
    }
    return lista;
}
    
    
}
