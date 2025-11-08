/*
 * CLASE: ClientesDAO
 * * PROPÓSITO:
 * Esta clase se encarga del acceso a la base de datos para la entidad 'Clientes'. (DAO - Data Access Object)
 * Su tarea es centralizar y gestionar todas las interacciones entre la aplicación y la tabla 'clientes' 
 * de la base de datos MySQL.
 * * FUNCIONALIDADES INCLUIDAS:
 * - agregarCliente: Métodos para insertar nuevos clientes.
 * - modificarCliente: Métodos para modificar datos de clientes existentes.
 * - listarTodos: Lista todos los clientes existentes.
 * - buscarPorNombre: Busca clientes por una coincidencia parcial en el nombre.
 * - buscarPorId: Busca un cliente específico por su ID.
 * * DEPENDENCIA:
 * Requiere la clase 'Clientes' (modelo) y la clase 'ConexionDB' (para obtener la conexión a la base de datos).
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Jairo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    // ------------------------------------------------------------------------------------------------------------
    /**
     * Inserta un nuevo cliente en la base de datos.
     * Utiliza los datos del objeto Clientes (excepto el ID, que es autogenerado).
     *
     * @param cliente El objeto Clientes con la información a insertar.
     */
    public void agregarCliente(Clientes cliente) {
        // Insertamos los datos en la tabla 'clientes'
        String sql = "INSERT INTO clientes (nombre, telefono, correo, direccion) VALUES (?, ?, ?, ?)";

        // try-with-resources asegura que la conexión y el statement se cierren
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getCorreo());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------------------------------------------------------
    /**
     * Modifica un cliente existente en la base de datos, identificado por su ID.
     *
     * @param cliente El objeto Clientes con el ID del cliente a modificar y los
     * nuevos datos.
     */
    public void modificarCliente(Clientes cliente) {
        // Modificamos los datos en la tabla 'clientes' segun el ID
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, correo = ?, direccion = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getCorreo());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setInt(5, cliente.getId()); // El ID se usa en el WHERE
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Corregido: El mensaje de error ahora dice "modificar"
            System.err.println("Error al modificar cliente: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------------------------------------------------------
    /**
     * Obtiene una lista completa de todos los clientes registrados en la base de
     * datos.
     *
     * @return Una lista (List<Clientes>) de objetos Clientes. Si no hay clientes,
     * devuelve una lista vacía.
     */
    public List<Clientes> listarTodos() {
        List<Clientes> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = ConexionDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            // Itera sobre cada fila del resultado
            while (rs.next()) {
                // Usa el método helper para crear el objeto
                Clientes cliente = crearClienteDesdeResultSet(rs);
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar todos los clientes: " + e.getMessage());
        }
        return listaClientes;
    }

    // ------------------------------------------------------------------------------------------------------------
    /**
     * Busca clientes por una coincidencia parcial en el nombre, ignorando
     * mayúsculas/minúsculas.
     *
     * @param terminoBusqueda El texto a buscar (parcial o completo) en el nombre.
     * @return Una lista (List<Clientes>) con los clientes que coinciden.
     */
    public List<Clientes> buscarPorNombre(String terminoBusqueda) {
        List<Clientes> clientesEncontrados = new ArrayList<>();

        // Usamos LIKE para búsqueda flexible e LOWER para insensibilidad a mayúsculas
        String sql = "SELECT * FROM clientes WHERE LOWER(nombre) LIKE LOWER(?)";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Prepara el término con comodines % para búsqueda parcial
            pstmt.setString(1, "%" + terminoBusqueda + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    clientesEncontrados.add(crearClienteDesdeResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar por nombre: " + e.getMessage());
        }
        return clientesEncontrados;
    }

    // ------------------------------------------------------------------------------------------------------------
    /**
     * Busca un cliente específico por su ID único.
     *
     * @param idBusqueda El ID (llave primaria) del cliente a buscar.
     * @return Un objeto Clientes si se encuentra, o null si no existe un cliente
     * con ese ID.
     */
    public Clientes buscarPorId(int idBusqueda) {
        Clientes cliente = null;

        // Búsqueda exacta por ID
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idBusqueda);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Si encuentra un resultado (solo debería haber uno)
                if (rs.next()) {
                    cliente = crearClienteDesdeResultSet(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar por ID: " + e.getMessage());
        }
        return cliente; // Devuelve el objeto o null si no lo encuentra
    }

    // ---------------------------------------------------------------------------------------------------------------
    /**
     * Elimina un cliente de la base de datos usando su ID.
     *
     * @param id El ID (llave primaria) del cliente a eliminar.
     * @return true si el cliente fue eliminado (filas afectadas > 0), false en
     * caso contrario.
     */
    public boolean eliminarCliente(int id) {
        boolean eliminado = false;
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            // executeUpdate retorna el numero de filas afectadas
            // si es mayor que 0, significa que si borró algo
            int filasAfectadas = pstmt.executeUpdate();
            eliminado = (filasAfectadas > 0);
        } catch (SQLException e) {
            // Podría fallar por restricciones (ej. si un cliente tiene ventas asociadas)
            System.err.println("Error al eliminar cliente con ID " + id + ": " + e.getMessage());
        }
        return eliminado;
    }

    // ---------------------------------------------------------------------------------------------------------------
    /**
     * Método de ayuda (helper) para convertir una fila de un ResultSet en un
     * objeto Clientes.
     * Este método centraliza la lógica de mapeo y evita la duplicación de código.
     *
     * @param rs El ResultSet posicionado en la fila actual (rs.next() ya debe
     * haber sido llamado).
     * @return Un objeto Clientes con los datos de la fila.
     * @throws SQLException Si ocurre un error al leer los datos del ResultSet (ej.
     * columna no existe).
     */
    private Clientes crearClienteDesdeResultSet(ResultSet rs) throws SQLException {
        // Crea un nuevo objeto Clientes usando el constructor vacío
        Clientes cliente = new Clientes();
        // Mapea cada columna del ResultSet a un atributo del objeto
        cliente.setId(rs.getInt("id"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setCorreo(rs.getString("correo"));
        cliente.setDireccion(rs.getString("direccion"));
        return cliente;
    }
}
