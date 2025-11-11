/**
 * Clase principal que sirve como punto de entrada (runner) para el módulo de gestión de Proveedores.
 * Su única función es inicializar la capa de lógica y presentación (ProveedoresData)
 * y comenzar la ejecución del menú de proveedores.
 *
 * @author Debuggers UTN - Kevin
 */
package SistemaDeVentas;

public class ProveedoresMenu {
    
    /**
     * Inicia la ejecución del menú de gestión de proveedores.
     * Crea una instancia de ProveedoresData y llama a su método 'ejecutarMenu'
     * para iniciar la interacción con el usuario.
     */
    public static void ejecutarMenu() {
        ProveedoresData data = new ProveedoresData();
        data.ejecutarMenu(); 
    }
}