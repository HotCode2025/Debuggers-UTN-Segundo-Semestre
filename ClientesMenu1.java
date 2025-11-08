/*
 * CLASE: ClientesMenu
 *
 * PROPÓSITO:
 * Proporciona una interfaz de consola para interactuar con la gestión de clientes.
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
import java.util.Scanner;

public class ClientesMenu {

    // Scanner para leer la entrada del usuario (compartido por todos los métodos)
    private static final Scanner scanner = new Scanner(System.in);
    // Instancia del DAO para interactuar con la base de datos
    private static final ClientesDAO dao = new ClientesDAO();

    /**
     * Inicia el bucle principal del menú de Clientes.
     * Muestra las opciones, solicita la entrada y ejecuta la operación seleccionada
     * hasta que el usuario elija la opción 0 para salir.
     */
    public static void ejecutarMenu() {
        int opcion;

        do {
            mostrarSubmenu();

            try {
                // Lee la entrada como texto y la convierte a número
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Agregar Nuevo Cliente");
                        crearCliente();
                        break;
                    case 2:
                        System.out.println("Mostrar Todos los Clientes");
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
                        System.out.println("Eliminar Cliente");
                        eliminarCliente();
                        break;
                    case 0:
                        System.out.println("Volviendo al Menú Principal.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                // Captura si el usuario ingresa texto en lugar de un número
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                opcion = -1; // Asigna un valor inválido para que el bucle continúe
            }

            // Pausa después de la operación, si no es la opción de salir
            if (opcion != 0) {
                System.out.println("\nPresiona ENTER para volver al submenú de Clientes...");
                scanner.nextLine(); // Espera que el usuario presione Enter
            }
        } while (opcion != 0);
    }

    /**
     * Imprime en consola las opciones disponibles del submenú de Clientes.
     */
    private static void mostrarSubmenu() {
        System.out.println("\n======= SUBMENU MÓDULO CLIENTES =======");
        System.out.println("\t1. Agregar Nuevo Cliente");
        System.out.println("\t2. Ver Lista de Clientes");
        System.out.println("\t3. Buscar Cliente por ID");
        System.out.println("\t4. Buscar Cliente por Nombre");
        System.out.println("\t5. Modificar Cliente");
        System.out.println("\t6. Eliminar Cliente");
        System.out.println("\t0. Volver al Menú Principal");
        System.out.println("");
        System.out.println("=========================================");
        System.out.print("Elige una acción: ");
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Solicita al usuario los datos de un nuevo cliente (nombre, teléfono, etc.)
     * y llama al DAO para guardarlo en la base de datos.
     */
    private static void crearCliente() {
        System.out.println("\n--- AGREGAR NUEVO CLIENTE ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        try {
            // 0 en el ID indica que es un nuevo registro (la BD asignará el ID)
            Clientes nuevoCliente = new Clientes(0, nombre, telefono, email, direccion);
            dao.agregarCliente(nuevoCliente);
            System.out.println("\nCliente: " + nombre + " agregado correctamente");
        } catch (Exception e) {
            // Si ocurre algún error en la capa DAO (ej. BD desconectada)
            System.err.println("Error al agregar el cliente: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Solicita al usuario el ID de un cliente existente y los nuevos datos.
     * Llama al DAO para actualizar la información en la base de datos.
     */
    private static void modificarCliente() {
        System.out.println("\n--- MODIFICAR CLIENTE ---");
        System.out.print("Ingresa el ID del cliente a modificar: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            // Opcional: Se podría buscar primero al cliente para confirmar que existe
            // Clientes clienteCheck = dao.buscarPorId(id);
            // if (clienteCheck == null) {
            //     System.out.println("No se encontró cliente con ID: " + id);
            //     return;
            // }

            System.out.println("Ingresa los NUEVOS datos (deje en blanco para no cambiar):");
            // NOTA: Esta implementación reemplaza todos los campos.
            // Una mejora sería verificar si el campo está en blanco y mantener el valor anterior.
            System.out.print("Nuevo Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Nuevo Email: ");
            String email = scanner.nextLine();
            System.out.print("Nueva Direccion: ");
            String direccion = scanner.nextLine();

            // Crea el objeto cliente con los datos actualizados
            Clientes clienteActualizado = new Clientes(id, nombre, telefono, email, direccion);
            dao.modificarCliente(clienteActualizado);
            System.out.println("\nCliente: " + nombre + " se modifico correctamente");

        } catch (NumberFormatException e) {
            System.out.println("ERROR: El ID debe ser un número entero.");
        } catch (Exception e) {
            // Si da algun tipo de error lo mostramos
            System.err.println("Error al modificar el cliente: " + e.getMessage());
        }
    }

    /**
     * Llama al DAO para obtener la lista completa de clientes
     * y la imprime en la consola en un formato de tabla.
     */
    private static void mostrarTodosClientes() {
        System.out.println("==================================================");
        System.out.println("            LISTADO DE TODOS LOS CLIENTES");
        System.out.println("==================================================");

        List<Clientes> todosLosClientes = dao.listarTodos(); // Llama al método del DAO

        if (todosLosClientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema.");
        } else {
            // Imprime una cabecera formateada
            System.out.printf("| %-4s | %-30s | %-15s | %-20s | %-30s |%n", "ID", "NOMBRE", "TELÉFONO", "CORREO", "DIRECCIÓN");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");

            // Itera sobre la lista e imprime cada cliente
            for (Clientes cliente : todosLosClientes) {
                // Trunca las cadenas largas para que no rompan el formato de la tabla
                String nombreTruncado = cortarCadena(cliente.getNombre(), 30);
                String telefono = cliente.getTelefono();
                String correoTruncado = cortarCadena(cliente.getCorreo(), 20);
                String direccionTruncada = cortarCadena(cliente.getDireccion(), 30);

                System.out.printf("| %-4d | %-30s | %-15s | %-20s | %-30s |%n",
                        cliente.getId(),
                        nombreTruncado,
                        telefono,
                        correoTruncado,
                        direccionTruncada);
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println("Total de registros: " + todosLosClientes.size());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Solicita un ID al usuario, llama al DAO para buscar un cliente
     * y muestra el resultado en consola.
     */
    private static void buscarPorId() {
        System.out.println("\n--- BUSCAR CLIENTE POR ID ---");
        System.out.print("Ingresa el ID (número entero): ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Clientes cliente = dao.buscarPorId(id);

            if (cliente != null) {
                System.out.println("Cliente encontrado:");
                // Utiliza el método toString() de la clase Clientes
                System.out.println(cliente);
            } else {
                System.out.println("No se encontró ningún cliente con ese ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: El ID debe ser un número entero.");
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Solicita un término de búsqueda (nombre) al usuario, llama al DAO
     * y muestra una lista de todos los clientes que coinciden.
     */
    private static void buscarPorNombre() {
        System.out.println("\n--- BUSCAR CLIENTE POR NOMBRE ---");
        System.out.print("Ingresa el nombre o parte del nombre: ");
        String termino = scanner.nextLine();

        List<Clientes> resultados = dao.buscarPorNombre(termino);

        if (resultados.isEmpty()) {
            System.out.println(" No se encontraron coincidencias para '" + termino + "'.");
        } else {
            System.out.println("Resultados encontrados (" + resultados.size() + "):");
            // Itera y muestra cada resultado usando el método toString() de Clientes
            resultados.forEach(System.out::println);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Solicita el ID de un cliente a eliminar.
     * Busca al cliente, pide confirmación al usuario y, si se confirma,
     * llama al DAO para eliminarlo.
     */
    private static void eliminarCliente() {
        System.out.println("\n--- ELIMINAR CLIENTE ---");
        System.out.print("Ingresa el ID del cliente a eliminar: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            // 1. Primero buscamos al cliente para mostrar quién es (confirmación visual)
            Clientes cliente = dao.buscarPorId(id);

            if (cliente == null) {
                System.out.println("️No existe ningún cliente con el ID: " + id);
                return; // Salimos del método si no existe
            }

            // 2. Mostramos los datos del cliente a eliminar
            System.out.println("\nVas a eliminar al siguiente cliente:");
            System.out.println("ID:     " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Correo: " + cliente.getCorreo());

            // 3. Pedimos confirmación final
            System.out.print("\n¿Estás SEGURO? Escribe 'S' para confirmar (cualquier otra tecla cancela): ");
            String confirmacion = scanner.nextLine();

            if (confirmacion.equalsIgnoreCase("S")) {
                // 4. Llamamos al DAO para eliminar
                boolean eliminado = dao.eliminarCliente(id);

                if (eliminado) {
                    System.out.println("Cliente eliminado correctamente.");
                } else {
                    // Esto podría pasar si hay restricciones (ej. claves foráneas)
                    System.out.println("Error: No se pudo eliminar el cliente.");
                }
            } else {
                System.out.println("Operación cancelada.");
            }

        } catch (NumberFormatException e) {
            System.out.println("ERROR: Debes ingresar un número ID válido.");
        }
    }

    /**
     * Función auxiliar para cortar una cadena de texto a un ancho especificado.
     * Utilizada principalmente para mantener la alineación de la tabla en consola.
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


