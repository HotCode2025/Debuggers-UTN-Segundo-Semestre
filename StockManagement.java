package SistemaDeVentas;

import java.awt.Font;
import java.util.List;
import javax.swing.*;

public class StockManagement {

    private final ProductosDAO productosDAO = new ProductosDAO();
    private final StockDAO stockDAO = new StockDAO();

    public void mostrarMenuStock() {
        int opcion;
        do {
            String menu = """
                === CONTROL DE STOCK ===
                1. Registrar movimiento de stock
                2. Mostrar stock actual de un producto
                3. Mostrar listado general de stock
                0. Volver al menú principal
                """;

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1 -> registrarMovimiento();
                case 2 -> mostrarStockDeProducto();
                case 3 -> mostrarListadoCompleto();
                case 0 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 0);
    }

    // -----------------------------------------------------------------------------------------
    private void registrarMovimiento() {
        try {
            int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del producto:"));
            Productos producto = productosDAO.buscarPorId(idProducto);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                return;
            }

            int idProveedor = producto.getIdProveedor();
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad (+ para entrada, - para salida):"));

            Stock nuevoMovimiento = new Stock(0, idProducto, idProveedor, cantidad);
            stockDAO.agregarMovimiento(nuevoMovimiento);

            JOptionPane.showMessageDialog(null, "Movimiento de stock registrado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------
    private void mostrarStockDeProducto() {
        try {
            int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del producto:"));
            Productos producto = productosDAO.buscarPorId(idProducto);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                return;
            }

            int stockActual = stockDAO.obtenerStockPorProducto(idProducto);
            String mensaje = String.format("""
                === STOCK DE PRODUCTO ===
                Producto: %s
                ID: %d
                Stock actual: %d unidades
                """, producto.getNombre(), producto.getId(), stockActual);

            JOptionPane.showMessageDialog(null, mensaje);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------
    private void mostrarListadoCompleto() {
        try {
            List<Productos> productos = productosDAO.listarTodos(); // asumimos que ya existe este método
            if (productos == null || productos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay productos registrados.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("=== LISTADO GENERAL DE STOCK ===\n\n");
            sb.append(String.format("%-5s %-25s %-10s %-10s%n", "ID", "PRODUCTO", "PROVEEDOR", "STOCK"));
            sb.append("------------------------------------------------------\n");

            for (Productos p : productos) {
                int stock = stockDAO.obtenerStockPorProducto(p.getId());
                sb.append(String.format("%-5d %-25s %-10d %-10d%n",
                        p.getId(), p.getNombre(), p.getIdProveedor(), stock));
            }

            mostrarEnVentana("Listado de Stock", sb.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------
    private void mostrarEnVentana(String titulo, String contenido) {
        JTextArea textArea = new JTextArea(contenido);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));

        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
