package SistemaDeVentas;

import java.util.*;
import javax.swing.*;
import java.awt.Font;

public class StockManagement {
    
    private ProductosDAO productosDAO = new ProductosDAO();
    private List<Stock> listaStock = new ArrayList<>();

    public void mostrarMenuStock() {
        int opcion;
        do {
            String menu = """
                === CONTROL DE STOCK Y REPORTES ===
                1. Ingresar nuevo movimiento de stock
                2. Mostrar listado de productos con stock
                3. Mostrar listado de precios
                0. Volver al menú principal
                """;

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1 -> agregarMovimientoStock();
                case 2 -> mostrarStockActual();
                case 3 -> mostrarListadoPrecios();
                case 0 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 0);
    }

    // -----------------------------------------------------------------------------------------
    // ALTA DE MOVIMIENTO DE STOCK
    private void agregarMovimientoStock() {
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del producto:"));
        int idProveedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del proveedor:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad (use número negativo para salida):"));
        
        Stock nuevoMovimiento = new Stock(listaStock.size() + 1, idProducto, idProveedor, cantidad);
        listaStock.add(nuevoMovimiento);
        JOptionPane.showMessageDialog(null, "Movimiento de stock registrado correctamente.");
    }

    // -----------------------------------------------------------------------------------------
    // LISTADO DE STOCK ACTUAL (sumando movimientos)
    private void mostrarStockActual() {
        if (listaStock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay movimientos de stock registrados.");
            return;
        }

        Map<Integer, Integer> stockActual = new HashMap<>();
        for (Stock s : listaStock) {
            stockActual.put(s.getIdProducto(), stockActual.getOrDefault(s.getIdProducto(), 0) + s.getCantidad());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTADO DE STOCK ACTUAL ===\n");
        sb.append(String.format("%-10s %-20s %-10s %-10s%n", "ID", "PRODUCTO", "STOCK", "PROVEEDOR"));
        sb.append("-------------------------------------------------------------\n");

        for (var entry : stockActual.entrySet()) {
            int idProd = entry.getKey();
            int cantidad = entry.getValue();

            Productos producto = productosDAO.buscarPorId(idProd);
            if (producto != null) {
                sb.append(String.format("%-10d %-20s %-10d %-10d%n",
                        producto.getId(),
                        producto.getNombre(),
                        cantidad,
                        producto.getIdProveedor()
                ));
            }
        }

        mostrarEnVentana("STOCK ACTUAL", sb.toString());
    }

    // -----------------------------------------------------------------------------------------
    // LISTADO DE PRECIOS
    private void mostrarListadoPrecios() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTADO DE PRECIOS ===\n");
        sb.append(String.format("%-10s %-20s %-15s%n", "ID", "PRODUCTO", "PRECIO ($)"));
        sb.append("---------------------------------------------\n");

        for (int i = 1; i <= 10; i++) { // Esto lo reemplazás por tu consulta real
            Productos p = productosDAO.buscarPorId(i);
            if (p != null) {
                sb.append(String.format("%-10d %-20s %-15.2f%n",
                        p.getId(),
                        p.getNombre(),
                        p.getPrecioVenta()
                ));
            }
        }

        mostrarEnVentana("LISTADO DE PRECIOS", sb.toString());
    }

    // -----------------------------------------------------------------------------------------
    // UTILIDAD: MUESTRA TEXTO EN UNA VENTANA DESPLAZABLE
    private void mostrarEnVentana(String titulo, String contenido) {
        JTextArea textArea = new JTextArea(contenido);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));

        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
