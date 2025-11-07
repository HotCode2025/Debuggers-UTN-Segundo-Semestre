/*
 * Clase ProductosDAO
 * Encargada de realizar todas las operaciones CRUD (Create, Read, Update, Delete)
 * sobre la tabla "productos" en la base de datos.
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Bruno
 */

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProductosDAO {

    /**
     * Inserta un nuevo producto en la base de datos.
     * @param producto Objeto de tipo Productos con los datos a guardar.
     */
    public void agregarProducto(Productos producto) {
        String sql = "INSERT INTO productos (nombre, precioVenta, idProveedor) VALUES (?, ?, ?)";

        // try-with-resources: cierra automáticamente la conexión y el PreparedStatement
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asignación de parámetros en la consulta SQL
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecioVenta());
            pstmt.setInt(3, producto.getIdProveedor());

            // Ejecuta la instrucción INSERT
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al agregar producto: " + e.getMessage());
        }
    }

    /**
     * Modifica un producto existente en la base de datos.
     * @param producto Objeto con los nuevos datos y su ID correspondiente.
     * @return true si la actualización fue exitosa, false si no se modificó ninguna fila.
     */
    public boolean modificarProducto(Productos producto) {
        String sql = "UPDATE productos SET nombre = ?, precioVenta = ?, idProveedor = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asigna los nuevos valores a los campos de la tabla
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecioVenta());
            pstmt.setInt(3, producto.getIdProveedor());
            pstmt.setInt(4, producto.getId());

            // Devuelve true si se actualizó al menos un registro
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al modificar producto: " + e.getMessage());
        }
        return false;
    }

    /**
     * Devuelve una lista con todos los productos almacenados en la base de datos.
     * @return Lista de objetos Productos.
     */
    public List<Productos> listarTodos() {
        List<Productos> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Recorre los resultados del SELECT y los convierte en objetos Productos
            while (rs.next()) {
                lista.add(crearProductoDesdeResultSet(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Busca un producto en la base de datos según su ID.
     * @param idBusqueda ID del producto a buscar.
     * @return Objeto Productos encontrado o null si no existe.
     */
    public Productos buscarPorId(int idBusqueda) {
        Productos producto = null;
        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idBusqueda);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Si existe un resultado, se crea el objeto producto correspondiente
                if (rs.next()) {
                    producto = crearProductoDesdeResultSet(rs);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar producto por ID: " + e.getMessage());
        }

        return producto;
    }

    /**
     * Crea un objeto Productos a partir de una fila del ResultSet.
    
     * @param rs ResultSet con los datos de la consulta.
     * @return Objeto Productos con los datos de la fila actual.
     * @throws SQLException si ocurre un error al leer los datos del ResultSet.
     */
    private Productos crearProductoDesdeResultSet(ResultSet rs) throws SQLException {
        Productos producto = new Productos();

        // Asignar los valores obtenidos de la base de datos al objeto
        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecioVenta(rs.getDouble("precioVenta"));
        producto.setIdProveedor(rs.getInt("idProveedor"));

        return producto;
    }
}