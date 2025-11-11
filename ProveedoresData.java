/**
 * Clase de manejo de datos y lógica de presentación (UI con JOptionPane) para la gestión
 * de la entidad Proveedores. Actúa como intermediario entre la interfaz de usuario
 * y la capa de acceso a datos (ProveedoresDAO).
 *
 * @author Debuggers UTN - Kevin
 */
package SistemaDeVentas;

import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension; // Importación sugerida para el uso de Dimension

public class ProveedoresData {
    
    /** Instancia del DAO (Data Access Object) para interactuar con la base de datos. */
    private final ProveedoresDAO dao = new ProveedoresDAO();

    /**
     * Solicita repetidamente un dato al usuario hasta que se ingrese un valor no vacío.
     * Gestiona la cancelación de la operación por parte del usuario.
     *
     * @param campo El nombre del campo que se está solicitando (ej. "nombre del proveedor").
     * @return El valor ingresado por el usuario, sin espacios iniciales/finales, o null si la operación es cancelada.
     */
    private String pedirDato(String campo) {
        String valor;
        do {
            // Muestra el cuadro de diálogo de entrada.
            valor = JOptionPane.showInputDialog("Ingrese " + campo + ":");
            
            if (valor == null) { 
                // El usuario presionó "Cancelar" o cerró la ventana.
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return null;
            } else if (valor.trim().isEmpty()) { 
                // El usuario dejó el campo vacío.
                JOptionPane.showMessageDialog(null, "Escribe el " + campo + ".");
            }
        } while (valor.trim().isEmpty());
        return valor.trim();
    }

    /**
     * Permite al usuario dar de alta un nuevo proveedor.
     * Solicita todos los datos del proveedor mediante cuadros de diálogo,
     * crea un objeto Proveedores y llama al DAO para persistirlo.
     * La operación se aborta si el usuario cancela en cualquier paso.
     */
    public void altaProveedor() {
        try {
            // Se utiliza 'pedirDato' para asegurar que los campos no estén vacíos y para manejar la cancelación.
            String nombre = pedirDato("nombre del nuevo proveedor");
            if (nombre == null) return;

            String telefono = pedirDato("teléfono del proveedor");
            if (telefono == null) return;

            String correo = pedirDato("Correo del proveedor");
            if (correo == null) return;

            String direccion = pedirDato("dirección del proveedor");
            if (direccion == null) return;

            String representante = pedirDato("nombre del representante");
            if (representante == null) return;

            String tipoProductos = pedirDato("tipo de productos que provee");
            if (tipoProductos == null) return;

            // El ID se pasa como 0 ya que se espera que la base de datos lo asigne automáticamente.
            Proveedores p = new Proveedores(0, nombre, telefono, correo, direccion, representante, tipoProductos);
            dao.agregarProveedor(p);
            JOptionPane.showMessageDialog(null, "Proveedor agregado correctamente.");
        } catch (Exception e) {
            // Captura cualquier error, típicamente errores de conexión o del DAO.
            JOptionPane.showMessageDialog(null, "Error al ingresar datos: " + e.getMessage());
        }
    }

