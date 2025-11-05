package sistemadeventas;

import java.util.List;
import java.util.Scanner;

public class Clientesmenu {

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
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                opcion = -1;
            }

            // Pausa después de la operación, si no es salir
            if (opcion != 0) {
                System.out.println("\nPresiona ENTER para volver al submenú de Clientes...");
                scanner.nextLine();
            }

        } while (opcion != 0);
    }

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
            // 0 en el ID indica que es un nuevo registro
            Clientes nuevoCliente = new Clientes(0, nombre, telefono, email, direccion);
            dao.agregarCliente(nuevoCliente);
            System.out.println("\nCliente: " + nombre + " agregado correctamente");
        } catch (Exception e) {
            // Si da algun tipo de error lo mostramos
            System.err.println("Error: " + e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void modificarCliente() {
        System.out.println("\n--- MODIFICAR CLIENTE ---");
        System.out.print("Ingresa el ID del cliente a modificar: ");

        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingresa los NUEVOS datos:");
        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nuevo Email: ");
        String email = scanner.nextLine();
        System.out.print("Nueva Direccion: ");
        String direccion = scanner.nextLine();

        try {
            // 0 en el ID indica que es un nuevo registro
            Clientes clienteActualizado = new Clientes(id, nombre, telefono, email, direccion);
            dao.modificarCliente(clienteActualizado);
            System.out.println("\nCliente: " + nombre + " se modifico correctamente");
        } catch (Exception e) {
            // Si da algun tipo de error lo mostramos
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarTodosClientes() {
        System.out.println("==================================================");
        System.out.println("        LISTADO DE TODOS LOS CLIENTES");
        System.out.println("==================================================");

        List<Clientes> todosLosClientes = dao.listarTodos(); // Llama al método del DAO

        if (todosLosClientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema.");
        } else {
            // 2. Imprime los resultados
            // Opcional: imprimir una cabecera formateada
            System.out.printf("| %-4s | %-30s | %-15s | %-20s | %-30s |%n", "ID", "NOMBRE", "TELÉFONO", "CORREO", "DIRECCIÓN");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");

            for (Clientes cliente : todosLosClientes) {
                String nombreTruncado = cortarCadena(cliente.getNombre(), 30);
                String telefono = cliente.getTelefono();
                String correoTruncado = cortarCadena(cliente.getCorreo(), 20);
                String direccionTruncada = cortarCadena(cliente.getDireccion(), 30);

                System.out.printf("| %-4d | %-30s | %-15s | %-20s | %-30s |%n",
                        cliente.getId(),
                        nombreTruncado,
                        telefono,
                        correoTruncado,
                        direccionTruncada
                );
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println("Total de registros: " + todosLosClientes.size());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void buscarPorId() {
        System.out.print("Ingresa el ID (número entero): ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Clientes cliente = dao.buscarPorId(id);
            if (cliente != null) {
                System.out.println("Cliente encontrado: " + cliente);
            } else {
                System.out.println("No se encontró ningún cliente con ese ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: El ID debe ser un número entero.");
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void buscarPorNombre() {
        System.out.print("Ingresa el nombre o parte del nombre: ");
        String termino = scanner.nextLine();

        List<Clientes> resultados = dao.buscarPorNombre(termino);

        if (resultados.isEmpty()) {
            System.out.println(" No se encontraron coincidencias.");
        } else {
            System.out.println("Resultados encontrados:");
            resultados.forEach(System.out::println);
        }
    }
    
    //------------------------------------------------------------------------------------------------------------------
    private static void eliminarCliente(){
        System.out.println("\n--- ELIMINAR CLIENTE ---");
        System.out.println("Ingresa el ID del cliente a eliminar: ");
        
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("ERROR: El ID debe ser un número entero.");
            return;
        }
        
        // Buscar y mostrar el cliente antes de borrar
        Clientes cliente = dao.buscarPorId(id);
        
        if (cliente == null){
            System.out.println("No se encontró ningún cliente con el ID: " + id);
            return;
        }
        
        System.out.println("\nSe eliminará al siguiente cliente:");
        System.out.println(cliente); 
        
        System.out.print("\n¿Estás seguro de que deseas eliminarlo? (S/N): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            try {
                // Llamamos al DAO para que ejecute la baja
                dao.eliminarCliente(id); 
                System.out.println("Cliente eliminado correctamente.");
            } catch (Exception e) {
                System.err.println("Error al intentar eliminar el cliente: " + e.getMessage());
            }
        } else {
            System.out.println("Operación cancelada.");
        }
    }
        
    

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
