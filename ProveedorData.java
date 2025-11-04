package gestionproveedores;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProveedorData {
    private ArrayList<Proveedor> listaProveedores = new ArrayList<>();

    //MÉTODO GENERAL PARA PEDIR DATOS
    private String pedirDato(String campo) {
        String valor;
        do {
            valor = JOptionPane.showInputDialog("Ingrese " + campo + ":");
            if (valor == null) { // Usuario presionó "Cancelar"
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return null;
            } else if (valor.trim().isEmpty()) { // Campo vacío
                JOptionPane.showMessageDialog(null, "Escribe el " + campo + ".");
            }
        } while (valor.trim().isEmpty());
        return valor.trim();
    }

    //ALTA DE PROVEEDOR
    public void altaProveedor() {
        int id = listaProveedores.size() + 1;

        String nombre = pedirDato("nombre del nuevo proveedor");
        if (nombre == null) return;

        String cuit = pedirDato("CUIT del proveedor");
        if (cuit == null) return;

        String telefono = pedirDato("teléfono del proveedor");
        if (telefono == null) return;

        String email = pedirDato("email del proveedor");
        if (email == null) return;

        String direccion = pedirDato("dirección del proveedor");
        if (direccion == null) return;

        String representante = pedirDato("nombre del representante");
        if (representante == null) return;

        String tipoProductos = pedirDato("tipo de productos que provee");
        if (tipoProductos == null) return;

        Proveedor p = new Proveedor(id, nombre, cuit, telefono, email, direccion, representante, tipoProductos, true);
        listaProveedores.add(p);

        JOptionPane.showMessageDialog(null, "Proveedor agregado correctamente.");
    }

    //LISTAR PROVEEDORES
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

    //MODIFICAR PROVEEDOR
    public void modificarProveedor() {
        String idTexto = pedirDato("ID del proveedor a modificar");
        if (idTexto == null) return;

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
            return;
        }

        for (Proveedor p : listaProveedores) {
            if (p.getId() == id) {
                String nuevoTel = pedirDato("nuevo teléfono (actual: " + p.getTelefono() + ")");
                if (nuevoTel == null) return;

                String nuevoEmail = pedirDato("nuevo email (actual: " + p.getEmail() + ")");
                if (nuevoEmail == null) return;

                String nuevaDir = pedirDato("nueva dirección (actual: " + p.getDireccion() + ")");
                if (nuevaDir == null) return;

                p.setTelefono(nuevoTel);
                p.setEmail(nuevoEmail);
                p.setDireccion(nuevaDir);

                JOptionPane.showMessageDialog(null, "Proveedor modificado con éxito.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
    }

    //ELIMINAR PROVEEDOR
    public void eliminarProveedor() {
    if (listaProveedores.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay proveedores para eliminar.");
        return;
    }

    listarProveedores();

    String idTexto = JOptionPane.showInputDialog("Ingrese el ID del proveedor que desea eliminar:");
    if (idTexto == null) {
        JOptionPane.showMessageDialog(null, "Operación cancelada.");
        return;
    }

    int id;
    try {
        id = Integer.parseInt(idTexto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
        return;
    }

    //BUSCAR PROVEEDOR
    Proveedor proveedorAEliminar = null;
    for (Proveedor p : listaProveedores) {
        if (p.getId() == id) {
            proveedorAEliminar = p;
            break;
        }
    }

    if (proveedorAEliminar == null) {
        JOptionPane.showMessageDialog(null, "⚠️ No se encontró un proveedor con ese ID.");
        return;
    }

    // MOSTRAR MENSAJE DE CONFIRMACIÓN
    int confirmacion = JOptionPane.showConfirmDialog(
            null,
            "El proveedor seleccionado es:\n\n" +
            "Nombre: " + proveedorAEliminar.getNombre() + "\n" +
            "CUIT: " + proveedorAEliminar.getCuit() + "\n\n" +
            "¿Estás seguro que quieres eliminarlo?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
    );

    if (confirmacion == JOptionPane.YES_OPTION) {
        listaProveedores.remove(proveedorAEliminar);
        JOptionPane.showMessageDialog(null, "✅ Proveedor eliminado correctamente.");
    } else {
        JOptionPane.showMessageDialog(null, "Operación cancelada. No se eliminó ningún proveedor.");
    }
}


    //MENÚ DE OPCIONES
    public void menuProveedores() {
    int opcion = -1; // <-- inicializada aquí
    do {
        String opcionTexto = JOptionPane.showInputDialog("""
                === MENU PROVEEDORES ===
                1. Alta de proveedor
                2. Listar proveedores
                3. Modificar proveedor
                4. Eliminar proveedor
                0. Salir
                """);

        if (opcionTexto == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return;
        }

        try {
            opcion = Integer.parseInt(opcionTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            continue; // vuelve al inicio del do-while; opcion ya tiene valor (-1) si no se asignó
        }

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