    /**
     * Recupera y muestra la lista completa de proveedores en un formato tabular.
     * Utiliza un JTextArea con fuente monoespaciada dentro de un JScrollPane
     * para asegurar la correcta alineación y manejo de muchos registros.
     */
    public void listarProveedores() {
        List<Proveedores> lista = dao.listarTodos(); // Llama al DAO para obtener todos los registros.
        
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proveedores registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Construcción del encabezado de la tabla, con espaciado fijo.
        sb.append("=================================================================================================================================\n");
        sb.append(String.format("| %-3s | %-25s | %-11s | %-20s | %-38s | %-15s |\n",
                "ID", "NOMBRE", "Teléfono", "Correo", "Dirección", "Representante", "Tipo de Productos")); // Se corrigió el formato para 7 columnas.
        sb.append("---------------------------------------------------------------------------------------------------------------------------------\n");

        // Formato de cada registro.
        for (Proveedores p : lista) {
            sb.append(String.format("| %-3d | %-25s | %-11s | %-20s | %-38s | %-15s |\n",
                    p.getId(), p.getNombre(), p.getTelefono(), p.getCorreo(), p.getDireccion(), 
                    p.getRepresentante(), p.getTipoProductos())); // Se corrigió la lista de getters para 7 campos.
        }
        sb.append("---------------------------------------------------------------------------------------------------------------------------------\n");
        
        // Configuración y visualización del JTextArea dentro de un ScrollPane.
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 11)); // Esencial para la alineación.
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(1000, 400)); // Se ajustó el tamaño para mostrar todas las columnas.
        JOptionPane.showMessageDialog(null, scrollPane, "=== Lista de Proveedores ===", JOptionPane.INFORMATION_MESSAGE);
    }
        
    /**
     * Permite al usuario modificar un proveedor existente.
     * Solicita el ID, busca el proveedor, y luego solicita individualmente los
     * nuevos valores, manteniendo el valor anterior por defecto.
     */
    public void modificarProveedor() {
        // 1. Solicita el ID del proveedor.
        String input = JOptionPane.showInputDialog("ID del proveedor a modificar:");
        if (input == null) {
            return; // El usuario pulsó Cancelar o cerró la ventana.
        }

        int id;
        try {
            // 2. Valida que el ID sea un número válido.
            id = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "El ID debe ser un número entero válido.", 
                "Error de Formato", 
                JOptionPane.ERROR_MESSAGE
            );
            return; 
        }

        // 3. Busca el proveedor en la base de datos.
        Proveedores p = dao.buscarPorId(id);
        if (p == null) {
            JOptionPane.showMessageDialog(null, 
                "Proveedor con ID " + id + " no encontrado.", 
                "Búsqueda Fallida", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 4. Solicita nuevos datos, mostrando el valor actual (default) y actualizando
        // solo si el usuario ingresa un valor no vacío.

        // Nombre
        String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre (actual: " + p.getNombre() + "):", p.getNombre());
        if (nuevoNom == null) return; // Cancelar
        if (!nuevoNom.trim().isEmpty()) {
            p.setNombre(nuevoNom.trim());
        }
        
        // Telefono
        String nuevoTel = JOptionPane.showInputDialog("nuevo teléfono (actual: " + p.getTelefono() + "):", p.getTelefono());
        if (nuevoTel == null) return; // Cancelar
        if (!nuevoTel.trim().isEmpty()) { 
            p.setTelefono(nuevoTel.trim());
        } 

        // Correo
        String nuevoCor = JOptionPane.showInputDialog("nuevo correo (actual: " + p.getCorreo() + "):", p.getCorreo());
        if (nuevoCor == null) return; 
        if (!nuevoCor.trim().isEmpty()) {
            p.setCorreo(nuevoCor.trim());
        }
        
        // Direccion
        String nuevaDir = JOptionPane.showInputDialog("nueva dirección (actual: " + p.getDireccion() + "):", p.getDireccion());
        if (nuevaDir == null) return; 
        if (!nuevaDir.trim().isEmpty()) {
            p.setDireccion(nuevaDir.trim());
        }

        // Representante
        String nuevoRep = JOptionPane.showInputDialog("nuevo representante (actual: " + p.getRepresentante() + "):", p.getRepresentante());
        if (nuevoRep == null) return; 
        if (!nuevoRep.trim().isEmpty()) {
            p.setRepresentante(nuevoRep.trim());
        }

        // Tipo Productos
        String nuevoTPro = JOptionPane.showInputDialog("Tipo de productos (actual: " + p.getTipoProductos() + "):", p.getTipoProductos());
        if (nuevoTPro == null) return; 
        if (!nuevoTPro.trim().isEmpty()) {
            p.setTipoProductos(nuevoTPro.trim());
        }
        
        // El ID no necesita ser re-asignado, ya está en el objeto 'p'.
        
        // 5. Llama al DAO para persistir los cambios.
        if (dao.modificarProveedor(p)) {
            JOptionPane.showMessageDialog(null, "Proveedor modificado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar proveedor.");
        }
    }

    /**
     * Muestra el menú principal de opciones para la gestión de proveedores.
     * Se ejecuta en un bucle 'do-while' hasta que el usuario selecciona la opción '0' (Salir).
     * Delega las acciones a los métodos correspondientes (alta, listar, modificar).
     */
    public void ejecutarMenu() {
        int opcion = -1; 
        do {
            String opcionTexto = JOptionPane.showInputDialog("""
                    === MENU PROVEEDORES ===
                    1. Alta de proveedor
                    2. Listar proveedores
                    3. Modificar proveedor
                    0. Salir
                    """);

            // Manejo de la acción de Cancelar o cerrar el diálogo.
            if (opcionTexto == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return; // Sale del método principal.
            }

            try {
                // Intenta convertir la entrada de texto a un número entero.
                opcion = Integer.parseInt(opcionTexto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                continue; // Vuelve al inicio del bucle para pedir la opción de nuevo.
            }

            // Manejo de la opción seleccionada.
            switch (opcion) {
                case 1 -> altaProveedor();
                case 2 -> listarProveedores();
                case 3 -> modificarProveedor();
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del módulo de proveedores...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente.");
            }
        } while (opcion != 0);
    }
}