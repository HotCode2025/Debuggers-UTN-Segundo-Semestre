package sistemadeventas;

import java.awt.Font;          // Importamos para usar Font para poder formatear el texto
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane; // Importamos para usar el scroll
import javax.swing.JTextArea; // Importamos para usar el área de texto

public class ClientesMenu_JOP {

    // Scanner para leer la entrada del usuario
    private static final Scanner scanner = new Scanner(System.in);
    // Instancia del DAO
    private static final ClientesDAO dao = new ClientesDAO();

    public static void ejecutarMenu() {
        int opcion;

        do {
            mostrarSubmenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Función: Agregar Nuevo Cliente...");
                        crearCliente();
                        break;
                    case 2:
                        System.out.println("Función: Mostrar Todos los Clientes...");
                        mostrarTodosClientes();
                        break;
                    case 3:
                        buscarPorId();
                        break;
                    case 4:
                        buscarPorNombre();
                        break;
                    case 5:
                        System.out.println("Función: Modificar los datos de un Clientes...");
                        modificarCliente();
                        break;
                    case 6:
                        System.out.println("Función: Eliminar Cliente...");
                        eliminarCliente();
                        break;
                    case 0:
                        System.out.println("Volviendo al Menú Principal.");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un número para la opción.");
                opcion = -1;
            }
        } while (opcion != 0);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Método auxiliar para mostrar el submenú de Clientes
    private static void mostrarSubmenu() {
        System.out.println("\n====== MÓDULO CLIENTES ======");
        System.out.println("  1. Agregar Nuevo Cliente");
        System.out.println("  2. Mostrar Todos los Clientes");
        System.out.println("  3. Buscar Cliente por ID");
        System.out.println("  4. Buscar Cliente por Nombre");
        System.out.println("  5. Modificar Cliente");
        System.out.println("  6. Eliminar Cliente");
        System.out.println("  0. Volver al Menú Principal");
        System.out.println("=============================");
        System.out.print("Selecciona una opción: ");
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Método auxiliar para truncar cadenas de forma segura
    private static String truncarCadena(String texto, int maxLargo) {
        if (texto == null) {
            return "";
        }
        return (texto.length() > maxLargo) ? texto.substring(0, maxLargo - 3) + "..." : texto;
    }

    // -----------------------------------------------------------------------------------------------------------------
    /*
     * Mostramos la lista completa de clientes en una ventana JOptionPane.
     */
    private static void mostrarTodosClientes() {
        List<Clientes> todosLosClientes = dao.listarTodos(); // Llama al método del DAO
        StringBuilder mensaje = new StringBuilder();

        // Si no hay clientes, muestra un mensaje simple
        if (todosLosClientes.isEmpty()) {
            mensaje.append("No hay clientes registrados en el sistema.");
            return;
        }

        // Armamos la informacion que queremos mostrar
        mensaje.append("===================================================================================================================\n");
        mensaje.append(String.format("| %-4s | %-30s | %-15s | %-20s | %-30s |%n", "ID", "NOMBRE", "TELÉFONO", "CORREO", "DIRECCIÓN"));
        mensaje.append("-------------------------------------------------------------------------------------------------------------------\n");

        for (Clientes cliente : todosLosClientes) {
            // Cortamos los textos que se exeden
            String nombreTruncado = truncarCadena(cliente.getNombre(), 30);
            String correoTruncado = truncarCadena(cliente.getCorreo(), 20);
            String direccionTruncada = truncarCadena(cliente.getDireccion(), 30);

            // Usamos String.format para rellenar con espacios hasta el ancho de columna
            mensaje.append(String.format("| %-4d | %-30s | %-15s | %-20s | %-30s |\n",
                    cliente.getId(),
                    nombreTruncado,
                    cliente.getTelefono(),
                    correoTruncado,
                    direccionTruncada
            ));
        }
        mensaje.append("-------------------------------------------------------------------------------------------------------------------\n");
        mensaje.append("Total de registros: ").append(todosLosClientes.size()).append("\n");

        // Utilizamos un JTextArea y le forzamos un tipo de letra donde todos los caracteres ocupen el mismo ancho
        JTextArea textArea = new JTextArea(mensaje.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        textArea.setEditable(false); // Para que el usuario no pueda editar

        // con JScrollPane hacemos que la ventana sea escroleable
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(810, 400)); // Tamaño de la ventana

        // Muestra el mensaje
        JOptionPane.showMessageDialog(
                null,
                scrollPane,
                "LISTADO DE TODOS LOS CLIENTES",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void crearCliente() {
        Clientes nuevoCliente = new Clientes();
        System.out.println("--- Ingreso de Nuevo Cliente ---");

        System.out.print("Nombre: ");
        nuevoCliente.setNombre(scanner.nextLine());

        System.out.print("Teléfono: ");
        nuevoCliente.setTelefono(scanner.nextLine());

        System.out.print("Correo: ");
        nuevoCliente.setCorreo(scanner.nextLine());

        System.out.print("Dirección: ");
        nuevoCliente.setDireccion(scanner.nextLine());

        try {
            dao.agregarCliente(nuevoCliente);
            System.out.println("Cliente agregado exitosamente!");
        } catch (Exception e) {
            // Si da algun tipo de error lo mostramos
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void modificarCliente() {
        System.out.print("Ingresa el ID del cliente a modificar: ");
        try {
            int idModificar = Integer.parseInt(scanner.nextLine());
            Clientes clienteExistente = dao.buscarPorId(idModificar);

            if (clienteExistente == null) {
                System.out.println("No se encontró ningún cliente con ID: " + idModificar);
                return;
            }

            System.out.println("Modificando Cliente ID: " + clienteExistente.getId() + " - " + clienteExistente.getNombre());
            System.out.println("Deje el campo vacío para mantener el valor actual.");

            // Nombre
            System.out.print("Nuevo Nombre [" + clienteExistente.getNombre() + "]: ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.trim().isEmpty()) {
                clienteExistente.setNombre(nuevoNombre);
            }

            // Teléfono
            System.out.print("Nuevo Teléfono [" + clienteExistente.getTelefono() + "]: ");
            String nuevoTelefono = scanner.nextLine();
            if (!nuevoTelefono.trim().isEmpty()) {
                clienteExistente.setTelefono(nuevoTelefono);
            }

            // Correo
            System.out.print("Nuevo Correo [" + clienteExistente.getCorreo() + "]: ");
            String nuevoCorreo = scanner.nextLine();
            if (!nuevoCorreo.trim().isEmpty()) {
                clienteExistente.setCorreo(nuevoCorreo);
            }

            // Dirección
            System.out.print("Nueva Dirección [" + clienteExistente.getDireccion() + "]: ");
            String nuevaDireccion = scanner.nextLine();
            if (!nuevaDireccion.trim().isEmpty()) {
                clienteExistente.setDireccion(nuevaDireccion);
            }
            /*            
            if (dao.modificarCliente(clienteExistente)) {
                 JOptionPane.showMessageDialog(null, "Cliente ID " + idModificar + " modificado exitosamente.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 JOptionPane.showMessageDialog(null, "Error al modificar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
             */
        } catch (NumberFormatException e) {
            System.out.println("ERROR: El ID debe ser un número entero.");
        } catch (Exception e) {
            // Si da algun tipo de error lo mostramos
            System.err.println("Error: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void buscarPorId() {
        System.out.print("Ingresa el ID (número entero): ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Clientes cliente = dao.buscarPorId(id);
            if (cliente != null) {
                String mensaje = String.format(
                        "ID: %d%nNombre: %s%nTeléfono: %s%nCorreo: %s%nDirección: %s",
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getTelefono(),
                        cliente.getCorreo(),
                        cliente.getDireccion()
                );
                JOptionPane.showMessageDialog(null, mensaje, "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese ID.", "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El ID debe ser un número entero.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void buscarPorNombre() {
        String termino = JOptionPane.showInputDialog(null, "Ingresa el nombre o parte del nombre:", "Buscar Cliente por Nombre", JOptionPane.QUESTION_MESSAGE);

        if (termino == null || termino.trim().isEmpty()) {
            return; // El usuario canceló o no ingresó nada
        }

        List<Clientes> resultados = dao.buscarPorNombre(termino.trim());

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias para '" + termino + "'.", "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("<html><pre><b>Clientes encontrados para '").append(termino).append("':</b><br>");
            mensaje.append("---------------------------------------------------<br>");
            mensaje.append(String.format("| %-4s | %-30s | %-15s |%n", "ID", "NOMBRE", "TELÉFONO"));
            mensaje.append("---------------------------------------------------<br>");

            for (Clientes cliente : resultados) {
                String nombreTruncado = truncarCadena(cliente.getNombre(), 30);

                mensaje.append(String.format("| %-4d | %-30s | %-15s |%n",
                        cliente.getId(),
                        nombreTruncado,
                        cliente.getTelefono()
                ));
            }

            mensaje.append("</pre></html>");
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void eliminarCliente() {
        String inputId = JOptionPane.showInputDialog(null, "Ingresa el ID del cliente a eliminar:", "Eliminar Cliente", JOptionPane.QUESTION_MESSAGE);

        if (inputId == null || inputId.trim().isEmpty()) {
            return; // Usuario canceló o no ingresó nada
        }

        try {
            int idEliminar = Integer.parseInt(inputId);

            // 1. Buscar cliente para mostrar confirmación
            Clientes clienteAEliminar = dao.buscarPorId(idEliminar);

            if (clienteAEliminar == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ID: " + idEliminar, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Pedir confirmación
            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro de que deseas eliminar al cliente:\n"
                    + "ID: " + clienteAEliminar.getId() + "\n"
                    + "Nombre: " + clienteAEliminar.getNombre() + "?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmacion == JOptionPane.YES_OPTION) {
                // 3. Llamar al DAO para eliminar
                if (dao.eliminarCliente(idEliminar)) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al intentar eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El ID debe ser un número entero.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

