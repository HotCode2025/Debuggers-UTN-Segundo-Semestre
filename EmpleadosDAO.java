
package gestionempleados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpleadoData {
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();

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

    public void listarEmpleados() {
        StringBuilder sb = new StringBuilder("=== Lista de empleados ===\n");
        for (Empleado e : listaEmpleados) {
            sb.append(e).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

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

    public void modificarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del empleado a modificar:"));
        for (Empleado e : listaEmpleados) {
            if (e.getIdEmpleado() == id) {
                String nuevoPuesto = JOptionPane.showInputDialog("Nuevo puesto:", e.toString());
                e.setEstado(true);
                JOptionPane.showMessageDialog(null, "Empleado actualizado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
    }
    
    public void menuEmpleados() {
    int opcion = 0;
    do {
        opcion = Integer.parseInt(JOptionPane.showInputDialog(
            "=== MenÃº de Empleados ===\n" +
            "1. Alta de empleado\n" +
            "2. Listar empleados\n" +
            "3. Modificar empleado\n" +
            "4. Eliminar empleado\n" +
            "5. Salir\n\n" +
            "Ingrese una opciÃ³n:"));

        switch (opcion) {
            case 1:
                altaEmpleado();
                break;
            case 2:
                listarEmpleados();
                break;
            case 3:
                modificarEmpleado();
                break;
            case 4:
                eliminarEmpleado();
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Saliendo del mÃ³dulo de empleados...");
                break;
            default:
                JOptionPane.showMessageDialog(null, "OpciÃ³n invÃ¡lida, intente nuevamente.");
        }
    } while (opcion != 5);
}
}
