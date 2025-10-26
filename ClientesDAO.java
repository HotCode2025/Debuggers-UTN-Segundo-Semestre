/*
 * CLASE: ClientesDAO
 * * PROPÓSITO:
 * Esta clase se encarga del acceso a la base de datos para la entidad 'Clientes'. (DAO - Data Access Object)
 * Su tarea es centralizar y gestionar todas las interacciones entre la aplicación y la tabla 'clientes' 
 * de la base de datos MySQL.
 * * FUNCIONALIDADES INCLUIDAS:
 * - agregarCliente: Métodos para insertar nuevos clientes.
 * - modificarCliente: Métodos para modificar datos de clientes existentes.
 * - buscarPorNombre: Busca clientes por una coincidencia parcial en el nombre.
 * - buscarPorId: Busca un cliente específico por su ID.
 * * DEPENDENCIA:
 * Requiere la clase 'Clientes' (modelo) y la clase 'ConexionDB' (para obtener la conexión a la base de datos).
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    // ------------------------------------------------------------------------------------------------------------
    // Agegamos un nuevo cliente
    public void agregarCliente(Clientes cliente) {
        // Insertamos los datos en la tabla 'clientes'
        String sql = "INSERT INTO clientes (nombre, telefono, email, direccion) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    } 
    
    // ------------------------------------------------------------------------------------------------------------
    // Agegamos un nuevo cliente
    public void modificarCliente(Clientes cliente) {
        // Modificamos los datos en la tabla 'clientes' segun el ID 
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, email = ?, direccion = ? WHERE id = ?"; 
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setInt(5, cliente.getId());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    } 

    // ------------------------------------------------------------------------------------------------------------
    // Busca clientes por una coincidencia parcial en el nombre.
    public List<Clientes> buscarPorNombre(String terminoBusqueda) {
        List<Clientes> clientesEncontrados = new ArrayList<>();

        // Usamos LIKE para búsqueda flexible e LOWER para insensibilidad a mayúsculas
        String sql = "SELECT * FROM clientes WHERE LOWER(nombre) LIKE LOWER(?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Prepara el término con comodines %
            pstmt.setString(1, "%" + terminoBusqueda + "%"); 

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    clientesEncontrados.add(crearClienteDesdeResultSet(rs));
                }
            }
        } 
        catch (SQLException e) { 
            System.err.println("Error al buscar por nombre: " + e.getMessage());
        }
        return clientesEncontrados;
    }    
    
    // ------------------------------------------------------------------------------------------------------------
    // Busca un cliente específico por su ID.
    public Clientes buscarPorId(int idBusqueda) {
        Clientes cliente = null;

        // Búsqueda exacta por ID
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idBusqueda); 

            try (ResultSet rs = pstmt.executeQuery()) {
                // Si encuentra un resultado (solo debería haber uno)
                if (rs.next()) {
                    cliente = crearClienteDesdeResultSet(rs);
                }
            }
        } 
        catch (SQLException e) { 
            System.err.println("Error al buscar por ID: " + e.getMessage());
        }
        return cliente; // Devuelve el objeto o null si no lo encuentra
    }
    
    private Clientes crearClienteDesdeResultSet(ResultSet rs) throws SQLException {
        Clientes cliente = new Clientes();
        cliente.setNombre(rs.getString("nombre"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setEmail(rs.getString("email"));
        cliente.setDireccion(rs.getString("direccion"));
        return cliente;
    }
}

