/**
 * Clase de utilidad para gestionar el menú de productos mediante interfaces de usuario Swing (JOptionPane).
 * Esta clase interactúa con la capa de persistencia (ProductosDAO) para realizar operaciones CRUD
 * sobre la entidad Productos.
*/
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Bruno
*/

import javax.swing.*;
import java.awt.*;
import java.util.List;
    
public class ProductoMenu {

    /** Instancia estática del Data Access Object (DAO) para la gestión de productos en la base de datos. */
    private static final ProductosDAO dao = new ProductosDAO();

    /**
     * Ejecuta el bucle principal del menú de gestión de productos.
     * Muestra las opciones disponibles al usuario mediante JOptionPane y delega
     * la acción seleccionada a los métodos correspondientes.
     */
    public static void ejecutarMenu() {

        // Se utiliza código HTML para un mejor formato visual del menú dentro del JOptionPane.
        String menuMensaje = "<html><body>"
                + "<h2>MENÚ DE PRODUCTOS</h2><hr>"
                + "<b>Seleccione una opción:</b><br>"
                + "<ul>"
                + "<li><b>1.</b> Agregar Producto</li>"
                + "<li><b>2.</b> Modifcicar Producto</li>"
                + "<li><b>3.</b> Buscar Producto por ID</li>"
                + "<li><b>4.</b> Mostrar todos los Productos</li>"
                + "<li><b>0.</b> Volver al Menú Principal</li>"
                + "</ul>"
                + "<p>Ingresa el número de la opción deseada:</p>"
                + "</body></html>";

        String input;
        int opcion = -1;

        do {
            // 1. Mostrar el menú y leer la entrada del usuario como texto.
            input = JOptionPane.showInputDialog(
                null,
                menuMensaje, // Mensaje con todas las opciones
                "MÓDULO GESTIÓN DE PRODUCTOS", // Título de la ventana
                JOptionPane.PLAIN_MESSAGE
            );

            // 2. Manejar la acción del usuario (Cancelar o Cerrar la ventana).
            if (input == null) {
                opcion = 0; // Interpreta Cancelar/Cerrar como Salir/Volver.
                continue;
            }
            
            try {
                // Intenta parsear la entrada a un entero.
                opcion = Integer.parseInt(input.trim());

                // Lógica de selección de opción (Switch Case).
                switch (opcion) {
                    case 1 -> agregarProducto();
                    case 2 -> modificarProducto();
                    case 3 -> buscarProductoPorId();
                    case 4 -> mostrarTodosProductos();
                    case 0 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal.");
                    default -> JOptionPane.showMessageDialog(null, "Opción inválida. Inténtalo de nuevo.", "Error de Opción", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                // Manejo de error si el usuario no ingresa un número válido.
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                opcion = -1; // Mantener el bucle activo.
            }
        } while (opcion != 0);
    }
    
    /**
     * Solicita al usuario los datos necesarios para crear y agregar un nuevo Producto
     * a la base de datos mediante ProductosDAO.
     * Gestiona posibles errores de formato o excepciones al guardar.
     */
    private static void agregarProducto() {
        try {
            // Captura de datos del producto, asumiendo validación de null o vacíos en el flujo.
            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio de venta:"));
            int idProveedor = Integer.parseInt(JOptionPane.showInputDialog("ID del proveedor:"));

            // Creación, asignación de valores y persistencia del objeto Producto.
            Productos producto = new Productos();
            producto.setNombre(nombre);
            producto.setPrecioVenta(precio);
            producto.setIdProveedor(idProveedor);

            dao.agregarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        } catch (Exception e) {
            // Manejo de excepciones, incluyendo NumberFormatException si el parsing falla.
            JOptionPane.showMessageDialog(null, "Error al agregar producto: " + e.getMessage());
        }
    }

    /**
     * Solicita el ID del producto a modificar, lo recupera, pide los nuevos datos
     * al usuario y actualiza el registro en la base de datos.
     *
     * Gestiona los casos de producto no encontrado y errores de modificación/formato.
     */
    private static void modificarProducto() {
        try {
            // 1. Obtener ID y buscar el producto actual.
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del producto a modificar:"));
            Productos producto = dao.buscarPorId(id);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                return; // Sale del método.
            }

            // 2. Solicitar nuevos datos, mostrando los valores actuales para facilitar la edición.
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", producto.getNombre());
            double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", producto.getPrecioVenta()));
            int nuevoProveedor = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID proveedor:", producto.getIdProveedor()));

            // 3. Actualizar el objeto y persistir el cambio.
            producto.setNombre(nuevoNombre);
            producto.setPrecioVenta(nuevoPrecio);
            producto.setIdProveedor(nuevoProveedor);

            if (dao.modificarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el producto.");
            }
        } catch (Exception e) {
            // Manejo general de excepciones.
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    /**
     * Solicita un ID de producto al usuario, busca el producto en la base de datos
     * y muestra su información detallada en un cuadro de diálogo.
     */
    private static void buscarProductoPorId() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
            Productos producto = dao.buscarPorId(id); // Llamada al método DAO.

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            } else {
                // Formatea la información del producto.
                String mensaje = "ID: " + producto.getId() + "\n"
               + "Nombre: " + producto.getNombre() + "\n"
               + "Precio: " + producto.getPrecioVenta() + "\n"
               + "ID Proveedor: " + producto.getIdProveedor();

                JOptionPane.showMessageDialog(null, mensaje, "Producto encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            // Manejo de errores de formato o de base de datos.
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    /**
     * Recupera una lista de todos los productos de la base de datos y los muestra
     * al usuario en un formato tabular dentro de una ventana de diálogo con scroll,
     * utilizando una fuente monoespaciada para la correcta alineación.
     */
    private static void mostrarTodosProductos() {
        List<Productos> productos = dao.listarTodos(); 
        StringBuilder mensaje = new StringBuilder();

        if (productos.isEmpty()) {
            mensaje.append("No hay productos registrados.");
        } else {
            // Construcción del encabezado de la tabla.
            mensaje.append("====================================================================================\n");
            mensaje.append(String.format("| %-4s | %-30s | %-10s | %-12s |%n", "ID", "NOMBRE", "PRECIO", "ID PROVEEDOR"));
            mensaje.append("------------------------------------------------------------------------------------\n");

            // Iteración y formato de cada producto.
            for (Productos p : productos) {
                mensaje.append(String.format("| %-4d | %-30s | %-10.2f | %-12d |\n",
                    p.getId(),
                    truncarCadena(p.getNombre(), 30), // Llama a la función de utilidad para el formato.
                    p.getPrecioVenta(),
                    p.getIdProveedor()
                ));
            }

            mensaje.append("------------------------------------------------------------------------------------\n");
            mensaje.append("Total de productos: ").append(productos.size()).append("\n");
        }

        // Configuración de la interfaz Swing para mostrar la tabla.
        JTextArea textArea = new JTextArea(mensaje.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11)); // Esencial para la alineación tabular.
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "LISTADO DE PRODUCTOS", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Función de utilidad que trunca una cadena si su longitud excede un máximo especificado,
     * añadiendo puntos suspensivos ("...") al final.
     *
     * @param texto La cadena original a truncar.
     * @param max La longitud máxima permitida para la cadena.
     * @return La cadena truncada o la cadena original si es más corta que el máximo.
     */
    private static String truncarCadena(String texto, int max) {
        return texto.length() > max ? texto.substring(0, max - 3) + "..." : texto;
    }
}