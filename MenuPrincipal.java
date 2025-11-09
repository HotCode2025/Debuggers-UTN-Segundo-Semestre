/*
 * Clase principal que inicializa y gestiona el Menú Principal del Sistema de Ventas.
 * Utiliza JOptionPane para la interfaz de usuario.
*/

package SistemaDeVentas;

/*
 * @author Debuggers UTN - Alberto
*/

import javax.swing.JOptionPane;

/**
 * La clase MenuPrincipal es el punto de entrada de la aplicación.
 * Muestra un menú de opciones para navegar a los diferentes módulos de gestión del sistema.
 */
public class MenuPrincipal {
    public static void main(String[] args) {
        int opcion = -1; // Inicializa la opción a un valor que garantiza la entrada al bucle
        String input;
        
        do {
            // Mostramos el menú usando JOptionPane y pedimos que ingrese una opcion
            input = JOptionPane.showInputDialog(
                null, // null para centrar la ventana en la pantalla
                getMenuMessage(), // Contenido del menú formateado con HTML
                "MENÚ PRINCIPAL DEL SISTEMA", // Título de la ventana
                JOptionPane.PLAIN_MESSAGE // Tipo de mensaje (sin icono)
            );

            // Si el usuario cierra o cancela (input == null)
            if (input == null) {
                opcion = 0; // Establece la opción a 0 para salir del bucle
                continue; // Salta al final del bucle para la verificación de la condición
            }

            try {
                // Parseamos la entrada del usuario a un entero
                opcion = Integer.parseInt(input.trim()); 
                
                // Evaluamos la opción seleccionada y ejecutamos el módulo correspondiente
                switch (opcion) {
                    case 1: // Módulo Gestión de Ventas (Enzo)
                        VentasMenu.ejecutarVentas(); 
                    break;
                    case 2: // Módulo Gestión de Stock (Fede)
                        StockManagement gestorStock = new StockManagement();
                        gestorStock.mostrarMenuStock();
                    break;
                    case 3: // Módulo Gestión de Productos (Bruno) 
                        ProductoMenu.ejecutarMenu();
                    break;
                    case 4: // Módulo Gestión de Clientes (Jairo)
                        ClientesMenu.ejecutarMenu();
                    break;
                    case 5: // Módulo Gestión de Proveedores (Kevin)
                        ProveedoresMenu.ejecutarMenu();
                    break;
                    case 6: // Módulo Gestión de Empleados (Cele)
                        EmpleadosMenu.mostrarMenu();
                    break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
                    default:
                        // Opción inválida: no está entre 0 y 6
                        JOptionPane.showMessageDialog(null, 
                            "Opción no válida (" + opcion + "). Inténtalo de nuevo.", 
                            "Error de Entrada", 
                            JOptionPane.ERROR_MESSAGE);
                    break;
                }
            } catch (NumberFormatException e) {
                // Si el usuario ingresa texto en lugar de un número mostramos un mensaje de error
                JOptionPane.showMessageDialog(null, 
                    "Entrada inválida. Por favor, ingresa un número.", 
                    "Error de Formato", 
                    JOptionPane.ERROR_MESSAGE);
                opcion = -1; // Seteamos opción = -1 para forzar la repetición del bucle
            }
        } while (opcion != 0); // El bucle continúa hasta que el usuario selecciona la opción 0
        
        System.exit(0); // Termina la aplicación una vez que se sale del bucle
    }

    /**
     * Armamos el mensaje del menú formateado con etiquetas HTML para una mejor presentación
     * dentro de JOptionPane.
     * * @return El string del menú formateado con HTML.
     */
    private static String getMenuMessage() {
        return "<html><body>"
            + "<h2>MENÚ PRINCIPAL DEL SISTEMA</h2><hr>"
            + "<b>Elige un módulo:</b>"
            + "<ul>"
            + "<li><b>1.</b> Módulo Gestión de Ventas</li>"
            + "<li><b>2.</b> Módulo Gestión de Stock</li>"
            + "<li><b>3.</b> Módulo Gestión de Productos</li>"
            + "<li><b>4.</b> Módulo Gestión de Clientes</li>"
            + "<li><b>5.</b> Módulo Gestión de Proveedores</li>"
            + "<li><b>6.</b> Módulo Gestión de Empleados</li>"
            + "<li><b>0.</b> Salir del Sistema</li>"
            + "</ul>"
            + "<p>Ingresa el número de la opción deseada:</p>"
            + "</body></html>";
    }
}