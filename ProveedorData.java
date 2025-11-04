/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionproveedores;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Kevito
 */
public class ProveedorData {
    private ArrayList<Proveedor> listaProveedores = new ArrayList<>();

    // Alta (Agregar proveedor)
    public void altaProveedor() {
        int id = listaProveedores.size() + 1;
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del proveedor:");
        String cuit = JOptionPane.showInputDialog("Ingrese CUIT:");
        String telefono = JOptionPane.showInputDialog("Ingrese teléfono:");
        String email = JOptionPane.showInputDialog("Ingrese email:");
        String direccion = JOptionPane.showInputDialog("Ingrese dirección:");
        String representante = JOptionPane.showInputDialog("Ingrese nombre del representante:");
        String tipoProductos = JOptionPane.showInputDialog("Ingrese tipo de productos que provee:");

        Proveedor p = new Proveedor(id, nombre, cuit, telefono, email, direccion, representante, tipoProductos, true);
        listaProveedores.add(p);

        JOptionPane.showMessageDialog(null, "Proveedor agregado correctamente.");
    }

    // Listar
    public void listarProveedores() {
        if (listaProveedores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proveedores registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== Lista de Proveedores ===\n");
        for (Proveedor p : listaProveedores) {
            sb.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Modificar
    public void modificarProveedor() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del proveedor a modificar:"));
        for (Proveedor p : listaProveedores) {
            if (p.getId() == id) {
                String nuevoTel = JOptionPane.showInputDialog("Nuevo teléfono:", p.getTelefono());
                String nuevoEmail = JOptionPane.showInputDialog("Nuevo email:", p.getEmail());
                String nuevaDir = JOptionPane.showInputDialog("Nueva dirección:", p.getDireccion());
                p.setTelefono(nuevoTel);
                p.setEmail(nuevoEmail);
                p.setDireccion(nuevaDir);

                JOptionPane.showMessageDialog(null, "Proveedor modificado con éxito.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
    }

    // Eliminar (dar de baja)
    public void eliminarProveedor() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del proveedor a eliminar:"));
        for (Proveedor p : listaProveedores) {
            if (p.getId() == id) {
                p.setActivo(false);
                JOptionPane.showMessageDialog(null, "Proveedor dado de baja correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
    }

    // Menú de proveedores
    public void menuProveedores() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    === MENU PROVEEDORES ===
                    1. Alta de proveedor
                    2. Listar proveedores
                    3. Modificar proveedor
                    4. Eliminar proveedor
                    0. Salir
                    """));

            switch (opcion) {
                case 1 -> altaProveedor();
                case 2 -> listarProveedores();
                case 3 -> modificarProveedor();
                case 4 -> eliminarProveedor();
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del módulo de proveedores...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente.");
            }
        } while (opcion != 0);
    }
    
}
