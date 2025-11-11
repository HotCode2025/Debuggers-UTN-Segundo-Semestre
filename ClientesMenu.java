/*
 * CLASE: ClientesMenu
 *
 * PROPÓSITO:
 * Proporciona una interfaz gráfica simple (usando JOptionPane) para interactuar 
 * con la gestión de clientes.
 * Esta clase contiene el bucle principal del menú para el módulo de Clientes,
 * y se encarga de recibir la entrada del usuario, validar las opciones,
 * y coordinar las llamadas al Data Access Object (DAO) 'ClientesDAO' para
 * realizar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 */
package SistemaDeVentas;

/*
 * @author Debuggers UTN - Jairo
*/

import java.util.List;
// Importamos los componentes de Swing (JOptionPane) y AWT (para listas)
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Font;

public class ClientesMenu {

    // Instancia del DAO (esto no cambia)
    private static final ClientesDAO dao = new ClientesDAO();

    /**
     * Inicia el bucle principal del menú gráfico de Clientes.
     * Muestra las opciones usando JOptionPane, solicita la entrada y
     * ejecuta la operación seleccionada hasta que el usuario elija "Volver".
     */
    public static void ejecutarMenu() {
        int opcion = -1;
        String input;

        do {
            // Usamos showOptionDialog para mostrar el menú
            input = JOptionPane.showInputDialog(
                null, // null para centrar en la pantalla
                getMenuMessage(), // Contenido del menú
                "MÓDULO GESTIÓN DE CLIENTES", // Título de la ventana
                JOptionPane.PLAIN_MESSAGE // Tipo de mensaje
            );

            // Si el usuario presiona "Cancelar" o cierra el diálogo, input es null.
            if (input == null) {
                opcion = 0; // Tratar como "Volver"
            }
            else {
                try {
                    // Convertir la entrada de texto a número
                    opcion = Integer.parseInt(input.trim()); 
                    // Switch para manejar la opción del usuario
                    switch (opcion) {
                        case 1: // Agregar
                            crearCliente();
                        break;
                        case 2: // Listar
                            mostrarTodosClientes();
                        break;
                        case 3: // Buscar por ID
                            buscarPorId();
                        break;
                        case 4: // Buscar por Nombre
                            buscarPorNombre();
                        break;
                        case 5: // Modificar
                            modificarCliente();
                        break;
                        case 6: // Eliminar
                            eliminarCliente();
                        break;
                        case 0: // Volver
                            JOptionPane.showMessageDialog(null, "Volviendo al Menú Principal.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        break;
                        default:
                            JOptionPane.showMessageDialog(null, 
                                "Opción no válida (" + opcion + "). Inténtalo de nuevo.", 
                                "Error de Entrada", 
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Captura si el usuario ingresa texto no numérico
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                    opcion = -1; // Mantener el bucle
                }
            }
        } while (opcion != 0); // El bucle termina cuando se elige "Volver"
    }

        /**
     * Genera el mensaje del menú formateado con HTML para JOptionPane.
     *
     * @return Un String con el contenido del menú en HTML.
     */
    private static String getMenuMessage() {
        return "<html><body>"
            + "<h2>MENÚ DE CLIENTES</h2><hr>"
            + "<b>Elige un módulo:</b>"
            + "<ul>"
            + "<li><b>1.</b> Agregar Nuevo Cliente</li>"
            + "<li><b>2.</b> Ver Lista de Clientes</li>"
            + "<li><b>3.</b> Buscar Cliente por ID</li>"
            + "<li><b>4.</b> Buscar Cliente por Nombre</li>"
            + "<li><b>5.</b> Modificar Cliente</li>"
            + "<li><b>6.</b> Eliminar Cliente</li>"
            + "<li><b>0.</b> Volver al Menú Principal</li>"
            + "</ul>"
            + "<p>Ingresa el número de la opción deseada:</p>"
            + "</body></html>";
    }
    
        // -----------------------------------------------------------------------------------------------------------------
    /**
     * Muestra una serie de diálogos para recopilar los datos de un nuevo cliente
     * y llama al DAO para guardarlo.
     */
    private static void crearCliente() {
        // Pedimos los datos uno por uno
        String nombre = JOptionPane.showInputDialog(null, "Nombre:", "Agregar Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
        if (nombre == null) return; // El usuario presionó Cancelar

        String telefono = JOptionPane.showInputDialog(null, "Teléfono:", "Agregar Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
        if (telefono == null) return;

        String email = JOptionPane.showInputDialog(null, "Email:", "Agregar Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
        if (email == null) return;

        String direccion = JOptionPane.showInputDialog(null, "Dirección:", "Agregar Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
        if (direccion == null) return;

        try {
            Clientes nuevoCliente = new Clientes(0, nombre, telefono, email, direccion);
            dao.agregarCliente(nuevoCliente);
            // Mostramos un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Cliente: " + nombre + " agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            // Mostramos un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Pide el ID de un cliente, busca sus datos actuales, y luego pide los
     * nuevos datos (pre-rellenando los campos) para actualizarlos.
     */
    private static void modificarCliente() {
        String idStr = JOptionPane.showInputDialog(null, "Ingresa el ID del cliente a modificar:", "Modificar Cliente", JOptionPane.PLAIN_MESSAGE);
        if (idStr == null) return; // Canceló

        try {
            int id = Integer.parseInt(idStr);
            
            // Verificamos si el cliente existe antes de pedir más datos
            Clientes clienteExistente = dao.buscarPorId(id);
            if (clienteExistente == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Pedimos los nuevos datos, usando los datos existentes como valor por defecto
            // La sobrecarga de showInputDialog con 7 argumentos permite esto.
            String nombre = (String) JOptionPane.showInputDialog(null, "Nuevo Nombre:", "Modificar Cliente", JOptionPane.PLAIN_MESSAGE, null, null, clienteExistente.getNombre());
            if (nombre == null) return;

            String telefono = (String) JOptionPane.showInputDialog(null, "Nuevo Teléfono:", "Modificar Cliente", JOptionPane.PLAIN_MESSAGE, null, null, clienteExistente.getTelefono());
            if (telefono == null) return;

            String email = (String) JOptionPane.showInputDialog(null, "Nuevo Email:", "Modificar Cliente", JOptionPane.PLAIN_MESSAGE, null, null, clienteExistente.getCorreo());
            if (email == null) return;

            String direccion = (String) JOptionPane.showInputDialog(null, "Nueva Dirección:", "Modificar Cliente", JOptionPane.PLAIN_MESSAGE, null, null, clienteExistente.getDireccion());
            if (direccion == null) return;

            // Creamos el objeto actualizado y lo enviamos al DAO
            Clientes clienteActualizado = new Clientes(id, nombre, telefono, email, direccion);
            dao.modificarCliente(clienteActualizado);
            JOptionPane.showMessageDialog(null, "Cliente: " + nombre + " se modificó correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El ID debe ser un número entero.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Obtiene la lista de todos los clientes y la muestra en un JTextArea con
     * fuente monoespaciada (para alinear la tabla) dentro de un JScrollPane.
     */
    private static void mostrarTodosClientes() {
        List<Clientes> todosLosClientes = dao.listarTodos();

        if (todosLosClientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados en el sistema.", "Listado de Clientes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Usamos StringBuilder para construir eficientemente la tabla
            StringBuilder sb = new StringBuilder(400);
            sb.append(String.format("| %-4s | %-30s | %-15s | %-20s | %-30s |%n", "ID", "NOMBRE", "TELÉFONO", "CORREO", "DIRECCIÓN"));
            sb.append("-------------------------------------------------------------------------------------------------------------------\n");

            for (Clientes cliente : todosLosClientes) {
                sb.append(String.format("| %-4d | %-30s | %-15s | %-20s | %-30s |%n",
                        cliente.getId(),
                        cortarCadena(cliente.getNombre(), 30),
                        cliente.getTelefono(),
                        cortarCadena(cliente.getCorreo(), 20),
                        cortarCadena(cliente.getDireccion(), 30)
                ));
            }
            sb.append("-------------------------------------------------------------------------------------------------------------------\n");
            sb.append("Total de registros: ").append(todosLosClientes.size());

            // Creamos el JTextArea
            JTextArea textArea = new JTextArea(sb.toString());
            // Usamos una fuente monoespaciada para que la tabla se alinee
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            textArea.setEditable(false);

            // Creamos el JScrollPane
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(800, 400)); // Ajusta el tamaño

            // Mostramos el scroll pane en el diálogo
            JOptionPane.showMessageDialog(null, scrollPane, "Listado de Todos los Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Pide un ID, busca al cliente y muestra su información (usando
     * toString())
     * o un mensaje de advertencia si no se encuentra.
     */
    private static void buscarPorId() {
        String idStr = JOptionPane.showInputDialog(null, "Ingresa el ID (número entero):", "Buscar por ID", JOptionPane.PLAIN_MESSAGE);
        if (idStr == null) return; // Canceló

        try {
            int id = Integer.parseInt(idStr);
            Clientes cliente = dao.buscarPorId(id);
            if (cliente != null) {
                // El método toString() de Clientes se usa aquí
                JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" + cliente.toString(), "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese ID.", "Resultado de Búsqueda", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El ID debe ser un número entero.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Pide un término de búsqueda, llama al DAO y muestra los resultados en un
     * JTextArea dentro de un JScrollPane.
     */
    private static void buscarPorNombre() {
        String termino = JOptionPane.showInputDialog(null, "Ingresa el nombre o parte del nombre:", "Buscar por Nombre", JOptionPane.PLAIN_MESSAGE);
        if (termino == null) return; // Canceló

        List<Clientes> resultados = dao.buscarPorNombre(termino);

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.", "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Usamos un JTextArea para mostrar la lista de resultados
            StringBuilder sb = new StringBuilder("Resultados encontrados (" + resultados.size() + "):\n\n");
            for (Clientes cliente : resultados) {
                sb.append(cliente.toString()).append("\n");
            }
            
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(600, 300));
            
            JOptionPane.showMessageDialog(null, scrollPane, "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Pide el ID de un cliente a eliminar. Muestra los datos del cliente y
     * pide confirmación usando un diálogo YES_NO_OPTION antes de proceder.
     */
    private static void eliminarCliente() {
        String idStr = JOptionPane.showInputDialog(null, "Ingresa el ID del cliente a eliminar:", "Eliminar Cliente", JOptionPane.PLAIN_MESSAGE);
        if (idStr == null) return; // Canceló

        try {
            int id = Integer.parseInt(idStr);
            // Busca al cliente primero para la confirmación
            Clientes cliente = dao.buscarPorId(id);

            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "No existe ningún cliente con el ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prepara el mensaje de confirmación
            String mensajeConfirmacion = "Vas a eliminar al siguiente cliente:\n" +
                                         "Nombre: " + cliente.getNombre() + "\n" +
                                         "Correo: " + cliente.getCorreo() + "\n\n" +
                                         "¿Estás SEGURO?";
            
            // Usamos un showConfirmDialog para la confirmación SÍ/NO
            int confirmacion = JOptionPane.showConfirmDialog(
                    null, 
                    mensajeConfirmacion, 
                    "Confirmar Eliminación", 
                    JOptionPane.YES_NO_OPTION, // Botones SÍ/NO
                    JOptionPane.WARNING_MESSAGE);

            // El usuario presionó SÍ
            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean eliminado = dao.eliminarCliente(id);
                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se pudo eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // El usuario presionó NO o cerró el diálogo
                JOptionPane.showMessageDialog(null, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: Debes ingresar un número ID válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Función auxiliar para cortar una cadena de texto a un ancho especificado.
     * Utilizada principalmente para mantener la alineación de la tabla en
     * {@link #mostrarTodosClientes()}.
     *
     * @param texto La cadena a cortar.
     * @param ancho El ancho máximo deseado.
     * @return La cadena truncada, con "..." si fue necesario.
     */
    private static String cortarCadena(String texto, int ancho) {
        if (texto == null) {
            return "";
        }
        // Si el texto es más corto o igual al ancho, lo devuelve sin cambios.
        if (texto.length() <= ancho) {
            return texto;
        }
        // Si es más largo, lo trunca y añade tres puntos para indicar el corte.
        return texto.substring(0, ancho - 3) + "...";
    }
}