/*
 * Clase que maneja el menú de gestión de productos del sistema.
 * Permite agregar, modificar, buscar y listar productos.
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Bruno
 */

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductoMenu {

    // Instancia del DAO (Data Access Object) que maneja las operaciones con la base de datos
    private static final ProductosDAO dao = new ProductosDAO();

    // Método principal que muestra el menú y controla la navegación del usuario
    public static void ejecutarMenu() {

        // Mensaje HTML que muestra el menú con formato visual
        String menuMensaje = "<html><body>"
                + "<h2>MENÚ DE PRODUCTOS</h2><hr>"
                + "<b>Seleccione una opción:</b><br>"
                + "<ul>"
                + "<li><b>1.</b> Agregar Producto</li>"
                + "<li><b>2.</b> Modificar Producto</li>"
                + "<li><b>3.</b> Buscar Producto por ID</li>"
                + "<li><b>4.</b> Mostrar todos los Productos</li>"
                + "<li><b>0.</b> Volver al Menú Principal</li>"
                + "</ul>"
                + "<p>Ingresa el número de la opción deseada:</p>"
                + "</body></html>";

        String input; // Almacena la entrada del usuario
        int opcion = -1; // Controla la opción seleccionada

        // Bucle principal del menú (se repite hasta que el usuario elige 0)
        do {
            // Mostrar el menú en un cuadro de diálogo
            input = JOptionPane.showInputDialog(
                null,
                menuMensaje, // Contenido del menú
                "MÓDULO GESTIÓN DE PRODUCTOS", // Título de la ventana
                JOptionPane.PLAIN_MESSAGE
            );

            // Si el usuario presiona "Cancelar" o cierra la ventana, volver al menú principal
            if (input == null) {
                opcion = 0;
                continue;
            }

            try {
                // Convertir la entrada del usuario a número entero
                opcion = Integer.parseInt(input.trim());

                // Seleccionar la acción según la opción elegida
                switch (opcion) {
                    case 1 -> agregarProducto();         // Agregar nuevo producto
                    case 2 -> modificarProducto();       // Modificar producto existente
                    case 3 -> buscarProductoPorId();     // Buscar producto por ID
                    case 4 -> mostrarTodosProductos();   // Mostrar listado de productos
                    case 0 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal.");
                    default -> JOptionPane.showMessageDialog(
                        null,
                        "Opción inválida. Inténtalo de nuevo.",
                        "Error de Opción",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (NumberFormatException e) {
                // Si el usuario escribe algo que no es número
                JOptionPane.showMessageDialog(
                    null,
                    "Entrada inválida. Por favor, ingrese un número.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE
                );
                opcion = -1; // Mantener el bucle
            }
        } while (opcion != 0); // Salir solo cuando la opción es 0
    }

    // Método para agregar un nuevo producto
    private static void agregarProducto() {
        try {
            // Pedir datos al usuario
            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio de venta:"));
            int idProveedor = Integer.parseInt(JOptionPane.showInputDialog("ID del proveedor:"));

            // Crear objeto producto y asignar los valores
            Productos producto = new Productos();
            producto.setNombre(nombre);
            producto.setPrecioVenta(precio);
            producto.setIdProveedor(idProveedor);

            // Llamar al DAO para guardar el producto en la base de datos
            dao.agregarProducto(producto);

            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar producto: " + e.getMessage());
        }
    }

    // Método para modificar un producto existente
    private static void modificarProducto() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del producto a modificar:"));

            // Buscar el producto en la base de datos
            Productos producto = dao.buscarPorId(id);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                return;
            }

            // Solicitar nuevos valores al usuario, mostrando los actuales como sugerencia
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", producto.getNombre());
            double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", producto.getPrecioVenta()));
            int nuevoProveedor = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID proveedor:", producto.getIdProveedor()));

            // Actualizar los campos del producto
            producto.setNombre(nuevoNombre);
            producto.setPrecioVenta(nuevoPrecio);
            producto.setIdProveedor(nuevoProveedor);

            // Guardar los cambios usando el DAO
            if (dao.modificarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el producto.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Método para buscar un producto por su ID
    private static void buscarProductoPorId() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
            Productos producto = dao.buscarPorId(id);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            } else {
                // Mostrar los datos del producto encontrado
                String mensaje = "ID: " + producto.getId() + "\n"
                               + "Nombre: " + producto.getNombre() + "\n"
                               + "Precio: " + producto.getPrecioVenta() + "\n"
                               + "ID Proveedor: " + producto.getIdProveedor();

                JOptionPane.showMessageDialog(null, mensaje, "Producto encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Método para mostrar todos los productos en formato de tabla
    private static void mostrarTodosProductos() {
        // Obtener la lista de productos desde el DAO
        List<Productos> productos = dao.listarTodos();
        StringBuilder mensaje = new StringBuilder();

        // Si no hay productos registrados
        if (productos.isEmpty()) {
            mensaje.append("No hay productos registrados.");
        } else {
            // Crear una tabla con formato monoespaciado
            mensaje.append("====================================================================================\n");
            mensaje.append(String.format("| %-4s | %-30s | %-10s | %-12s |%n", "ID", "NOMBRE", "PRECIO", "ID PROVEEDOR"));
            mensaje.append("------------------------------------------------------------------------------------\n");

            // Recorrer la lista y agregar cada producto a la tabla
            for (Productos p : productos) {
                mensaje.append(String.format("| %-4d | %-30s | %-10.2f | %-12d |\n",
                    p.getId(),
                    truncarCadena(p.getNombre(), 30),
                    p.getPrecioVenta(),
                    p.getIdProveedor()
                ));
            }

            mensaje.append("------------------------------------------------------------------------------------\n");
            mensaje.append("Total de productos: ").append(productos.size()).append("\n");
        }

        // Mostrar el resultado en un JTextArea dentro de un JScrollPane
        JTextArea textArea = new JTextArea(mensaje.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11)); // Fuente monoespaciada para alineación
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "LISTADO DE PRODUCTOS", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método auxiliar para truncar nombres largos (para que encajen en la tabla)
    private static String truncarCadena(String texto, int max) {
        return texto.length() > max ? texto.substring(0, max - 3) + "..." : texto;
    }
}