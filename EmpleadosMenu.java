/*
 * Clase encargada de la interfaz visual mediante JOptionPane.
 * Permite al usuario interactuar con el módulo de empleados
 * para realizar operaciones CRUD desde una consola gráfica simple.
 */

package SistemaDeVentas;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/*
 * @author Debuggers UTN - Celeste
 */

public class EmpleadosMenu {

    // Instancia del DAO para acceder a los métodos que interactúan con la base de datos
    private static final EmpleadosDAO dao = new EmpleadosDAO();
    
    // ==========================================================
    // MÉTODO: mostrarMenu
    // ==========================================================
    /*
     * Muestra el menú principal con opciones para gestionar empleados.
     * Usa JOptionPane para recibir y mostrar información al usuario.
     */
    public static void mostrarMenu() {
        int opcion;

        do {
            String menu = """
                    === MENÚ DE EMPLEADOS ===
                    1. Alta de empleado
                    2. Listar empleados
                    3. Modificar empleado
                    4. Buscar empleado por ID
                    0. Salir
                    """;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1 -> altaEmpleado();
                case 2 -> listarEmpleados();
                case 3 -> modificarEmpleado();
                case 4 -> buscarEmpleado();
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del módulo de empleados...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 0);
    }

    // ==========================================================
    // MÉTODO: altaEmpleado
    // ==========================================================
    /*
     * Permite registrar un nuevo empleado en la base de datos.
     * Solicita los datos mediante ventanas emergentes y luego los guarda.
     */
    private static void altaEmpleado() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String apellido = JOptionPane.showInputDialog("Apellido:");
            String dni = JOptionPane.showInputDialog("DNI:");
            String direccion = JOptionPane.showInputDialog("Dirección:");
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            String correo = JOptionPane.showInputDialog("Correo:");
            String puesto = JOptionPane.showInputDialog("Puesto:");
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Sueldo:"));

            // Crea un nuevo objeto empleado y lo pasa al DAO
            Empleados emp = new Empleados(0, nombre, apellido, dni, direccion, telefono, correo, puesto, sueldo);
            dao.agregarEmpleado(emp);
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar datos: " + e.getMessage());
        }
    }

    // ==========================================================
    // MÉTODO: listarEmpleados
    // ==========================================================
    /*
     * Muestra en pantalla el listado completo de empleados registrados.
     * Presenta los datos en una tabla de texto monoespaciado dentro de un JScrollPane.
     */
    private static void listarEmpleados() {
        List<Empleados> lista = dao.listarTodos();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===============================================================================================================\n");
        sb.append(String.format("| %-4s | %-15s | %-15s | %-10s | %-15s | %-10s | %-20s |\n",
                "ID", "APELLIDO", "NOMBRE", "DNI", "PUESTO", "SUELDO", "EMAIL"));
        sb.append("---------------------------------------------------------------------------------------------------------------\n");

        for (Empleados e : lista) {
            sb.append(String.format("| %-4d | %-15s | %-15s | %-10s | %-15s | %-10.2f | %-20s | \n",
                    e.getId(), e.getApellido(), e.getNombre(), e.getDni(), e.getPuesto(),
                    e.getSueldo(), e.getCorreo()));
        }
        sb.append("---------------------------------------------------------------------------------------------------------------\n");
        
        // Mostrar los resultados en una ventana desplazable
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(950, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "LISTADO DE EMPLEADOS", JOptionPane.INFORMATION_MESSAGE);
    }

    // ==========================================================
    // MÉTODO: modificarEmpleado
    // ==========================================================
    /*
     * Permite modificar los datos de un empleado existente.
     * Primero busca al empleado por su ID, y luego permite cambiar sus campos.
     */
    private static void modificarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado a modificar:"));
        Empleados emp = dao.buscarPorId(id);
        if (emp == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            return;
        }

        emp.setCorreo(JOptionPane.showInputDialog("Nuevo correo:", emp.getCorreo()));
        emp.setTelefono(JOptionPane.showInputDialog("Nuevo teléfono:", emp.getTelefono()));
        emp.setDireccion(JOptionPane.showInputDialog("Nueva dirección:", emp.getDireccion()));
        emp.setPuesto(JOptionPane.showInputDialog("Nuevo puesto:", emp.getPuesto()));
        emp.setSueldo(Double.parseDouble(JOptionPane.showInputDialog("Nuevo sueldo:", emp.getSueldo())));

        if (dao.modificarEmpleado(emp)) {
            JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado.");
        }
    }

    // ==========================================================
    // MÉTODO: buscarEmpleado
    // ==========================================================
    /*
     * Busca y muestra los datos de un empleado a partir de su ID.
     * Si no se encuentra, informa al usuario.
     */
    private static void buscarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado:"));
        Empleados emp = dao.buscarPorId(id);
        if (emp == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, emp.toString());
        }
    }
}
