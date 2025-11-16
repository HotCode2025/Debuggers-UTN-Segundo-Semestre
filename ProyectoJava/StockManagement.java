/*
 * 
*/

package SistemaDeVentas;

/*
 * @author Debuggers UTN - Fede
*/

import java.util.*;
import javax.swing.*;
import java.awt.Font;

public class StockManagement {
    
    private ProductosDAO productosDAO = new ProductosDAO();
    private StockDAO stockDAO = new StockDAO();

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
        try {
            int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del producto:"));
            int idProveedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del proveedor:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad (use número negativo para salida):"));

            Stock nuevoMovimiento = new Stock(0, idProducto, idProveedor, cantidad);
            stockDAO.agregarMovimiento(nuevoMovimiento);
        
            JOptionPane.showMessageDialog(null, "Movimiento de stock registrado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido para ID o cantidad.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar movimiento: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------
    // LISTADO DE STOCK ACTUAL (sumando movimientos)
    private void mostrarStockActual() {
        // Obtiene todos los movimientos de la base de datos
        List<Stock> movimientos = stockDAO.listarMovimientos();

    Map<Integer, Integer> stockActual = new HashMap<>();
        for (Stock s : movimientos) {
            stockActual.put(s.getIdProducto(), stockActual.getOrDefault(s.getIdProducto(), 0) + s.getCantidad());
        }

        // 3. Generar la salida (mismo código)
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTADO DE STOCK ACTUAL ===\n");
        sb.append(String.format("%-4s %-40s %-10s %-10s%n", "ID", "PRODUCTO", "STOCK", "PROVEEDOR"));
        sb.append("-------------------------------------------------------------\n");

        for (var entry : stockActual.entrySet()) {
            int idProd = entry.getKey();
            int cantidad = entry.getValue();

            Productos producto = productosDAO.buscarPorId(idProd);
            if (producto != null) {
                sb.append(String.format("%-4d %-40s %-10d %-10d%n",
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
        sb.append(String.format("%-4s %-40s %-15s%n", "ID", "PRODUCTO", "PRECIO ($)"));
        sb.append("--------------------------------------------------------------\n");

        for (int i = 1; i <= 10; i++) { 
            Productos p = productosDAO.buscarPorId(i);
            if (p != null) {
                sb.append(String.format("%-4d %-40s %-15.2f%n",
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
