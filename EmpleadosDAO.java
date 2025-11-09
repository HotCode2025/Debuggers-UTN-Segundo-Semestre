/*
 * Clase encargada de gestionar la lista de empleados desde memoria.
 * Permite dar de alta, listar, modificar y eliminar empleados usando JOptionPane.
 * 
 *
 * @author Debuggers UTN
 */

package gestionempleados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpleadoData {

    // Lista temporal de empleados (simula la base de datos)
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    // ==========================================================
    // Alta de empleado: solicita datos y crea un nuevo registro
    // ==========================================================
    public void altaEmpleado() {
        int id = listaEmpleados.size() + 1;
        String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese apellido:");
        String puesto = JOptionPane.showInputDialog("Ingrese puesto:");
        double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese sueldo base:"));

        Empleado employee = new Empleado(id, nombre, apellido, puesto, sueldo);
        listaEmpleados.add(employee);
        JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
    }

    // ==========================================================
    // Listado general de empleados
    // ==========================================================
    public void listarEmpleados() {
        StringBuilder sb = new StringBuilder("=== Lista de empleados ===\n");
        for (Empleado e : listaEmpleados) {
            sb.append(e).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // ==========================================================
    // Baja de empleado (cambia el estado a inactivo)
    // ==========================================================
    public void eliminarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado a eliminar:"));
        for (Empleado e : listaEmpleados) {
            if (e.getIdEmpleado() == id) {
                e.setEstado(false);
                JOptionPane.showMessageDialog(null, "Empleado dado de baja.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
    }

    // ==========================================================
    // Modificación de datos de un empleado existente
    // ==========================================================
    public void modificarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado a modificar:"));
        for (Empleado e : listaEmpleados) {
            if (e.getIdEmpleado() == id) {
                String nuevoPuesto = JOptionPane.showInputDialog("Nuevo puesto:", e.getPuesto());
                e.setPuesto(nuevoPuesto);
                e.setEstado(true);
                JOptionPane.showMessageDialog(null, "Empleado actualizado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
    }

    // ==========================================================
    // Menú principal de empleados
    // ==========================================================
    public void menuEmpleados() {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "=== Menú de Empleados ===\n" +
                "1. Alta de empleado\n" +
                "2. Listar empleados\n" +
                "3. Modificar empleado\n" +
                "4. Eliminar empleado\n" +
                "5. Salir\n\n" +
                "Ingrese una opción:"));

            switch (opcion) {
                case 1 -> altaEmpleado();
                case 2 -> listarEmpleados();
                case 3 -> modificarEmpleado();
                case 4 -> eliminarEmpleado();
                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo del módulo de empleados...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
