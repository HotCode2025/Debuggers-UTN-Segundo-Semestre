/*
 * Interfaz de gestión de empleados conectada con la base de datos.
 * Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * utilizando la clase EmpleadosDAO.
 * 
 * @author Debuggers UTN
 */

package SistemaDeVentas;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmpleadosMenu {

    public static void mostrarMenu() {
        EmpleadosDAO dao = new EmpleadosDAO();
        int opcion;

        do {
            String menu = """
                    === MENÚ DE EMPLEADOS ===
                    1. Alta de empleado
                    2. Listar empleados
                    3. Modificar empleado
                    4. Eliminar empleado
                    5. Buscar empleado por ID
                    0. Salir
                    """;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1 -> altaEmpleado(dao);
                case 2 -> listarEmpleados(dao);
                case 3 -> modificarEmpleado(dao);
                case 4 -> eliminarEmpleado(dao);
                case 5 -> buscarEmpleado(dao);
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del módulo de empleados...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 0);
    }

    // ==========================================================
    // Alta de empleado con carga de datos manual
    // ==========================================================
    private static void altaEmpleado(EmpleadosDAO dao) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String apellido = JOptionPane.showInputDialog("Apellido:");
            String dni = JOptionPane.showInputDialog("DNI:");
            String cuil = JOptionPane.showInputDialog("CUIL:");
            String puesto = JOptionPane.showInputDialog("Puesto:");
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Sueldo base:"));
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            String correo = JOptionPane.showInputDialog("Correo:");

            Empleados emp = new Empleados(0, nombre, apellido, dni, cuil, puesto, sueldo, telefono, correo, true);
            dao.agregarEmpleado(emp);
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar datos: " + e.getMessage());
        }
    }

    // ==========================================================
    // Listado completo de empleados en formato tabla
    // ==========================================================
    private static void listarEmpleados(EmpleadosDAO dao) {
        List<Empleados> lista = dao.listarTodos();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===================================================================================================================\n");
        sb.append(String.format("| %-4s | %-15s | %-15s | %-10s | %-12s | %-15s | %-10s | %-20s | %-8s |\n",
                "ID", "NOMBRE", "APELLIDO", "DNI", "CUIL", "PUESTO", "SUELDO", "EMAIL", "ESTADO"));
        sb.append("-------------------------------------------------------------------------------------------------------------------\n");

        for (Empleados e : lista) {
            sb.append(String.format("| %-4d | %-15s | %-15s | %-10s | %-12s | %-15s | %-10.2f | %-20s | %-8s |\n",
                    e.getId(), e.getNombre(), e.getApellido(), e.getDni(), e.getCuil(), e.getPuesto(),
                    e.getSueldoBase(), e.getCorreo(), (e.isActivo() ? "Activo" : "Inactivo")));
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(950, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "LISTADO DE EMPLEADOS", JOptionPane.INFORMATION_MESSAGE);
    }

    // ==========================================================
    // Modificación de un registro existente
    // ==========================================================
    private static void modificarEmpleado(EmpleadosDAO dao) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado a modificar:"));
        Empleados emp = dao.buscarPorId(id);
        if (emp == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            return;
        }

        emp.setPuesto(JOptionPane.showInputDialog("Nuevo puesto:", emp.getPuesto()));
        emp.setSueldoBase(Double.parseDouble(JOptionPane.showInputDialog("Nuevo sueldo base:", emp.getSueldoBase())));
        emp.setCorreo(JOptionPane.showInputDialog("Nuevo correo:", emp.getCorreo()));
        emp.setTelefono(JOptionPane.showInputDialog("Nuevo teléfono:", emp.getTelefono()));
        emp.setActivo(true);

        if (dao.modificarEmpleado(emp)) {
            JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado.");
        }
    }

    // ==========================================================
    // Eliminación lógica de un empleado (baja)
    // ==========================================================
    private static void eliminarEmpleado(EmpleadosDAO dao) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado a eliminar:"));
        if (dao.eliminarEmpleado(id)) {
            JOptionPane.showMessageDialog(null, "Empleado dado de baja correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el empleado.");
        }
    }

    // ==========================================================
    // Búsqueda individual por ID
    // ==========================================================
    private static void buscarEmpleado(EmpleadosDAO dao) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado:"));
        Empleados emp = dao.buscarPorId(id);
        if (emp == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, emp.toString());
        }
    }
}
