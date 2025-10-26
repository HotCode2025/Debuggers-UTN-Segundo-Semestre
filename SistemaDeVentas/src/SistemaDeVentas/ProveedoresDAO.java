/*
 * 
*/
package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {
    // ------------------------------------------------------------------------------------------------------------
    // Agegamos un nuevo proveedor
    public void agregarProveedor(Proveedores proveedor) {
        // Insertamos los datos en la tabla 'clientes'
        String sql = "INSERT INTO proveedores (nombre, telefono, correo, direccion) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getTelefono());
            pstmt.setString(3, proveedor.getCorreo());
            pstmt.setString(4, proveedor.getDireccion());
            pstmt.executeUpdate();
        } 
        catch (SQLException e) { 
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    } 
    
    // ------------------------------------------------------------------------------------------------------------
    // Agegamos un nuevo cliente
    public void modificarProveedor(Proveedores proveedor) {
        // Modificamos los datos en la tabla 'clientes' segun el ID 
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, correo = ?, direccion = ? WHERE id = ?"; 
        
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getTelefono());
            pstmt.setString(3, proveedor.getCorreo());
            pstmt.setString(4, proveedor.getDireccion());
            pstmt.setInt(5, proveedor.getId());
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
        String sql = "SELECT * FROM proveedores WHERE LOWER(nombre) LIKE LOWER(?)";

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
        String sql = "SELECT * FROM proveedores WHERE id = ?";

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
        cliente.setCorreo(rs.getString("correo"));
        cliente.setDireccion(rs.getString("direccion"));
        return cliente;
    }
}

