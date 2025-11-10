package SistemaDeVentas;

/*
 * @author Debuggers UTN - Enzo
*/

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Importar para formatear fecha
import java.text.NumberFormat; // Lo usamos para mostrar los precios con punto de miles y como decimal
import java.util.Locale;

public class VentasMenu {
    // Inicializamos los DAOs necesarios
    private static final ClientesDAO clientesDAO = new ClientesDAO();
    private static final ProductosDAO productosDAO = new ProductosDAO();
    private static final StockDAO stockDAO = new StockDAO();
    private static final VentasDAO ventasDAO = new VentasDAO(); 
    
    // Forzamos el ID del empleado que realiza la venta
    // Esta parametro deberia venir del login
    private static final int ID_EMPLEADO_ACTUAL = 1; 

    // Inicia el proceso de una nueva venta.
    public static void ejecutarVentas() {
        
        List<VentasDetalle> itemsVenta = new ArrayList<>();
        
        int nroCliente = -1; // Inicia en -1 para validación
        int nroProducto;
        int cantidad, stock_actual;
        String respuesta = null;
        
        try {
            // Solicitamos y validamos el cliente
            do {
                String clienteIdStr = JOptionPane.showInputDialog(
                    null, 
                    "Ingrese Nro de Cliente (o '0' para 'Consumidor Final'):", 
                    "Seleccionar Cliente", 
                    JOptionPane.QUESTION_MESSAGE
                );

                if (clienteIdStr == null) return; // El usuario canceló

                try {
                    nroCliente = Integer.parseInt(clienteIdStr);
                } catch (NumberFormatException e) {
                    nroCliente = -1; // Asigna un valor inválido si no es un número
                }

                if (nroCliente == 0) break; // Es Consumidor Final

                if (nroCliente < 0 || clientesDAO.buscarPorId(nroCliente) == null) {
                    JOptionPane.showMessageDialog(null, 
                        "ID de cliente no válido o no existe. Intente de nuevo.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    nroCliente = -1; // Fuerza a repetir el bucle
                }
            } while (nroCliente == -1);
            
            // ----------------
            Clientes clienteSeleccionado = null;
            String infoCliente = "";
            
            if (nroCliente != 0) { // Si NO es Consumidor Final
                clienteSeleccionado = clientesDAO.buscarPorId(nroCliente);
                if (clienteSeleccionado != null) {
                    // Preparamos el String con el nombre y dirección para mostrar
                    infoCliente = "------ Cliente Seleccionado ------\n" +
                                  "Nombre: " + clienteSeleccionado.getNombre() + "\n" +
                                  "Dirección: " + clienteSeleccionado.getDireccion() + "\n" +
                                  "-------------------------------------";
                }
            } else {
                 infoCliente = "------ Cliente Seleccionado ------\n" +
                               "Tipo: Consumidor Final (ID 0)\n" +
                               "------------------------------------------";
            }

            // Buble para añadir productos
            do {
                // Validar Producto
                nroProducto = -1;
                Productos producto = null;
                String productoIdStr = null; 
                String cantidadStr = null;
                
                do {
                    productoIdStr = JOptionPane.showInputDialog(
                        null, 
                        infoCliente + "\nIngrese ID del Producto:",
                        "Añadir Productos", 
                        JOptionPane.QUESTION_MESSAGE
                    );
                    
                    if (productoIdStr == null) break; // El usuario canceló

                    try {
                        nroProducto = Integer.parseInt(productoIdStr);
                    } catch (NumberFormatException e) {
                        nroProducto = -1; // Asigna un valor inválido
                    }
                    
                    if (nroProducto <= 0) {
                        JOptionPane.showMessageDialog(null, "ID de producto no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }

                    producto = productosDAO.buscarPorId(nroProducto);
                    if (producto == null) {
                        JOptionPane.showMessageDialog(null, 
                            "Producto ID " + nroProducto + " no existe.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        nroProducto = -1; // Fuerza a repetir
                    }
                } while (nroProducto == -1);
                
                if (productoIdStr == null) break; // Salió del bucle de producto (canceló)

                // Validar Cantidad y Stock
                cantidad = -1;
                do {
                    stock_actual = stockDAO.obtenerStockPorProducto(nroProducto);
                    
                    // Define el formato local para usar punto como separador de miles y coma como decimal
                    // Usamos "es" para español, "AR" como codigo de país
                    NumberFormat nf = NumberFormat.getInstance(new Locale("es", "AR")); 
                    nf.setMinimumFractionDigits(2);
                    nf.setMaximumFractionDigits(2);
                    String precioFormateado = nf.format(producto.getPrecioVenta());

                    cantidadStr = JOptionPane.showInputDialog(
                        null, 
                        "Producto: " + producto.getNombre() + 
                        "\nStock Actual: " + stock_actual + 
                        "\nPrecio unitario: $ " + precioFormateado + 
                        "\nIngrese Cantidad:", 
                        "Especificar Cantidad", 
                        JOptionPane.QUESTION_MESSAGE
                    );

                    if (cantidadStr == null) break; // El usuario canceló
                    
                    try {
                        cantidad = Integer.parseInt(cantidadStr);
                    } catch (NumberFormatException e) {
                        cantidad = -1; // Asigna un valor inválido
                    }
                    
                    if (cantidad <= 0) {
                        JOptionPane.showMessageDialog(null, "Cantidad debe ser un número válido y mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (cantidad > stock_actual) {
                        JOptionPane.showMessageDialog(null, "Stock insuficiente. Máximo: " + stock_actual, "Error", JOptionPane.ERROR_MESSAGE);
                        cantidad = -1; // Fuerza a repetir
                    }
                } while (cantidad <= 0);
                
                if (cantidadStr == null) continue; // Volver al bucle de añadir producto

                // Añadimos al carrito / a la lista de productos en la venta
                VentasDetalle itemVenta = new VentasDetalle(
                    nroProducto, 
                    cantidad, 
                    producto.getPrecioVenta(), 
                    producto.getNombre()
                );
                
                itemsVenta.add(itemVenta);
                
                respuesta = JOptionPane.showInputDialog(
                    null, 
                    "Producto añadido.\n¿Desea añadir otro producto? (S/N)", 
                    "Carrito", 
                    JOptionPane.QUESTION_MESSAGE
                );
            } while (respuesta != null && respuesta.equalsIgnoreCase("S"));

            // Finalizar venta
            if (itemsVenta.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Venta cancelada (sin productos).", "Venta Cancelada", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Calcular Total
            double totalVenta = itemsVenta.stream().mapToDouble(VentasDetalle::getSubtotal).sum();

            // Empaquetar todo en un objeto Ventas
            Ventas ventaFinal = new Ventas(nroCliente, ID_EMPLEADO_ACTUAL, totalVenta, itemsVenta);
            
            // Guardamos la venta y su detalles
            if (ventasDAO.guardarVenta(ventaFinal)) {
                // Mostramos Ticket
                mostrarTicket(nroCliente, itemsVenta, ventaFinal.getFechaVenta(), totalVenta);
                
                JOptionPane.showMessageDialog(null, 
                    "Venta guardada exitosamente.", 
                    "Venta Completa", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                    "ERROR CRÍTICO: No se pudo guardar la venta.", 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Ocurrió un error inesperado: " + e.getMessage(), 
                "Error Fatal", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    } // Fin de ejecutarVentas()

    private static void mostrarTicket(int clienteId, List<VentasDetalle> items, LocalDateTime fecha, double totalVenta) {
        StringBuilder ticketContent = new StringBuilder("<html><body style='font-family: monospace; width: 300px;'>");
        
        Clientes cliente = clientesDAO.buscarPorId(clienteId);
        String nombreCliente;
        String direccionCliente;
        String telefonoCliente;

        if (clienteId == 0 || cliente == null) {
            nombreCliente = "CONSUMIDOR FINAL";
            direccionCliente = "N/A";
            telefonoCliente = "N/A";
        } else {
            nombreCliente = cliente.getNombre();
            direccionCliente = cliente.getDireccion();
            telefonoCliente = cliente.getTelefono();
        }

        // Configuración para usar punto como separador de miles y coma como decimal
        NumberFormat nf = NumberFormat.getInstance(new Locale("es", "AR")); 
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        
        ticketContent.append("<h3 style='text-align:center;'>Resumen de Venta</h3>");
        ticketContent.append("<p>Cliente ID: ").append(clienteId == 0 ? "Consumidor Final" : clienteId).append("</p>");
        ticketContent.append("<p>Nombre: ").append(nombreCliente).append("</p>");
        ticketContent.append("<p>Dirección: ").append(direccionCliente).append("</p>");
        ticketContent.append("<p>Teléfono: ").append(telefonoCliente).append("</p>");
        ticketContent.append("<p>Fecha: ").append(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("</p>");
        ticketContent.append("<p>------------------------------------------------------------</p>");
        
        // Líneas de detalle
        ticketContent.append("<table border='0' width='100%'>");
        ticketContent.append("<tr><th>Cant.</th><th>Producto</th><th>P. Unit.</th><th>Subtotal</th></tr>");

        for (VentasDetalle item : items) {
            String nombreProd = item.getNombreProducto().length() > 20 
                                ? item.getNombreProducto().substring(0, 17) + "..." 
                                : item.getNombreProducto();

            String precioUnitarioFormateado = nf.format(item.getPrecioUnitario());
            String subtotalFormateado = nf.format(item.getSubtotal());

            ticketContent.append(String.format(
                "<tr><td align='center'>%d</td><td>%s</td><td align='right'>$%s</td><td align='right'>$%s</td></tr>",
                item.getCantidad(),
                nombreProd,
                precioUnitarioFormateado, // Precio formateado
                subtotalFormateado      // Subtotal formateado
            ));
        }

        ticketContent.append("</table>");
        ticketContent.append("<p>------------------------------------------------------------</p>");
        
        String totalVentaFormateado = nf.format(totalVenta);
        ticketContent.append(String.format("<h3 style='text-align:right;'>TOTAL: $%s</h3>", totalVentaFormateado));
        
        ticketContent.append("</body></html>");

        // Mostramos el ticket
        JOptionPane.showMessageDialog(null, 
            ticketContent.toString(), 
            "Resumen de Venta", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}