/**
 * Clase Data Access Object (DAO) que gestiona todas las operaciones de persistencia (CRUD)
 * relacionadas con la entidad Proveedores en la base de datos.
 *
 * Utiliza JDBC para la comunicación y la clase ConexionDB para obtener las conexiones.
 *
 * @author Debuggers UTN - Kevin
 */
package SistemaDeVentas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {
    
    /**
     * Agrega un nuevo proveedor a la base de datos.
     * Los datos son insertados en la tabla 'proveedores', asumiendo que el ID es auto-incremental.
     *
     * @param proveedor El objeto Proveedores que contiene los datos a ser agregados.
     */
    public void agregarProveedor(Proveedores proveedor) {
        // Sentencia SQL para la inserción.
        String sql = "INSERT INTO proveedores (nombre, telefono, correo, direccion, representante, tipoProductos) VALUES (?, ?, ?, ?, ? , ?)";
        
        // Uso de try-with-resources para asegurar el cierre automático de Connection y PreparedStatement.
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            // Asignación de parámetros a la sentencia SQL (índices 1 a 6).
            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getTelefono());
            pstmt.setString(3, proveedor.getCorreo());
            pstmt.setString(4, proveedor.getDireccion());
            pstmt.setString(5, proveedor.getRepresentante());
            pstmt.setString(6, proveedor.getTipoProductos());

            // Ejecuta la inserción.
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            // Manejo de errores específicos de la base de datos.
            System.err.println("Error al agregar proveedor: " + e.getMessage());
        }
    }
    
    /**
     * Modifica los datos de un proveedor existente en la base de datos.
     * La modificación se realiza buscando por el ID del proveedor.
     *
     * @param proveedor El objeto Proveedores que contiene los nuevos datos y el ID del registro a modificar.
     * @return true si la modificación fue exitosa (se actualizó al menos una fila), false en caso contrario.
     */
    public boolean modificarProveedor(Proveedores proveedor) {
        // Sentencia SQL para la actualización (UPDATE).
        String sql = "UPDATE proveedores SET nombre = ?, telefono = ?, correo = ?, direccion = ?, representante = ?, tipoProductos = ? WHERE id = ?";
        
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            // Asignación de los 6 campos a modificar (índices 1 a 6).
            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getTelefono());
            pstmt.setString(3, proveedor.getCorreo());
            pstmt.setString(4, proveedor.getDireccion());
            pstmt.setString(5, proveedor.getRepresentante());
            pstmt.setString(6, proveedor.getTipoProductos());
            
            // Asignación del ID para la cláusula WHERE (índice 7).
            pstmt.setInt(7, proveedor.getId()); 
      
            // Ejecuta el UPDATE y devuelve true si se afectó al menos una fila.
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) { 
            System.err.println("Error al modificar proveedor: " + e.getMessage());
        }
        return false;
    } 
    
    /**
     * Busca proveedores por una coincidencia parcial e insensible a mayúsculas/minúsculas en el nombre.
     *
     * @param terminoBusqueda La cadena de texto a buscar dentro del nombre del proveedor.
     * @return Una lista de objetos Proveedores que coinciden con el término de búsqueda.
     */
    public List<Proveedores> buscarPorNombre(String terminoBusqueda) {
        List<Proveedores> proveedoresEncontrados = new ArrayList<>();

        // Uso de LIKE y LOWER() para búsqueda flexible e insensible a mayúsculas.
        String sql = "SELECT * FROM proveedores WHERE LOWER(nombre) LIKE LOWER(?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Prepara el término de búsqueda añadiendo comodines '%' al inicio y al final.
            pstmt.setString(1, "%" + terminoBusqueda + "%"); 

            try (ResultSet rs = pstmt.executeQuery()) {
                // Itera sobre los resultados y los convierte en objetos Proveedores.
                while (rs.next()) {
                    proveedoresEncontrados.add(crearProveedoresDesdeResultSet(rs));
                }
            }
        } 
        catch (SQLException e) { 
            System.err.println("Error al buscar por nombre: " + e.getMessage());
        }
        return proveedoresEncontrados;
    } 
    
    /**
     * Busca un proveedor específico por su identificador único (ID).
     *
     * @param idBusqueda El ID del proveedor a buscar.
     * @return El objeto Proveedores si es encontrado, o null si no existe.
     */
    public Proveedores buscarPorId(int idBusqueda) {
        Proveedores proveedor = null;

        // Sentencia SQL para la búsqueda exacta por ID.
        String sql = "SELECT * FROM proveedores WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idBusqueda); 

            try (ResultSet rs = pstmt.executeQuery()) {
                // Si el ResultSet contiene al menos una fila, crea el objeto Proveedores.
                if (rs.next()) {
                    proveedor = crearProveedoresDesdeResultSet(rs);
                }
            }
        } 
        catch (SQLException e) { 
            System.err.println("Error al buscar por ID: " + e.getMessage());
        }
        return proveedor; 
    }
    
    /**
     * Recupera una lista completa de todos los proveedores registrados en la base de datos.
     *
     * @return Una lista de objetos Proveedores. La lista estará vacía si no hay registros.
     */
    public List<Proveedores> listarTodos() {
        List<Proveedores> listaProveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try ( Connection conn = ConexionDB.getConnection(); 
              PreparedStatement pstmt = conn.prepareStatement(sql); 
              ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Proveedores proveedor = crearProveedoresDesdeResultSet(rs);
                listaProveedores.add(proveedor);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar todos los proveedores: " + e.getMessage());
        }
        return listaProveedores;
    }

    
    /**
     * Método de utilidad privado para mapear los datos de una fila (ResultSet) de la base de datos
     * a un objeto Proveedores.
     *
     * @param rs El ResultSet posicionado en la fila actual.
     * @return Un objeto Proveedores con los datos mapeados.
     * @throws SQLException Si ocurre un error al acceder a las columnas del ResultSet.
     */
    private Proveedores crearProveedoresDesdeResultSet(ResultSet rs) throws SQLException {
        Proveedores proveedor = new Proveedores();
        proveedor.setId(rs.getInt("id"));
        proveedor.setNombre(rs.getString("nombre"));
        proveedor.setTelefono(rs.getString("telefono"));
        proveedor.setCorreo(rs.getString("correo"));
        proveedor.setDireccion(rs.getString("direccion"));
        proveedor.setRepresentante(rs.getString("representante"));
        proveedor.setTipoProductos(rs.getString("tipoproductos"));
        return proveedor;
    }
}