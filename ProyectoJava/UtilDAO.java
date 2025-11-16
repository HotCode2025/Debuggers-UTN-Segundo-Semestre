/*
 * Clase de utilidad que proporciona métodos comunes para la interacción con la base de datos (DB).
 * Se asume que la clase ConexionDB está definida en el mismo paquete.
*/
package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.*;

public class UtilDAO {
    // ------------------------------------------------------------------------------------------------------------
    /*
     * Cuenta el número total de filas en una tabla específica de la base de datos.
     * @param nombreTabla El nombre de la tabla de la cual se desea obtener el total de registros.
     * @return El número total de registros en la tabla. Retorna -1 si ocurre un error SQL.
    */
    public int totalRegistros(String nombreTabla) {
        // La consulta se construye de forma dinámica con el nombrte de la tabla que se pasa por parametro
        String sql = "SELECT COUNT(*) FROM " + nombreTabla;
        int totalRegistros = -1; // Valor predeterminado en caso de error o sin resultados
        
        // No necesitamos PreparedStatement para esta consulta simple, pero lo mantenemos para consistencia
        // y para asegurarnos de que el nombre de la tabla no contenga inyección SQL maliciosa
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { 
            
            // Si hay un resultado
            if (rs.next()) {
                // Recuperamos el resultado
                totalRegistros = rs.getInt(1); 
            }
        } 
        catch (SQLException e) { 
            // Mostramos el error junto con la tabla que falló
            System.err.println("Error al obtener el total de registros en la tabla " + nombreTabla + ": " + e.getMessage());
        }
        
        return totalRegistros;
    }
}
