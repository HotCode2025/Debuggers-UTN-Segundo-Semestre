/*
 * CLASE: ConexionDB
 * -----------------------------------------------------------------------------
 * PROPÓSITO:
 * Clase de utilidad (Helper) encargada de establecer y gestionar la conexión
 * a la base de datos MySQL para el sistema de ventas.
 * Esta clase centraliza los parámetros de conexión (URL, usuario y clave) 
 * y proporciona un método estático para obtener un objeto java.sql.Connection 
 * reutilizable en las distintas capas DAO (Data Access Object) de la aplicación.
 * -----------------------------------------------------------------------------
 */

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Definimos los datos de conexion a la base: URL (driver, direccion, puerto y nombre de la base), USUARIO y CLAVE
    private static final String URL = "jdbc:mysql://localhost:3306/sistemaventas_db";
    private static final String USUARIO = "root";
    private static final String CLAVE = "vertrigo";

    /**
     * Establece y devuelve una conexión activa a la base de datos MySQL.
     * @return Objeto Connection
     * @throws SQLException si falla la conexión
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
