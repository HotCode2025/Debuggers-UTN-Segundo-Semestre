/*
 * 
*/
package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.sql.*;

public class UtilDAO {
    // ------------------------------------------------------------------------------------------------------------
    public int totalRegistros(String nombreTabla) {
        // La consulta se construye de forma dinámica con el nombrte de la tabla que se pasa por parametro
        String sql = "SELECT COUNT(*) FROM " + nombreTabla;
        int totalRegistros = -1; // Valor predeterminado en caso de error o sin resultados
        
        // No necesitamos PreparedStatement para esta consulta simple, pero lo mantenemos para consistencia
        // y para asegurarnos de que el nombre de la tabla no contenga inyección SQL maliciosa (aunque aquí el riesgo es bajo)
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { 
            
            // Si hay un resultado
            if (rs.next()) {
                // Recuperamos el resultado del conteo
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
