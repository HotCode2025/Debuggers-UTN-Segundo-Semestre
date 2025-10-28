/*
 * 
*/

package SistemaDeVentas;

/*
 * @author Debuggers UTN
*/

import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            // Muestra el menu principal
            mostrarMenuPrincipal();

            // Entra en un bucle hasta que el usuario selecciona la opcion de salir
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        // Llama al menú del módulo Clientes
                        ClientesMenu.ejecutarMenu(); 
                        break;
                    case 2:
                        // Llama al menú del módulo Empleados
//                        EmpleadoMenu.ejecutarMenu();
                        break;
                    case 3:
                        // Llama al menú del módulo Proveedores
//                        ProveedorMenu.ejecutarMenu();
                        break;
                    case 0:
                        
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                opcion = -1;
            }
            
            if (opcion != 0) {
                System.out.println("\n--- Presiona ENTER para volver al Menú Principal ---");
                scanner.nextLine();
            }
        } while (opcion != 0);
        
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n====== MENÚ PRINCIPAL DEL SISTEMA ======");
        System.out.println("");
        System.out.println("\t 1. Módulo Clientes");
        System.out.println("\t 2. Módulo Empleados");
        System.out.println("\t 3. Módulo Proveedores");
        System.out.println("\t 0. Salir del Sistema");
        System.out.println("");
        System.out.println("=========================================");
        System.out.print("Elige un módulo: ");
    }
}
