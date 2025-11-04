package SistemaDeVentas;





import java.awt.Font;          // Importamos para usar Font para poder formatear el texto
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane; // Importamos para usar el scroll
import javax.swing.JTextArea; // Importamos para usar el área de texto
    
public class ProductoMenu {

    private static final ProductosDAO dao = new ProductosDAO();

    public static void ejecutarMenu() {
        String[] opciones = {
            "1. Agregar producto",
            "2. Modificar producto",
            "3. Buscar producto por ID",
            "4. Mostrar todos los productos",
            "0. Volver al menú principal"
        };

        int opcion;
        do {
            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción:",
                "MENÚ DE PRODUCTOS",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion == null || seleccion.startsWith("0")) break;

            opcion = Integer.parseInt(seleccion.substring(0, 1));

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> modificarProducto();
                case 3 -> buscarProductoPorId();
                case 4 -> mostrarTodosProductos();
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (true);
    }

    private static void agregarProducto() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio de venta:"));
            int idProveedor = Integer.parseInt(JOptionPane.showInputDialog("ID del proveedor:"));

            Productos producto = new Productos();
            producto.setNombre(nombre);
            producto.setPrecioVenta(precio);
            producto.setIdProveedor(idProveedor);

            dao.agregarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar producto: " + e.getMessage());
        }
    }

    private static void modificarProducto() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del producto a modificar:"));
            Productos producto = dao.buscarPorId(id);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                return;
            }

            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", producto.getNombre());
            double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", producto.getPrecioVenta()));
            int nuevoProveedor = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID proveedor:", producto.getIdProveedor()));

            producto.setNombre(nuevoNombre);
            producto.setPrecioVenta(nuevoPrecio);
            producto.setIdProveedor(nuevoProveedor);

            if (dao.modificarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el producto.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void buscarProductoPorId() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
            Productos producto = dao.buscarPorId(id);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            } else {
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

    private static void mostrarTodosProductos() {
        List<Productos> productos = dao.listarTodos(); // Este método debe existir en ProductosDAO
        StringBuilder mensaje = new StringBuilder();

        if (productos.isEmpty()) {
            mensaje.append("No hay productos registrados.");
        } else {
            mensaje.append("====================================================================================\n");
            mensaje.append(String.format("| %-4s | %-30s | %-10s | %-12s |%n", "ID", "NOMBRE", "PRECIO", "ID PROVEEDOR"));
            mensaje.append("------------------------------------------------------------------------------------\n");

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

        JTextArea textArea = new JTextArea(mensaje.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "LISTADO DE PRODUCTOS", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String truncarCadena(String texto, int max) {
        return texto.length() > max ? texto.substring(0, max - 3) + "..." : texto;
    }
}
